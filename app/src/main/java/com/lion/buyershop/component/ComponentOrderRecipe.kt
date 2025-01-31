package com.lion.buyershop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lion.buyershop.component.LikeLionDivider
@Composable
fun ComponentOrderRecipe(
    productName: String,
    productBasicPrice: String,
    productColor: String,
    productColorPrice: String = "0원", // 색상 추가 요금 (기본값 0원)
    productGrade: String,
    productGradePrice: String,
    productTotalPrice: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // 제품명 상단 박스
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            Text(
                text = productName, // ✅ 제품명 매개변수 적용
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 옵션 리스트
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5)) // 연한 회색 배경
                .padding(16.dp)
        ) {
            OptionItem(productName, productBasicPrice) // ✅ 기본 가격 적용
            OptionItem("색상: $productColor", productColorPrice) // ✅ 색상 적용
            OptionItem(productGrade, productGradePrice) // ✅ 등급 적용
        }

        // 가격 표시
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = productTotalPrice, // ✅ 총 가격 적용
            fontSize = 26.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.End
        )

        LikeLionDivider()
    }
}

@Composable
fun OptionItem(title: String, price: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "-$title", fontSize = 16.sp, fontWeight = FontWeight.Normal)
        Text(text = price, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.height(8.dp))
}
