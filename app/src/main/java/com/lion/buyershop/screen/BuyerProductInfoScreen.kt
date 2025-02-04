package com.lion.buyershop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.BuyerApplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import com.lion.buyershop.component.LikeLionDivider
import com.lion.buyershop.component.LikeLionOutlinedButtonRow
import com.lion.buyershop.R
import com.lion.buyershop.component.ComponentDropdown
import com.lion.buyershop.component.ComponentOrderRecipe
import com.lion.buyershop.viewmodel.BuyerProductInfoViewModel
import kotlinx.coroutines.launch

@Composable
fun BuyerProductInfoScreen(buyerProductInfoViewModel: BuyerProductInfoViewModel = hiltViewModel())
{
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication

    buyerProductInfoViewModel.selectedGrade
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "상품 정보",
                navigationIconImage = Icons.AutoMirrored.Filled.ArrowBack,
                navigationIconOnClick = {
                    buyerApplication.navHostController.popBackStack()
                },
            )
        }
    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(start = 10.dp, end = 10.dp)
                .verticalScroll(rememberScrollState()) // 스크롤 가능하도록 설정
        )
        {
            Image(
                painter = painterResource(id = R.drawable.iphone15), // 이미지 리소스 ID로 교체
                contentDescription = "아이폰 14 프로",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.0f)
            )

            // 제품 정보

            Text(
                text = "아이폰14 PRO",
                //style = MaterialTheme.typography.h6
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Black)
            )
            LikeLionDivider()
            Text(
                text = "색상 선택",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
            )
            ComponentDropdown(
                title = "색상",
                options = listOf("빨강", "파랑", "노랑", "화이트", "블랙"),
                selectedOption = buyerProductInfoViewModel.selectedColor, // ViewModel 상태 사용
                onOptionSelected = { buyerProductInfoViewModel.selectedColor = it },
                modifier = Modifier.width(200.dp) // 기본 너비 설정
            )
            Text(
                text = "등급 선택",
                //style = MaterialTheme.typography.body1
                style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
            )
            ComponentDropdown(
                title = "등급",
                options = listOf("리퍼폰", "S+", "S", "A", "B"),
                selectedOption = buyerProductInfoViewModel.selectedGrade, // ViewModel 상태 사용
                onOptionSelected = { buyerProductInfoViewModel.selectedGrade = it },
                modifier = Modifier.width(200.dp)
            )

            // 선택한 옵션을 표시
            //Text(text = "test 선택한 등급: ${buyerProductInfoViewModel.selectedGrade}", fontSize = 9.sp)
            LikeLionDivider()
            ComponentOrderRecipe(
                productName = "아이폰 14 PRO",
                productBasicPrice = "+650,000원",
                productColor = "파랑",
                productColorPrice = "0원",
                productGrade = "A급",
                productGradePrice = "+30,000원",
                productTotalPrice = "680,000원"
            )


//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                // 제품명 상단 박스
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.LightGray)
//                        .padding(16.dp)
//                ) {
//                    Text(
//                        text = "아이폰14 PRO",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                // 옵션 리스트
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color(0xFFF5F5F5)) // 연한 회색 배경
//                        .padding(16.dp)
//                ) {
//                    OptionItem("아이폰14 PRO", "+650,000원")
//
//                    OptionItem("색상 : 파랑", "0원")
//                    OptionItem("A급", "+30,000원")
//
//                }
//                // 가격 표시
//                Spacer(modifier = Modifier.height(24.dp))
//                Text(text = "680,000원",
//                    fontSize = 26.sp,
//                    modifier = Modifier.fillMaxWidth(),
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Red, textAlign = TextAlign.End)
//
//                LikeLionDivider()
//
//
//            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                LikeLionOutlinedButtonRow(
                    text = "장바구니",
                    paddingTop = 20.dp,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        ///buyerProductInfoViewModel.buttonBuyMyPhoneClick()//test
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                LikeLionOutlinedButtonRow(
                    text = "구매하기",
                    paddingTop = 20.dp,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        buyerProductInfoViewModel.buttonBuyerOrderClick()
                    }
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "등급 설명",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.phone_grade), // 이미지 리소스 ID로 교체
                contentDescription = "아이폰 14 프로",
                modifier = Modifier
                    .fillMaxWidth(), // ✅ 가로를 꽉 채움 (세로는 제한 없음)
                contentScale = ContentScale.FillWidth // ✅ 가
            )
        }
    }
}


//
//@Composable
//fun OptionItem(title: String, price: String) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(text = "-$title", fontSize = 16.sp, fontWeight = FontWeight.Normal)
//        Text(text = price, fontSize = 16.sp, fontWeight = FontWeight.Bold)
//    }
//    Spacer(modifier = Modifier.height(8.dp))
//}
//
//
