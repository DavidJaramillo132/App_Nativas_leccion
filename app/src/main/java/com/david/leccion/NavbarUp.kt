package com.david.leccion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.david.leccion.ui.navigation.AppScreen
import androidx.compose.material3.ListItemDefaults.contentColor
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

    val navColor = when (currentScreen) {
        AppScreen.HOME -> Color(0xFF0D61D0)
        AppScreen.CATALOG -> Color(0xFFFFFFFF)
        AppScreen.DETAIL -> Color(0xFFFFFFFF)
    }

    val contentColor = when (currentScreen) {
        AppScreen.HOME -> Color.White
        AppScreen.CATALOG -> Color.Black
        AppScreen.DETAIL -> Color.Black
    }

    Surface(
        modifier = modifier,
        color = navColor,
        shadowElevation = 4.dp
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = navColor,
                titleContentColor = contentColor,
                navigationIconContentColor = contentColor
            ),
            title = {
                Text(
                    text = titulo,
                    fontWeight = FontWeight.SemiBold
                )
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
}
