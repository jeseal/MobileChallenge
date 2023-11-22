package com.jeseal.mobilechallenge

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jeseal.mobilechallenge.ui.screen.CharacterDetailScreen
import com.jeseal.mobilechallenge.ui.screen.HomeScreen
import com.jeseal.mobilechallenge.ui.screen.HomeViewModel

enum class CharacterScreen() {
    Characters,
    CharacterDetail
}


@ExperimentalMaterial3Api
@Composable
fun CharacterAppBar(
    canNavigateBack: Boolean, navigateUp: () -> Unit, modifier: Modifier = Modifier
) {
    TopAppBar(title = { Text(stringResource(id = R.string.app_name)) },
        colors = mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterApp(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {

    Scaffold(topBar = {
        CharacterAppBar(canNavigateBack = false,
            navigateUp = { /* TODO: implement back navigation */ })
    }) { innerPadding ->
        val uiState by viewModel.state.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CharacterScreen.Characters.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = CharacterScreen.Characters.name) {
                HomeScreen(
                    state = uiState,
                    onNavigateToCharacterDetail = {
                        viewModel.setCharacter(it)
                        navController.navigate(CharacterScreen.CharacterDetail.name)
                    }
                )
            }
            composable(route = CharacterScreen.CharacterDetail.name) {
                CharacterDetailScreen(
                )
            }
        }
    }
}