package com.ife.android_project_template.core_ui.components.topBar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ife.android_project_template.core_ui.theme.AndroidProjectTemplateTheme

@Composable
fun TopBar(
    navController: NavHostController?,
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: Int? = null
) {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = modifier
        ) {
            if (navigationIcon != null) {
                IconButton(
                    onClick = { navController?.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = navigationIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
        ){
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun TopBarPreview() {
    AndroidProjectTemplateTheme() {
        TopBar(
            navController = rememberNavController(),
            title = "Main Screen"
        )
    }
}