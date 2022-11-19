package com.zhasaApp.ui.statistic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.leading.view.LeadingWeekStatistic
import com.zhasaApp.ui.leading.view.LeadingYearStatistic
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StatisticScreen() {
    val pagerState = rememberPagerState()
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = pagerState.currentPage, indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
            Tab(
                selected = pagerState.currentPage == 0,
                onClick = { runBlocking { pagerState.scrollToPage(0) } },
                text = {
                    NormalText(text = "Недельная")
                }
            )
            Tab(
                selected = pagerState.currentPage == 1,
                onClick = { runBlocking { pagerState.scrollToPage(1) } },
                text = {
                    NormalText(text = "Годовая")
                }
            )
        }
        HorizontalPager(count = 2, state = pagerState) { page ->
            if (page == 0) {
                LeadingWeekStatistic()
            }
            if (page == 1) {
                LeadingYearStatistic()
            }
        }
    }
}
