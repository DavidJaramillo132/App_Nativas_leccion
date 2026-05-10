package com.david.leccion.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.david.leccion.data.Catalogo

@Composable
fun DetailScreen(
    articulo: Catalogo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = articulo.imageResourceId),
            contentDescription = stringResource(id = articulo.name),
            modifier = Modifier
                .size(130.dp)
                .padding(12.dp)
        )

        Text(
            text = stringResource(id = articulo.name),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(18.dp))

        DetailRow("Nombre:", stringResource(id = articulo.name))
        DetailRow("Precio:", "$${articulo.price}")
        DetailRow("Descripcion:", stringResource(id = articulo.descripcion))

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }) {
            Text(text = "Anadir a Favoritos")
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}