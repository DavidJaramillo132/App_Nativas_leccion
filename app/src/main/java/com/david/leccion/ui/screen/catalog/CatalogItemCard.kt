package com.david.leccion.ui.screen.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.david.leccion.data.Catalogo
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.sp

@Composable
fun CatalogItemCard(
    articulo: Catalogo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = stringResource(id = articulo.cardName),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .background(Color(0xFFCFF7E3),
                        shape = MaterialTheme.shapes.medium.copy(
                            topStart = CornerSize(10.dp),
                            topEnd = CornerSize(10.dp),
                            bottomStart = CornerSize(3.dp),
                            bottomEnd = CornerSize(3.dp))
                        )
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )

            Image(
                painter = painterResource(id = articulo.imageResourceId),
                contentDescription = stringResource(id = articulo.name),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
                    .padding(bottom = 8.dp)
                    .background(Color(0xFF6ABD93),
                        shape = MaterialTheme.shapes.medium.copy()
                    )

            )

            Text(
                text = stringResource(id = articulo.name),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = stringResource(id = articulo.descripcion),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2
            )

            Text(
                text = "$${articulo.price}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}