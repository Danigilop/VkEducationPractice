package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.domain.App

@Composable
fun AppShowcase(
    pages: List<List<App>>,
    modifier: Modifier = Modifier,
    onAppClick:(App) -> Unit
) {
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