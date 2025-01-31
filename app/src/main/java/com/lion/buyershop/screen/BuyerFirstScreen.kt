package com.lion.buyershop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.component.LikeLionOutlinedButtonRow
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.R
import com.lion.buyershop.component.LikeLionOutlinedButton
import com.lion.buyershop.viewmodel.BuyerBuyListViewModel
import com.lion.buyershop.viewmodel.BuyerFirstViewModel
import kotlinx.coroutines.launch
@Composable
fun BuyerFirstScreen(buyerFirstViewModel: BuyerFirstViewModel = hiltViewModel(),
        buyerBuyListViewModel: BuyerBuyListViewModel = hiltViewModel()) {
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication

    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "폰 라우트",
                navigationIconImage = Icons.Filled.Menu,
                navigationIconOnClick = {
                    scope.launch {
                        buyerApplication.navigationDrawerState.open()
                    }
                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 10.dp) // 가로 여백만 설정
        ) {
            // 상단 고정 콘텐츠
            Image(
                painter = painterResource(id = R.drawable.event_banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            LikeLionOutlinedButton(
                text = "내 폰 사기",
                paddingTop = 20.dp,
                onClick = {
                    buyerFirstViewModel.buttonBuyMyPhoneClick()
                }
            )
            LikeLionOutlinedButton(
                text = "내 폰 팔기",
                paddingTop = 20.dp,
                onClick = { /* Action */ }
            )
            Text(
                text = "추천 상품",
                Modifier.padding(top = 20.dp)
            )

            // 스크롤 가능한 콘텐츠 (ProductListScreen)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // 남은 공간을 채우도록 설정
                    .verticalScroll(rememberScrollState()) // 스크롤 적용
            ) {
                ProductListScreen()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    imageResId: Int,
    title: String,
    capacity: String,
    price: String,
    grade: String,
    starRating: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = capacity, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                Text(text = "최저가: $price", style = MaterialTheme.typography.bodyMedium, color = Color.Red)
                Text(text = "판매등급: $grade", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "⭐ $starRating", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun ProductListScreen(buyerBuyListViewModel : BuyerBuyListViewModel = hiltViewModel()) {
    val products = listOf(
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),
        Product(
            imageResId = R.drawable.iphone15, // 리소스 ID 변경
            title = "아이폰 15",
            capacity = "256GB",
            price = "900,000원",
            grade = "B",
            starRating = "5.0"
        ),



    )

    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                buyerBuyListViewModel.listItemOnClick()
            }

    ) {
        products.forEach { product ->
            ProductItem(
                imageResId = product.imageResId,
                title = product.title,
                capacity = product.capacity,
                price = product.price,
                grade = product.grade,
                starRating = product.starRating
            )
        }
    }
}

data class Product(
    val imageResId: Int,
    val title: String,
    val capacity: String,
    val price: String,
    val grade: String,
    val starRating: String
)
