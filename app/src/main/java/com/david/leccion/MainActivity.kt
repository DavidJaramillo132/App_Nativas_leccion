package com.david.leccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.david.leccion.data.ColeccionesCatalogo
import com.david.leccion.ui.CatalogoViewModel
import com.david.leccion.ui.navigation.AppScreen
import com.david.leccion.ui.screen.catalog.CatalogItemCard
import com.david.leccion.ui.screen.catalog.CatalogScreen
import com.david.leccion.ui.screen.detail.DetailScreen
import com.david.leccion.ui.screen.home.HomeScreen
import com.david.leccion.ui.theme.LeccionTheme

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
fun App(viewModel: CatalogoViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BackHandler(uiState.currentScreen != AppScreen.HOME) {
        viewModel.goBack()
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            NavbarUp(
                currentScreen = uiState.currentScreen,
                onBackClick = { viewModel.goBack() }
            )
        }
    ) { innerPadding ->
        when (uiState.currentScreen) {
            AppScreen.HOME -> HomeScreen(
                modifier = Modifier.padding(innerPadding),
                onVerCatalogoClick = {
                    viewModel.navigateTo(AppScreen.CATALOG)
                }
            )

            AppScreen.CATALOG -> CatalogScreen(
                articulos = uiState.catalogItems,
                onArticuloClick = { articulo ->
                    viewModel.selectItem(articulo)
                },
                modifier = Modifier.padding(innerPadding)
            )

            AppScreen.DETAIL -> uiState.selectedItem?.let { articulo ->
                DetailScreen(
                    articulo = articulo,
                    onAddToFavorites = { },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

// Preview functions
@Preview(showBackground = true)
@Composable
fun NavbarUpHomePreview() {
    LeccionTheme {
        NavbarUp(onBackClick = {}, currentScreen = AppScreen.HOME)
    }
}
@Preview(showBackground = true)
@Composable
fun NavbarUpCatalogPreview() {
    LeccionTheme {
        NavbarUp(onBackClick = {}, currentScreen = AppScreen.CATALOG)
    }
}
@Preview(showBackground = true)
@Composable
fun NavbarUpDetailPreview() {
    LeccionTheme {
        NavbarUp(onBackClick = {}, currentScreen = AppScreen.DETAIL)
    }
}

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
        DetailScreen(articulo = ColeccionesCatalogo[0], onAddToFavorites = {})
    }
}
