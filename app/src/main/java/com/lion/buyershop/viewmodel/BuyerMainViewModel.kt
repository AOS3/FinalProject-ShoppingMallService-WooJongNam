package com.lion.buyershop.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class BuyerMainViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    val buyerApplication = context as BuyerApplication


    // NavigationDrawer의 항목의 선택 상태를 위한 상태 변수
    val navigationItemSelectedState1 = mutableStateOf(true)
    val navigationItemSelectedState2 = mutableStateOf(false)
    val navigationItemSelectedState3 = mutableStateOf(false)
    val navigationItemSelectedState4 = mutableStateOf(false)
    val navigationItemSelectedState5 = mutableStateOf(false)
    val navigationItemSelectedState6 = mutableStateOf(false)
    val navigationItemSelectedState7 = mutableStateOf(false)
    val navigationItemSelectedState8 = mutableStateOf(false)

    // NavigationDrawer에서 몇 번째 메뉴를 눌렀는지를 위한 상태변수
    val navigationItemSelectedPosition = mutableIntStateOf(0)

    // NavigationDrawer의 항목의 선택 상태를 위한 상태 변수를 초기화 하는 함수
    fun resetNavigationItemSelectedState(){
        navigationItemSelectedState1.value = false
        navigationItemSelectedState2.value = false
        navigationItemSelectedState3.value = false
        navigationItemSelectedState4.value = false
        navigationItemSelectedState5.value = false
        navigationItemSelectedState6.value = false
        navigationItemSelectedState7.value = false
        navigationItemSelectedState8.value = false
    }
}

