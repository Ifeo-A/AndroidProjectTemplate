package com.ife.android_project_template.ui.components.topBar

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ife.android_project_template.R
import com.ife.android_project_template.ui.theme.AndroidProjectTemplateTheme

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
            modifier = modifier
                .height(dimensionResource(id = R.dimen.top_bar_height))
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

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                textAlign = TextAlign.Center,
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

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun TopBarPreviewWithIcon() {
    AndroidProjectTemplateTheme() {
        TopBar(
            navController = rememberNavController(),
            title = "Main Screen",
            navigationIcon = R.drawable.back
        )
    }
}