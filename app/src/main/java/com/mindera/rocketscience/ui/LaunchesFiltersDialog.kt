package com.mindera.rocketscience.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mindera.rocketscience.R
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun LaunchesFiltersDialog(viewModel: DashboardView) {
    Dialog(
        onDismissRequest = { 
            viewModel.onLauncherFilterDialogDismissed() 
        }, 
        properties = DialogProperties(
            dismissOnClickOutside = true
        )
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(size = 10.dp)
        ) {
            Row(modifier = Modifier.padding(all = 16.dp)) {
                Column(modifier = Modifier.weight(0.8f)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        itemsIndexed(viewModel.launchYearButtonStates.value) { index, launchYearButtonState ->
                            ConstraintLayout {
                                val (checkBoxC, textC) = createRefs()

                                Checkbox(
                                    checked = launchYearButtonState.checked,
                                    onCheckedChange = { viewModel.onFilterYearButtonClick(index) },
                                    modifier = Modifier.constrainAs(checkBoxC) {
                                        start.linkTo(parent.start)
                                    }
                                )
                                Text(
                                    text = launchYearButtonState.year.toString(),
                                    modifier = Modifier.constrainAs(textC) {
                                        linkTo(top = checkBoxC.top, bottom = checkBoxC.bottom)
                                        start.linkTo(checkBoxC.end)
                                    }
                                )
                            }

                        }
                    }
                    ConstraintLayout {
                        val (checkBoxC, textC) = createRefs()

                        Checkbox(
                            checked = viewModel.showOnlySuccessfulLaunches.value,
                            onCheckedChange = { viewModel.onShowOnlySuccessfulLaunches(it) },
                            modifier = Modifier.constrainAs(checkBoxC) {
                                linkTo(top = parent.top, bottom = parent.bottom, topMargin = 16.dp)
                            }
                        )
                        Text(
                            text = stringResource(id = R.string.show_only_successful_launches),
                            modifier = Modifier.constrainAs(textC) {
                                start.linkTo(checkBoxC.end)
                                linkTo(top = checkBoxC.top, bottom = checkBoxC.bottom)
                            }
                        )
                    }

                }
                Column(
                    modifier = Modifier.weight(0.2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.sort_by),
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    IconButton(
                        onClick = { viewModel.onSortAscendingClick() }
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(48.dp),
                            painter = painterResource(id = R.drawable.baseline_sort_by_alpha_48),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    IconButton(
                        onClick = { viewModel.onSortDescendingClick() }
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(48.dp),
                            painter = painterResource(id = R.drawable.baseline_sort_by_alpha_48),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                }
            }
        }
    }
}