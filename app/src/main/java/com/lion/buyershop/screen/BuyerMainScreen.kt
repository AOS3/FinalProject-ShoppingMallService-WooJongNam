package com.lion.buyershop.screen

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.R
import com.lion.buyershop.component.LikeLionDivider
import com.lion.buyershop.component.LikeLionDrawerItem
import com.lion.buyershop.component.LikeLionNavigationDrawer
import com.lion.buyershop.viewmodel.BuyerMainViewModel

@Composable
fun BuyerMainScreen(buyerMainViewModel: BuyerMainViewModel = hiltViewModel(),
                  ) {
    // 네비게이션 드로S우어의 상태를 관리하는 변수
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    //  네비게이션 드로우어의 상태를 관리하는 변수를 Application 객체에 담아준다.
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication
    buyerApplication.navigationDrawerState = drawerState


    /////////////////////

    //Log.d("test100", buyerApplication.loginUserModel.userId)
    //Log.d("test100", buyerApplication.loginUserModel.userNickName)

    LikeLionNavigationDrawer(
        drawerState = drawerState,
        headerComposable = {
            Text(
                text = "홍길동님",
                //style = Typography.headlineLarge,
                modifier = Modifier.padding(start = 10.dp)
            )

            Text(
                text = "반갑습니다",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            )
            LikeLionDivider(paddingTop = 10.dp)
            Spacer(
                modifier = Modifier.padding(bottom = 10.dp)
            )
        },
        drawerItems = listOf<@Composable () -> Unit>(
            {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top=10.dp, bottom = 10.dp),
                    text = "메뉴선택"
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.local_shipping_24px),
                    label = "로그인",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState1,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 0
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.post_add_24px),
                    label = "회원 가입",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState2,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 1
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.compost_24px),
                    label = "폰 라우터 소개",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState3,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 2
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.package_24px),
                    label = "오늘의 중고 시세",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState4,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 3
                    }
                )
            },
            {
                LikeLionDivider()

            },
            {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top=10.dp, bottom = 10.dp),
                    text = "내 폰 사기"
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.approval_24px),
                    label = "검색조건 즐겨찾기",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState5,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 4
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.approval_24px),
                    label = "장바구니",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState5,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 4
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.approval_24px),
                    label = "구매 내역",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState5,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 4
                    }
                )
            },
            {
                LikeLionDivider(
                    paddingTop = 10.dp
                )
            },
            {
                Spacer(
                    modifier = Modifier.padding(top = 10.dp)
                )
            },
            {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top=10.dp, bottom = 10.dp),
                    text = "내 폰 팔기"
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.person_24px),
                    label = "검색조건 즐겨찾기",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState6,
                    drawerState = drawerState,
                    onClick = {
                        buyerMainViewModel.resetNavigationItemSelectedState()
                        buyerMainViewModel.navigationItemSelectedPosition.intValue = 5
                    }
                )
            },
            {
                LikeLionDrawerItem(
                    imageVector = ImageVector.vectorResource(R.drawable.logout_24px),
                    label = "판매 내역",
                    selectedStateValue = buyerMainViewModel.navigationItemSelectedState7,
                    drawerState = drawerState,
                    onClick = {
                        // 다이얼로그를 띄운다.
                        //buyerMainViewModel.showDialogLoginOut.value = true
                    }
                )
            },

        ),
        screens = listOf<@Composable () -> Unit>(
            {
                // 전체 게시판
                //BuyerBuyListScreen()
                BuyerFirstScreen()
                Log.d("test111", "type all")
            },
            {
                // 자유 게시판
                //BoardListScreen(boardType = BoardType.BOARD_TYPE_1)
            },
            {
                // 유머 게시판
                //BoardListScreen(boardType = BoardType.BOARD_TYPE_2)
            },
            {
                // 시사 게시판
                //BoardListScreen(boardType = BoardType.BOARD_TYPE_3)
            },
            {
                // 운동 게시판
                //(boardType = BoardType.BOARD_TYPE_4)
            },
        ),
        navigationItemSelectedPosition = buyerMainViewModel.navigationItemSelectedPosition,
    )

}