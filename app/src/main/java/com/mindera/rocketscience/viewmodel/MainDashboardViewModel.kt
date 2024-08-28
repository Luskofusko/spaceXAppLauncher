package com.mindera.rocketscience.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mindera.rocketscience.domain.usecase.AllLaunchesUseCase
import com.mindera.rocketscience.domain.usecase.GetCompanyInfoUseCase
import com.mindera.rocketscience.domain.usecase.GetCurrentTimeInMillisUseCase
import com.mindera.rocketscience.mapper.toPresentation
import com.mindera.rocketscience.model.CompanyInfoModel
import com.mindera.rocketscience.model.LaunchModel
import com.mindera.rocketscience.model.LinksModel
import com.mindera.rocketscience.rx.SchedulerProvider
import com.mindera.rocketscience.viewmodel.state.LaunchYearButtonState
import com.mindera.rocketscience.viewmodel.state.MainUiStateController
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class MainDashboardViewModel(
    getCompanyInfoUseCase: GetCompanyInfoUseCase,
    schedulerProvider: SchedulerProvider,
    private val allLaunchesUseCase: AllLaunchesUseCase,
    private val getCurrentTimeInMillisUseCase: GetCurrentTimeInMillisUseCase
): BaseViewModel(schedulerProvider), DashboardView {

    private val _mainUiStateController = MainUiStateController()
    override val mainUiStateController = _mainUiStateController.uiState

    private val _companyInfoModel = mutableStateOf(CompanyInfoModel("", "", 0, 0, 0, "0"))
    override val companyInfoModel: State<CompanyInfoModel> = _companyInfoModel

    private val _allLaunches = mutableStateOf(emptyList<LaunchModel>())

    private val _filteredAllLaunches = mutableStateOf(emptyList<LaunchModel>())
    override val filteredAllLaunches: State<List<LaunchModel>> = _filteredAllLaunches

    private val _launchDetailsLinksModel = mutableStateOf(LinksModel("", "", ""))
    override val launchDetailsLinksModel: State<LinksModel> = _launchDetailsLinksModel

    private val _launchYearButtonStates = mutableStateOf(emptyList<LaunchYearButtonState>())
    override val launchYearButtonStates: State<List<LaunchYearButtonState>> = _launchYearButtonStates

    private val _showOnlySuccessfulLaunches = mutableStateOf(false)
    override val showOnlySuccessfulLaunches: State<Boolean> = _showOnlySuccessfulLaunches

    override var sortAsc = false

    init {
        getCompanyInfo(getCompanyInfoUseCase)
        getLaunches()
    }

    override fun onLaunchDetailsDialogDismissed() {
        _mainUiStateController.ready()
    }

    override fun onLaunchClick(index: Int) {
        _launchDetailsLinksModel.value = _filteredAllLaunches.value[index].linksModel
        _mainUiStateController.showLaunchDetailsDialog()
    }

    override fun onLauncherFilterDialogDismissed() {
        _mainUiStateController.ready()
    }

    override fun onFilterClick() {
        _mainUiStateController.showLaunchesFilters()
    }

    override fun onFilterYearButtonClick(index: Int) {
        _launchYearButtonStates.value = switchLaunchYearEnabled(index)
        applyFilters()
    }

    override fun onShowOnlySuccessfulLaunches(checked: Boolean) {
        _showOnlySuccessfulLaunches.value = checked
        applyFilters()
    }

    private fun getCompanyInfo(getCompanyInfoUseCase: GetCompanyInfoUseCase) {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }) {
            val companyInfo = getCompanyInfoUseCase.getCompanyInfo()
            _companyInfoModel.value = companyInfo.toPresentation()
        }
    }

    private fun getLaunches() {
        viewModelScope.launch {
            allLaunchesUseCase.allLaunches()
                .catch { _mainUiStateController.showErrorGettingAllLaunches() }.onEach { launchDtos ->
                    _allLaunches.value = launchDtos.toPresentation(getCurrentTimeInMillisUseCase.execute())
                    _launchYearButtonStates.value = _allLaunches.value.toLaunchYears()
                    applyFilters()
                }.collectLatest {  }
        }
    }

    private fun handleError(throwable: Throwable) {
        _mainUiStateController.showErrorGettingCompanyInfo()
    }

    private fun applyFilters() {
        val filtered = _allLaunches.value.filter { isEnabledYear(it) }.filter { isShowOnlySuccessfulLaunches(it) }

        if (sortAsc) {
            _filteredAllLaunches.value = filtered.sortedBy { it.launchTimestamp }
        } else {
            _filteredAllLaunches.value = filtered.sortedByDescending { it.launchTimestamp }
        }

    }

    private fun isShowOnlySuccessfulLaunches(launchModel: LaunchModel): Boolean {
        if (_showOnlySuccessfulLaunches.value) {
            return launchModel.launchSuccess
        } else {
            return true
        }
    }

    private fun isEnabledYear(launchModel: LaunchModel): Boolean {
        val year = dateToCalendar(Date(launchModel.launchTimestamp)).get(Calendar.YEAR)
        return launchYearButtonStates.value.any { it.year == year && it.checked }
    }

    private fun switchLaunchYearEnabled(index: Int): MutableList<LaunchYearButtonState> {
        val newLaunchYearButtonStates = mutableListOf<LaunchYearButtonState>()
        newLaunchYearButtonStates.addAll(launchYearButtonStates.value)
        val oldLaunchYearButtonState = launchYearButtonStates.value[index]
        val newLaunchYearButtonState = LaunchYearButtonState(!oldLaunchYearButtonState.checked, oldLaunchYearButtonState.year)
        newLaunchYearButtonStates[index] = newLaunchYearButtonState
        return newLaunchYearButtonStates
    }

    override fun onSortAscendingClick() {
        sortAsc = true
        applyFilters()
    }

    override fun onSortDescendingClick() {
        sortAsc = false
        applyFilters()
    }

    override fun onErrorDismiss() {
        _mainUiStateController.ready()
    }

    override fun onErrorOkButton() {
        _mainUiStateController.ready()
    }

    private fun dateToCalendar(date: Date): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar
    }

    private fun List<LaunchModel>.toLaunchYears(): List<LaunchYearButtonState> {
        return map {
            LaunchYearButtonState(true, dateToCalendar(Date(it.launchTimestamp)).get(Calendar.YEAR))
        }.toSet().toList()
    }

}