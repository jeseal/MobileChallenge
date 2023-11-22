package com.jeseal.mobilechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jeseal.mobilechallenge.ui.screen.CharactersScreen
import com.jeseal.mobilechallenge.ui.screen.HomeViewModel
import com.jeseal.mobilechallenge.ui.theme.MobileChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileChallengeTheme {
                val viewModel = hiltViewModel<HomeViewModel>()
                val state by viewModel.state.collectAsState()
                CharactersScreen(
                    state = state
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileChallengeTheme {
        Greeting("Android")
    }
}