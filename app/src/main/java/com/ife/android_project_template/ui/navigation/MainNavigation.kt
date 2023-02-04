
package com.ife.android_project_template.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ife.android_project_template.R
import com.ife.android_project_template.ui.components.topBar.TopBar
import com.ife.android_project_template.ui.destinations.MainScreen
import com.ife.android_project_template.ui.destinations.SecondaryScreen
import com.ife.android_project_template.ui.navigation.NavigationHelper.Destinations.MAIN_SCREEN
import com.ife.android_project_template.ui.navigation.NavigationHelper.Destinations.SECONDARY_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation(navController: NavHostController) {

    val topBarModifier: Modifier = Modifier.padding(dimensionResource(id = R.dimen.top_bar_padding))

    NavHost(navController = navController, startDestination = MAIN_SCREEN) {
        composable(MAIN_SCREEN) {
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
                    navController = navController,
                    topBarPadding = contentPadding.calculateTopPadding().value.toInt().dp,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.space_medium))
                )
            }
        }

        composable(SECONDARY_SCREEN) {
            Scaffold(
                topBar = {
                    TopBar(
                        modifier = topBarModifier,
                        navController = navController,
                        title = stringResource(id = R.string.secondary_screen),
                        navigationIcon = if(navController.previousBackStackEntry != null){
                            R.drawable.back
                        } else {
                            null
                        }
                    )
                }
            ) { contentPadding ->
                SecondaryScreen(
                    topBarPadding = contentPadding.calculateTopPadding().value.toInt().dp,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.space_medium))
                )
            }
        }
    }
}