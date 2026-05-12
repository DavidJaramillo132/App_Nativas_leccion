package com.david.leccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//My imports
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.david.leccion.data.Catalogo
import com.david.leccion.data.ColeccionesCatalogo
import com.david.leccion.ui.navigation.AppScreen
import com.david.leccion.ui.screen.catalog.CatalogItemCard
import com.david.leccion.ui.screen.catalog.CatalogScreen
import com.david.leccion.ui.screen.detail.DetailScreen
import com.david.leccion.ui.screen.home.HomeScreen
import com.david.leccion.ui.theme.LeccionTheme
import androidx.compose.ui.graphics.Color
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeccionTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(AppScreen.HOME) }
    var selectedItem by remember { mutableStateOf<Catalogo?>(null) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
//        containerColor = MaterialTheme.colorScheme.onSurface,
        topBar = {
            NavbarUp(
                currentScreen = currentScreen,
                onBackClick = {
                    when (currentScreen) {
                        AppScreen.DETAIL -> currentScreen = AppScreen.CATALOG
                        AppScreen.CATALOG -> currentScreen = AppScreen.HOME
                        else -> {}
                    }
                }
            )
        }
    ) { innerPadding ->
        when (currentScreen) {
            AppScreen.HOME -> HomeScreen(
                modifier = Modifier.padding(innerPadding),
                onVerCatalogoClick = {
                    currentScreen = AppScreen.CATALOG
                }
            )

            AppScreen.CATALOG -> CatalogScreen(
                articulos = ColeccionesCatalogo,
                onArticuloClick = { articulo ->
                    selectedItem = articulo
                    currentScreen = AppScreen.DETAIL
                },
                modifier = Modifier.padding(innerPadding)
            )

            AppScreen.DETAIL -> selectedItem?.let { articulo ->
                DetailScreen(
                    articulo = articulo,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

// Preview functions
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LeccionTheme {
        HomeScreen(onVerCatalogoClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogItemPreview() {
    LeccionTheme {
        CatalogItemCard(
            articulo = ColeccionesCatalogo[0],
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    LeccionTheme {
        DetailScreen(articulo = ColeccionesCatalogo[0])
    }
}
