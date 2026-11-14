package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.CatalogApp

@Composable
fun AppShowcase(
    pages: List<List<CatalogApp>>,
    modifier: Modifier = Modifier,
    onAppClick:(String) -> Unit
) {
    if (pages.all { it.isEmpty() }) return
    val pagerState = rememberPagerState(0) { pages.size }
    Column(modifier = modifier) {
        Text(text = "Витрина")
        HorizontalPager(pagerState){indexPage ->
                ShowcasePage(pages[indexPage],
                    modifier = Modifier,
                    onAppClick)


            }

        }
    }