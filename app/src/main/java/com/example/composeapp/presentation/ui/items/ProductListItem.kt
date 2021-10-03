package com.example.composeapp.presentation.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.composeapp.R
import com.example.composeapp.domain.model.ProductModel
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun ProductListItem(product: ProductModel, navigateToUrl: (ProductModel) -> Unit) {
    val smallPadding = dimensionResource(R.dimen.padding_small)
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val largePadding = dimensionResource(R.dimen.padding_large)
    val squareWidth = dimensionResource(R.dimen.width_square)
    Row(
        Modifier
            .fillMaxWidth()
            .padding(smallPadding)
            .padding(largePadding)
            .clickable { navigateToUrl(product) },
        verticalAlignment = Alignment.CenterVertically

    ) {
        if (product.image_url != null) {
            Image(
                painter = rememberGlidePainter(
                    request = product.image_url,
                    previewPlaceholder = R.drawable.ic_noimage_placeholder
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(squareWidth)
                    .height(squareWidth)
            )
        } else {
            Image(
                painter = painterResource(R.drawable.ic_noimage_placeholder),
                contentDescription = null,
                modifier = Modifier
                    .width(squareWidth)
                    .height(squareWidth)
            )
        }

        Text(
            text = product.name,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(horizontal = mediumPadding),
            style = MaterialTheme.typography.body1
        )
    }
}
