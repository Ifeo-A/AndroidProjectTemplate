package com.ife.android_project_template.feature_example_secondary_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ife.android_project_template.core_ui.components.topBar.TopBar
import com.ife.android_project_template.core_ui.theme.AndroidProjectTemplateTheme


@Composable
fun SecondaryScreen(
    modifier: Modifier = Modifier,
    topBarPadding: Dp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = topBarPadding)
            .fillMaxWidth()
    ) {
        Text(text = "Secondary Screen Body")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun SecondaryScreenPreview() {
    val topBarModifier: Modifier = Modifier.padding(16.dp)

    AndroidProjectTemplateTheme() {
        Scaffold(
            topBar = {
                TopBar(
                    modifier = topBarModifier,
                    navController = null,
                    title = stringResource(id = R.string.secondary_screen)
                )
            }
        ) { contentPadding ->
            SecondaryScreen(
                topBarPadding = contentPadding.calculateTopPadding().value.toInt().dp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}