package com.david.leccion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.david.leccion.ui.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavbarUp(
    currentScreen: AppScreen,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val titulo = when (currentScreen) {
        AppScreen.HOME -> "Catalogia"
        AppScreen.CATALOG -> "Explora Colecciones"
        AppScreen.DETAIL -> "Detalle del Articulo"
    }

    TopAppBar(
        title = {
            Text(text = titulo, fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            if (currentScreen != AppScreen.HOME) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar"
                    )
                }
            }
        },
        modifier = modifier
    )
}