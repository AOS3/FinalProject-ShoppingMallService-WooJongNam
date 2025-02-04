package com.lion.buyershop.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.component.LikeLionOutlinedButtonRow
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.viewmodel.BuyerMyPageViewModel

@Composable
fun BuyerMyPageScreen(
    buyerMyPageViewScreen: BuyerMyPageViewModel = hiltViewModel(),

) {
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication

    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "마이 페이지",
                navigationIconImage = Icons.AutoMirrored.Filled.ArrowBack,
                navigationIconOnClick = {
                    buyerApplication.navHostController.popBackStack()
                },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CustomTabBar()
        }
    }
}

@Composable
fun CustomTabBar() {
    val tabs = listOf("판매내역", "주문내역", "1:1문의", "포인트내역", "회원정보수정", "회원탈퇴")
    var selectedTabIndex by remember { mutableStateOf(1) } // "기본 선택

    Column {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            },
            divider = {}
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex == index) Color.Red else Color.Gray,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }
    }

    when (selectedTabIndex) {
        0 -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(1) { index ->  // 테스트용으로 5개 아이템 생성ㄴㄴㄴㄴㄴㄴㄴㄴ
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE3F2FD)  // 연한 파란색
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "주문번호: ORDER-${index + 1}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "iPhone 15 Pro",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "1,500,000원",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "2024.03.21",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
            }
        }
        1 -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(1) { index ->  // 테스트용으로 5개 아이템 생성
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE8F5E9)  // 연한 파란색
                        ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text("주문번호 : 02250202-12")
                            Text("구매날짜 : 25년 2월 1일")
                            ProductListScreen2()
                            Row(modifier = Modifier.fillMaxWidth(),)
                            {
                                LikeLionOutlinedButtonRow(
                                    text = "리뷰쓰기",
                                    paddingTop = 5.dp,
                                    modifier = Modifier.weight(1f),
                                    onClick = {
                                        ///buyerProductInfoViewModel.buttonBuyMyPhoneClick()
                                    }
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                LikeLionOutlinedButtonRow(
                                    text = "주문취소",
                                    paddingTop = 5.dp,
                                    modifier = Modifier.weight(1f),
                                    onClick = {
                                        //buyerProductInfoViewModel.buttonBuyerOrderClick()
                                    }
                                )

                            }

                        }
                    }
                }
            }
        }
    }
}

