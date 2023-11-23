package com.jeseal.mobilechallenge.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeseal.domain.interactor.GetCharacterUseCase
import com.jeseal.domain.interactor.GetCharactersUseCase
import com.jeseal.domain.model.Character
import com.jeseal.domain.model.DetailedCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            _state.update {
                it.copy(
                    characters = getCharactersUseCase.invoke(),
                    isLoading = false
                )
            }
        }
    }

    fun setCharacter(character: String?) {
        viewModelScope.launch {
            _state.update { it.copy(
                selectedCharacter = getCharacterUseCase.invoke(character)
            ) }
        }
    }

    data class CharactersState(
        val characters: List<Character?> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCharacter: DetailedCharacter? = null
    )
}