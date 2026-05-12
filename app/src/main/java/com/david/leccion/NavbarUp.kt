package com.david.leccion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.david.leccion.ui.navigation.AppScreen
import androidx.compose.material3.MaterialTheme
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
        AppScreen.CATALOG -> MaterialTheme.colorScheme.onPrimary
        AppScreen.DETAIL -> MaterialTheme.colorScheme.onPrimary
    }

    val contentColor = when (currentScreen) {
        AppScreen.HOME -> Color(0xFFFFFFFF)
        AppScreen.CATALOG -> MaterialTheme.colorScheme.onSurface
        AppScreen.DETAIL -> MaterialTheme.colorScheme.onSurface
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
                    fontWeight = FontWeight.SemiBold,
//                    color = MaterialTheme.colorScheme.onSurface
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
