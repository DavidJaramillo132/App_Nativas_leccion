package com.david.leccion.ui

import androidx.lifecycle.ViewModel
import com.david.leccion.data.Catalogo
import com.david.leccion.data.ColeccionesCatalogo
import com.david.leccion.ui.navigation.AppScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CatalogoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CatalogoUiState(catalogItems = ColeccionesCatalogo))
    val uiState: StateFlow<CatalogoUiState> = _uiState.asStateFlow()

    fun navigateTo(screen: AppScreen){
        _uiState.update {
            it.copy(currentScreen = screen)
        }
    }

    fun selectItem(item: Catalogo) {
        _uiState.update {
            it.copy(selectedItem = item, currentScreen = AppScreen.DETAIL)
        }
    }
    fun goBack() {
        _uiState.update {
            when (it.currentScreen) {
                AppScreen.DETAIL -> it.copy(selectedItem = null, currentScreen = AppScreen.CATALOG)
                AppScreen.CATALOG -> it.copy(currentScreen = AppScreen.HOME)
                else -> it
            }
        }
    }

}