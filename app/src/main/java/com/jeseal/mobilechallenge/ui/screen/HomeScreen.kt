package com.jeseal.mobilechallenge.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeseal.domain.model.Character

@Composable
fun CharactersScreen(
    state: HomeViewModel.CharactersState,
    onSelectCountry: (code: String?) -> Unit= {},
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if(state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.characters) { character ->
                    CountryItem(
                        character = character,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectCountry(character?.name) }
                            .padding(16.dp)
                    )
                }
            }

        }
    }
}

@Composable
private fun CountryItem(
    character: Character?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        character?.name?.let {
            Text(
                text = it,
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            character?.id?.let {
                Text(
                    text = it,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            character?.species?.let { Text(text = it) }
        }
    }
}
