package com.mindera.rocketscience.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mindera.rocketscience.R
import com.mindera.rocketscience.model.LaunchModel
import com.mindera.rocketscience.model.LinksModel
import com.mindera.rocketscience.presentation.theme.SpaceXLauncherTheme
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun LaunchContent(launchModel: LaunchModel, index: Int) {
    Row {
        Image(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(48.dp),
            painter = rememberAsyncImagePainter(launchModel.missionPatchImageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.mission))
            Text(text = stringResource(id = R.string.date_time))
            Text(text = stringResource(id = R.string.rocket))
            Text(text = stringResource(id = R.string.days_since_from_now, sinceOrFrom(launchModel.days)))
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Column(
            modifier = Modifier
                .weight(1.5f)
                .padding(start = 8.dp, bottom = 16.dp)
        ) {
            Text(text = launchModel.missionName, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = stringResource(id = R.string.date_at_time, launchModel.date, launchModel.time))
            Text(text = launchModel.rocketName)
            Text(text = launchModel.days.toString())
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Icon(
                painter = painterResource(id = if (launchModel.launchSuccess) R.drawable.baseline_check_60 else R.drawable.baseline_close_60),
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(48.dp)
            )
        }
            
    }
}

@Preview
@Composable
fun LaunchContentPreview() {
    SpaceXLauncherTheme {
        LaunchContent(newLaunchModel(), 0)
    }
}

fun newLaunchModel(): LaunchModel {
    return LaunchModel(
        "missionName",
        12345600000000,
        "2132/7/14",
        "12:00",
        "rocketName",
        "rocketType",
        "missionPatchImageUrl",
        true,
        123456,
        LinksModel("articleLink", "wikipediaLink", "videoLink"),
        0
    )
}