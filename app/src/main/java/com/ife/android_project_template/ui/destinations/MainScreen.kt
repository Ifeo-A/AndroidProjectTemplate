package com.ife.android_project_template.ui.destinations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.ife.android_project_template.ui.navigation.NavigationHelper.Destinations.SECONDARY_SCREEN


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
        Button(onClick = { navController.navigate(SECONDARY_SCREEN) }) {
            Text(text = "Go to Secondary Screen")
        }
    }
}