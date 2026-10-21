package com.obpiub.vkeducationpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppShowcase(
    pages: List<List<AppItem>>,
    modifier: Modifier = Modifier,
    onAppClick:(AppItem) -> Unit
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