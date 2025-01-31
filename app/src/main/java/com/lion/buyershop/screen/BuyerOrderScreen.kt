package com.lion.buyershop.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.component.LikeLionDivider
import com.lion.buyershop.component.LikeLionOutlinedButtonRow
import com.lion.buyershop.component.LikeLionOutlinedTextField
import com.lion.buyershop.component.LikeLionOutlinedTextFieldEndIconMode
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.R
import com.lion.buyershop.component.ComponentOrderRecipe
import com.lion.buyershop.component.LikeLionOutlinedButton
import com.lion.buyershop.component.OptionItem
import com.lion.buyershop.viewmodel.BuyerOderViewModel


@Composable
fun BuyerOrderScreen(buyerOrderViewModel: BuyerOderViewModel= hiltViewModel()) {
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication
    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "내 폰 사기",
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
        ) {
            Text(
                text = "주문확인", // ✅ 총 가격 적용
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Red,

            )
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

            Text(
                text = "구매자/배송지 정보", // ✅ 총 가격 적용
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Red,

                )
            LikeLionDivider()
            Text(
                text = "구매자 정보",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
            LikeLionDivider()
            Text(
                text = "받는 분",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
            LikeLionOutlinedTextField(
                textFieldValue = buyerOrderViewModel.recipiantName,
                label = "받는분",
                placeHolder = "받는분을 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.subject_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
            )
            LikeLionOutlinedTextField(
                textFieldValue = buyerOrderViewModel.recipientPhoneNumber,
                label = "받는분 전화번호",
                placeHolder = "받는분 전화번호를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.subject_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
            )
            LikeLionDivider()
            Text(
                text = "배송지 정보 ",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
            LikeLionOutlinedTextField(
                textFieldValue = buyerOrderViewModel.PostalCode,
                label = "우편번호",
                placeHolder = "우편번호를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.subject_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
            )
            LikeLionOutlinedTextField(
                textFieldValue = buyerOrderViewModel.address,
                label = "주소",
                placeHolder = "주소를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.subject_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
            )
            LikeLionOutlinedTextField(
                textFieldValue = buyerOrderViewModel.deliveryMessage,
                label = "배송 메시지",
                placeHolder = "배송 메시지를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.subject_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
            )
            LikeLionDivider()
            Text(
                text = "결제 상세",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
            OptionItem("상품금액", "680,000원")
            OptionItem("배송비", "0원")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "최종 결제금액", fontSize = 20.sp, fontWeight = FontWeight.Normal)
                Text(text = "680,000원", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.Red)
            }
            LikeLionDivider()
            LikeLionOutlinedButton(
                text = "결제하기",
                onClick = {
                    buyerOrderViewModel.orderButtonOnClick()
                }
            )



        }


    }
}