package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mindera.rocketscience.R
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun LaunchDetailsDialog(viewModel: DashboardView) {
    Dialog(
        onDismissRequest = {
            viewModel.onLaunchDetailsDialogDismissed()
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
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
            ) {
                createUrl(
                    stringResource(id = R.string.articles),
                    viewModel.launchDetailsLinksModel.value.articles
                )
                createUrl(
                    stringResource(id = R.string.wikipedia),
                    viewModel.launchDetailsLinksModel.value.wikipedia
                )
                createUrl(
                    stringResource(id = R.string.video_pages),
                    viewModel.launchDetailsLinksModel.value.videoPages
                )
            }
        }
    }
}

@Composable
private fun createUrl(s: String, url: String) {
    val uriHandler = LocalUriHandler.current
    val annotatedLinkString = buildAnnotatedString {
        val str = s
        val startIndex = 0
        val endIndex = str.length
        append(str)
        addStyle(
            style = SpanStyle(
                color = androidx.compose.ui.graphics.Color.Blue,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline

            ), start = startIndex, end = endIndex
        )
        addStringAnnotation(
            tag = "URL",
            annotation = url,
            start = startIndex,
            end = endIndex
        )
    }
    ClickableText(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}