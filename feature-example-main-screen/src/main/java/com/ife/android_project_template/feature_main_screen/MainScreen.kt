package com.ife.android_project_template.feature_main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ife.android_project_template.core_ui.components.topBar.TopBar
import com.ife.android_project_template.core_ui.theme.AndroidProjectTemplateTheme
import com.ife.android_project_template.core_utils.navigation.NavigationHelper.Destinations.SECONDARY_SCREEN
import com.ife.android_project_template.feature_example_main_screen.R

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    topBarPadding: Dp,
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = topBarPadding)
    ) {
        Text(text = "Main Screen Body")
        Button(onClick = {
            navController.navigate(SECONDARY_SCREEN)
        }) {
            Text(text = "Go to Secondary Screen")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun MainScreenPreview() {

    val topBarModifier: Modifier = Modifier.padding(16.dp)

    AndroidProjectTemplateTheme() {
        Scaffold(
            topBar = {
                TopBar(
                    modifier = topBarModifier,
                    navController = null,
                    title = stringResource(id = R.string.main_screen)
                )
            }
        ) { contentPadding ->
            MainScreen(
                navController = rememberNavController(),
                topBarPadding = contentPadding.calculateTopPadding().value.toInt().dp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}