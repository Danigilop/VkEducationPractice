package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.obpiub.vkeducationpractice.R
import com.obpiub.vkeducationpractice.domain.Category
import com.obpiub.vkeducationpractice.ui.theme.VkEducationPracticeTheme

@Composable
fun ScreenshotsList(
    screenshotUrlList: List<String>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
)
{
    if (screenshotUrlList.isEmpty()) return
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_screenshots),
            modifier = Modifier.padding(contentPadding),
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = contentPadding,
            pageSpacing = 8.dp,
            state = rememberPagerState { screenshotUrlList.size },
        ) { index ->
            AsyncImage(
                model = screenshotUrlList[index],
                contentDescription = null,
                contentScale = androidx.compose.ui.layout.ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}
