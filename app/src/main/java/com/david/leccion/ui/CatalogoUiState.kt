package com.david.leccion.ui

import com.david.leccion.data.Catalogo
import com.david.leccion.ui.navigation.AppScreen

data class CatalogoUiState(
    val catalogItems: List<Catalogo> = emptyList(),
    val selectedItem: Catalogo? = null,
    val currentScreen: AppScreen = AppScreen.HOME
)