package com.example.composeapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import com.example.composeapp.R
import com.example.composeapp.domain.model.ProductModel
import com.example.composeapp.domain.viewmodel.ProductViewModel
import com.example.composeapp.presentation.ui.items.ProductListItem
import com.example.composeapp.presentation.ui.theme.AppTheme
import com.example.composeapp.presentation.ui.theme.Gold

class ProductListFragment : Fragment() {
    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    AppTheme(
                        darkTheme = false
                    ) {
                        viewModel.getProducts()
                        val products = viewModel.products.value

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            populateScreenHeader()
                            if (products.isNotEmpty()) {
                                populateList(products)
                            } else {
                                populateNoListText()
                            }
                        }
                    }
                }
            }
    }

    @Composable
    private fun populateNoListText() {
        val xxxlargePadding = dimensionResource(R.dimen.padding_xxxlarge)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = xxxlargePadding)
        ) {
            Text(
                text = stringResource(R.string.empty_list),
                textAlign = Center,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

    @Composable
    private fun populateList(products: List<ProductModel>) {
        val largePadding = dimensionResource(R.dimen.padding_large)
        LazyColumn {
            itemsIndexed(products) { index, item ->
                ProductListItem(product = item, navigateToUrl = {
                    openUrl(it.web_url)
                })
                if (index < products.size - 1) {
                    Divider(
                        color = Gold,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = largePadding)
                    )
                }
            }
        }
    }

    @Composable
    private fun populateScreenHeader() {
        val largePadding = dimensionResource(R.dimen.padding_large)
        val xxlargePadding = dimensionResource(R.dimen.padding_xxlarge)
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .padding(vertical = xxlargePadding)
                .padding(horizontal = largePadding),
            style = MaterialTheme.typography.h1,
            maxLines = 1
        )
    }

    private fun openUrl(webUrl: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
        startActivity(browserIntent)
    }

}
