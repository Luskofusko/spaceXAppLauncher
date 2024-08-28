package com.mindera.rocketscience.viewmodel

import androidx.compose.runtime.State
import com.mindera.rocketscience.model.CompanyInfoModel
import com.mindera.rocketscience.model.LaunchModel
import com.mindera.rocketscience.model.LinksModel
import com.mindera.rocketscience.viewmodel.state.LaunchYearButtonState
import com.mindera.rocketscience.viewmodel.state.MainUiStateController

interface DashboardView {
    val mainUiStateController: State<MainUiStateController.UiState>
    val companyInfoModel: State<CompanyInfoModel>
    val filteredAllLaunches: State<List<LaunchModel>>
    val launchDetailsLinksModel: State<LinksModel>
    val launchYearButtonStates: State<List<LaunchYearButtonState>>
    val showOnlySuccessfulLaunches: State<Boolean>
    var sortAsc: Boolean

    fun onLaunchDetailsDialogDismissed()
    fun onLaunchClick(index: Int)
    fun onLauncherFilterDialogDismissed()
    fun onFilterClick()
    fun onFilterYearButtonClick(index: Int)
    fun onShowOnlySuccessfulLaunches(checked: Boolean)
    fun onSortAscendingClick()
    fun onSortDescendingClick()
    fun onErrorDismiss()
    fun onErrorOkButton()

}