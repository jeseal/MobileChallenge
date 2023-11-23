package com.jeseal.mobilechallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterDetailScreen(
    state: HomeViewModel.CharactersState
) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(state.selectedCharacter?.image),
                contentDescription = "Character Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop,
            )
            state.selectedCharacter?.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.species?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.location?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.gender?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.status?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.origin?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            state.selectedCharacter?.type?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}