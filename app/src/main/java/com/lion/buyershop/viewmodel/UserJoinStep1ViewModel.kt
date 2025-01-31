package com.lion.buyershop.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
//import com.lion.buyershop.service.UserService
import com.lion.buyershop.util.MainScreenName
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserJoinStep1ViewModel @Inject constructor(
    @ApplicationContext context: Context,
//    val userService: UserService,
) : ViewModel() {

    val buyerApplication = context as BuyerApplication

    // 아이디
    val textFieldUserJoinStep1IdValue = mutableStateOf("")
    // 비밀번호 1
    val textFieldUserJoinStep1Password1Value = mutableStateOf("")
    // 비밀번호 2
    val textFieldUserJoinStep1Password2Value = mutableStateOf("")

    // 에러 메시지
    val textFieldUserJoinStep1IdErrorText = mutableStateOf("")
    val textFieldUserJoinStep1Password1ErrorText = mutableStateOf("")
    val textFieldUserJoinStep1Password2ErrorText = mutableStateOf("")

    val textFieldUserJoinStep1IdIsError = mutableStateOf(false)
    val textFieldUserJoinStep1Password1IsError = mutableStateOf(false)
    val textFieldUserJoinStep1Password2IsError = mutableStateOf(false)

    // 아이디 중복확인을 성공했는지
    var isCheckUserId = mutableStateOf(false)

    // 네비게이션 아이콘을 누르면 호출되는 메서드
    fun navigationIconOnClick(){
        buyerApplication.navHostController.popBackStack()
    }

    // 다음 버튼을 누르면 호출되는 메서드
    fun buttonNextOnClick(){
        // 기본에 있는 에러 메시지는 모두 초기화
        textFieldUserJoinStep1IdErrorText.value = ""
        textFieldUserJoinStep1Password1ErrorText.value = ""
        textFieldUserJoinStep1Password2ErrorText.value = ""
        textFieldUserJoinStep1IdIsError.value = false
        textFieldUserJoinStep1Password1IsError.value = false
        textFieldUserJoinStep1Password2IsError.value = false

        var isError = false

        if(textFieldUserJoinStep1IdValue.value.isEmpty()){
            textFieldUserJoinStep1IdErrorText.value = "아이디를 입력해주세요"
            textFieldUserJoinStep1IdIsError.value = true
            isError = true
        }

        if(textFieldUserJoinStep1Password1Value.value.isEmpty()){
            textFieldUserJoinStep1Password1ErrorText.value = "비밀번호를 입력해주세요"
            textFieldUserJoinStep1Password1IsError.value = true
            isError = true
        }

        if(textFieldUserJoinStep1Password2Value.value.isEmpty()){
            textFieldUserJoinStep1Password2ErrorText.value = "비밀번호를 입력해주세요"
            textFieldUserJoinStep1Password2IsError.value = true
            isError = true
        }

        if(textFieldUserJoinStep1Password1Value.value != textFieldUserJoinStep1Password2Value.value){
            if(textFieldUserJoinStep1Password1Value.value.isNotEmpty() && textFieldUserJoinStep1Password2Value.value.isNotEmpty()) {
                textFieldUserJoinStep1Password1ErrorText.value = "비밀번호를 동일하게 입력해주세요"
                textFieldUserJoinStep1Password1IsError.value = true
                textFieldUserJoinStep1Password2ErrorText.value = "비밀번호를 동일하게 입력해주세요"
                textFieldUserJoinStep1Password2IsError.value = true

                isError = true
            }
        }

        if(isCheckUserId.value == false){
            textFieldUserJoinStep1IdErrorText.value = "아이디 중복 확인을 해주세요"
            textFieldUserJoinStep1IdIsError.value = true
            isError = true
        }
        ////////////
        buyerApplication.navHostController.navigate("${MainScreenName.MAIN_SCREEN_USER_JOIN_STEP2.name}/${textFieldUserJoinStep1IdValue.value}/${textFieldUserJoinStep1Password1Value.value}")
        if(isError == false) {
            buyerApplication.navHostController.navigate("${MainScreenName.MAIN_SCREEN_USER_JOIN_STEP2.name}/${textFieldUserJoinStep1IdValue.value}/${textFieldUserJoinStep1Password1Value.value}")
        }
    }

    // 아이디 중복확인을 누르면 호출되는 함수
    fun buttonCheckUserIdOnClick(){
        textFieldUserJoinStep1IdIsError.value = false
//        // 사용자가 입력한 아이디
//        val userId = textFieldUserJoinStep1IdValue.value
//
//        // 입력한 것이 없다면
//        if(userId.isEmpty()){
//            textFieldUserJoinStep1IdIsError.value = true
//            textFieldUserJoinStep1IdErrorText.value = "아이디를 입력해주세요"
//            return
//        }
//        // 사용할 수 있는 아이디인지 검사한다.
//        CoroutineScope(Dispatchers.Main).launch {
//            val work1 = async(Dispatchers.IO){
//                userService.checkJoinUserId(userId)
//            }
//            isCheckUserId.value = work1.await()
//
//            if(isCheckUserId.value){
//                textFieldUserJoinStep1IdIsError.value = false
//                textFieldUserJoinStep1IdErrorText.value = "사용 가능한 아이디 입니다"
//            } else {
//                textFieldUserJoinStep1IdIsError.value = true
//                textFieldUserJoinStep1IdErrorText.value = "이미 존재하는 아이디입니다"
//            }
//        }

    }
}









