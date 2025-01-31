package com.lion.buyershop.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.util.MainScreenName
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class BuyerBuyListViewModel @Inject constructor(
    @ApplicationContext context: Context,
) : ViewModel() {
    val buyerApplication = context as BuyerApplication
    var selectedCapacity by mutableStateOf("용량")
    var selectedGrade by mutableStateOf("등급")
    var selectedPrice by mutableStateOf("가격대")
    // 아이디 입력 요소
    val textFieldUserLoginIdValue = mutableStateOf("")
    // 비밀번호 입력 요소
    val textFieldUserLoginPasswordValue = mutableStateOf("")
    // 자동 로그인 입력 요소
    val checkBoxAutoLoginValue = mutableStateOf(false)

    // 아이디 입력요소 포커스
    val textFieldUserLoginIdFocusRequester = mutableStateOf(FocusRequester())
    // 비밀번호 입력 요소 포커스
    val textFieldUserLoginPasswordFocusRequester = mutableStateOf(FocusRequester())

    // 아이디 입력 오류 다이얼로그 상태변수
    val alertDialogUserIdState = mutableStateOf(false)
    // 비밀번호 입력 오류 다이얼로그 상태변수
    val alertDialogUserPwState = mutableStateOf(false)
    // 존재하지 않는 아이디 오류 다이얼로그 상태변수
    val alertDialogLoginFail1State = mutableStateOf(false)
    // 잘못된 비밀번호 다이얼로그 상태변수
    val alertDialogLoginFail2State = mutableStateOf(false)
    // 탈퇴한 회원 다이얼로그 상태변수
    val alertDialogLoginFail3State = mutableStateOf(false)

    // 이벤트 베너 클릭
    fun buttonEventBannerClick(){
        Log.d("test111", "이벤트베너 ㄱㄱ")
        //buyerApplication.navHostController.navigate(MainScreenName.MAIN_SCREEN_USER_JOIN_STEP1.name)
    }

    fun listItemOnClick(){
        buyerApplication.navHostController.navigate(MainScreenName.MAIN_SCREEN_PRODUCT_INFO.name)

    }
}



