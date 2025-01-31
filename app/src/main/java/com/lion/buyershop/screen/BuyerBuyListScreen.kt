package com.lion.buyershop.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.viewmodel.BuyerBuyListViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.OutlinedButton
import com.lion.buyershop.component.LikeLionDivider
import com.lion.buyershop.component.ComponentDropdown

@Composable
fun BuyerBuyListScreen(buyerBuyListViewModel: BuyerBuyListViewModel = hiltViewModel()) {
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

            DynamicFilterScreen()
            SortScreen()
            ProductListScreen()

        }
    }
}




@Composable
fun DynamicFilterScreen() {
    val manufacturers = listOf("애플", "삼성", "기타")
    val defaultModels = listOf("아이폰", "아이패드", "애플워치")
    val samsungModels = listOf("갤럭시", "갤럭시탭", "갤럭시워치")
    val etcModels = listOf("LG", "중국")

    val galaxySeries = listOf("폴드", "플립", "노트", "S 시리즈", "A 시리즈")
    val galaxyTabSeries = listOf("A 시리즈", "E 시리즈", "S 시리즈")
    val galaxyWatchSeries = listOf("갤럭시 워치 울트라", "갤럭시 워치 7 시리즈", "갤럭시 워치 6 시리즈")

    val iphoneSeries = listOf("16 시리즈", "15 시리즈", "14 시리즈", "13 시리즈", "12 시리즈", "11 시리즈")
    val ipadSeries = listOf("아이패드 프로", "아이패드", "아이패드 에어", "아이패드 미니")
    val appleWatchSeries = listOf("애플워치 울트라", "애플워치 9 시리즈", "애플워치 8 시리즈", "애플워치 7 시리즈")

    val defaultSeries = listOf("16 시리즈", "15 시리즈", "14 시리즈", "13 시리즈", "12 시리즈", "11 시리즈")

    val selectedManufacturer = remember { mutableStateOf("") }
    val modelFilters = remember { mutableStateListOf(*defaultModels.toTypedArray()) }
    val selectedModel = remember { mutableStateOf("") }
    val seriesFilters = remember { mutableStateListOf(*defaultSeries.toTypedArray()) }
    val selectedSeries = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "원하는 상품찾기",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 21.sp)
            )

            OutlinedButton(
                onClick = {
                    selectedManufacturer.value = ""
                    modelFilters.clear()
                    modelFilters.addAll(defaultModels)
                    selectedModel.value = ""
                    seriesFilters.clear()
                    seriesFilters.addAll(defaultSeries)
                    selectedSeries.value = ""
                },
                modifier = Modifier.height(40.dp) // 버튼 높이 조정
            ) {
                Text(
                    text = "초기화",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        FilterRow(
            title = "제조사",
            filters = manufacturers,
            selectedFilter = selectedManufacturer.value,
            onFilterSelected = { selected ->
                selectedManufacturer.value = selected
                when (selected) {
                    "삼성" -> {
                        modelFilters.clear()
                        modelFilters.addAll(samsungModels)
                        seriesFilters.clear()
                        seriesFilters.addAll(defaultSeries)
                    }
                    "기타" -> {
                        modelFilters.clear()
                        modelFilters.addAll(etcModels)
                        seriesFilters.clear()
                        seriesFilters.addAll(defaultSeries)
                    }
                    else -> {
                        modelFilters.clear()
                        modelFilters.addAll(defaultModels)
                        seriesFilters.clear()
                        seriesFilters.addAll(defaultSeries)
                    }
                }
                selectedModel.value = ""
                selectedSeries.value = ""
            }
        )
        LikeLionDivider()
        FilterRow(
            title = "기종",
            filters = modelFilters,
            selectedFilter = selectedModel.value,
            onFilterSelected = { selected ->
                selectedModel.value = selected
                when (selected) {
                    "아이폰" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(iphoneSeries)
                    }
                    "아이패드" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(ipadSeries)
                    }
                    "애플워치" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(appleWatchSeries)
                    }
                    "갤럭시" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(galaxySeries)
                    }
                    "갤럭시탭" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(galaxyTabSeries)
                    }
                    "갤럭시워치" -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(galaxyWatchSeries)
                    }
                    else -> {
                        seriesFilters.clear()
                        seriesFilters.addAll(defaultSeries)
                    }
                }
                selectedSeries.value = ""
            }
        )
        LikeLionDivider()

        HorizontalScrollableFilterRow(
            title = "시리즈",
            filters = seriesFilters,
            selectedFilter = selectedSeries.value,
            onFilterSelected = { selectedSeries.value = it }
        )
        LikeLionDivider()
        FilterDropdown()
    }
}

@Composable
fun FilterRow(
    title: String,
    filters: List<String>,
    selectedFilter: String = "",
    onFilterSelected: (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            filters.forEach { filter ->
                val isSelected = filter == selectedFilter

                Text(
                    text = filter,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    ),
                    color = if (isSelected) Color.Blue else Color.Gray,
                    modifier = Modifier.clickable {
                        onFilterSelected(filter)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun HorizontalScrollableFilterRow(
    title: String,
    filters: List<String>,
    selectedFilter: String = "",
    onFilterSelected: (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filters) { filter ->
                val isSelected = filter == selectedFilter

                Text(
                    text = filter,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    ),
                    color = if (isSelected) Color.Blue else Color.Gray,
                    modifier = Modifier.clickable {
                        onFilterSelected(filter)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDropdown(buyerBuyListViewModel: BuyerBuyListViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "필터",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 필터 드롭다운 리스트
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // 등급 드롭다운 (기본 크기)
            ComponentDropdown(
                title = "등급",
                options = listOf("리퍼폰", "S+", "S", "A", "B"),
                selectedOption = buyerBuyListViewModel.selectedGrade, // ViewModel 상태 사용
                onOptionSelected = { buyerBuyListViewModel.selectedGrade = it },
                modifier = Modifier.width(89.dp) // 기본 너비 설정
            )

            // 용량 드롭다운 (기본 크기)
            ComponentDropdown(
                title = "용량",
                options = listOf("16GB", "32GB", "64GB", "128GB", "256GB", "512GB", "1024GB"),

                selectedOption = buyerBuyListViewModel.selectedCapacity, // ViewModel 상태 사용
                onOptionSelected = { buyerBuyListViewModel.selectedCapacity = it },
                modifier = Modifier.width(110.dp) // 기본 너비 설정
            )

            // 가격대 드롭다운 (동적으로 확장 가능)
            ComponentDropdown(
                title = "가격대",
                options = listOf(
                    "전체",
                    "10만원 이하",
                    "10만원 ~ 30만원",
                    "30만원 ~ 50만원",
                    "50만원 ~ 70만원",
                    "70만원 이상"
                ),
                selectedOption = buyerBuyListViewModel.selectedPrice, // ViewModel 상태 사용
                onOptionSelected = { buyerBuyListViewModel.selectedPrice = it },

                modifier = Modifier
                    .wrapContentWidth(unbounded = true) // 텍스트 길이에 따라 확장
                    .defaultMinSize(minWidth = 130.dp) // 최소 너비 설정
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    LikeLionDivider()
}

@Composable
fun SortScreen() {
    val sortOptions = listOf("높은가격순", "낮은가격순", "인기순", "모델순")

    SortAndSearchCountSection(
        searchCount = 193,
        sortOptions = sortOptions,
        onSortSelected = { selectedOption ->
            // 정렬 옵션 선택 시 동작
            println("Selected Sort Option: $selectedOption")
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortAndSearchCountSection(
    searchCount: Int,
    sortOptions: List<String>,
    onSortSelected: (String) -> Unit
) {
    val (selectedSortOption, setSelectedSortOption) = remember { mutableStateOf(sortOptions.first()) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 검색 결과 수 표시
        Text(
            text = " 검색된 111개 모델 ",
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
        )

        // 정렬 드롭다운 메뉴
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedSortOption,
                onValueChange = {},
                readOnly = true,
                label = { Text("정렬") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                sortOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            setSelectedSortOption(option)
                            onSortSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
