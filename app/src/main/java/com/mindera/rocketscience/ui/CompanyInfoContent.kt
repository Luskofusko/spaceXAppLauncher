package com.mindera.rocketscience.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mindera.rocketscience.R
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun CompanyInfoContent(viewModel: DashboardView) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Text(
            text = stringResource(
                id = R.string.company_description,
                viewModel.companyInfoModel.value.companyName,
                viewModel.companyInfoModel.value.founderName,
                viewModel.companyInfoModel.value.year,
                viewModel.companyInfoModel.value.employees,
                viewModel.companyInfoModel.value.launchSites,
                viewModel.companyInfoModel.value.valuation
            ), style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.onBackground)
        )
    }
}

