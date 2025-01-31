package com.lion.buyershop.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.util.MainScreenName
//import com.lion.buyershop.model.UserModel
//import com.lion.buyershop.service.UserService
//import com.lion.buyershop.util.MainScreenName
//import com.lion.buyershop.util.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserJoinStep2ViewModel @Inject constructor(
    @ApplicationContext context:Context,
    //val userService: UserService,
) :ViewModel() {
    val buyerApplication = context as BuyerApplication
    // 닉네임 입력 요소
    val textFieldUserJoinStep2NickNameValue = mutableStateOf("")
    // 나이 입력 요소
    val textFieldUserJoinStep2AgeValue = mutableStateOf("")
    // 취미 입력 요소
    val triStateCheckBoxUserJoinStep2HobbyAllValue = mutableStateOf(ToggleableState.Off)
    // 취미들 입력 요소
    val checkBoxUserJoinStep2Hobby1Value = mutableStateOf(false)
    val checkBoxUserJoinStep2Hobby2Value = mutableStateOf(false)
    val checkBoxUserJoinStep2Hobby3Value = mutableStateOf(false)
    val checkBoxUserJoinStep2Hobby4Value = mutableStateOf(false)
    val checkBoxUserJoinStep2Hobby5Value = mutableStateOf(false)
    val checkBoxUserJoinStep2Hobby6Value = mutableStateOf(false)

    // 아이디 비밀번호
    lateinit var joinUserId:String
    lateinit var joinUserPw:String

    // 다이얼로그를 제어하는 상태 변수
    val showDialogNickNameEmptyState = mutableStateOf(false)
    val showDialogAgeEmptyState = mutableStateOf(false)
    val showDialogNickNameIsNotCheckState = mutableStateOf(false)
    val showDialogNickNameOk = mutableStateOf(false)
    val showDialogNickNameNo = mutableStateOf(false)


    // 닉네임 중복확인을 했는지
    val isCheckNickName = mutableStateOf(false)

    // 입력요소 포커스 관리
    val nickNameFocusRequester = mutableStateOf(FocusRequester())
    val ageFocusRequester = mutableStateOf(FocusRequester())


    // 취미 체크박스를 눌렀을 때 호출되는 메서드
    fun triStateCheckBoxUserJoinStep2HobbyAllOnClick(){
        if(triStateCheckBoxUserJoinStep2HobbyAllValue.value == ToggleableState.On){
            checkBoxUserJoinStep2Hobby1Value.value = true
            checkBoxUserJoinStep2Hobby2Value.value = true
            checkBoxUserJoinStep2Hobby3Value.value = true
            checkBoxUserJoinStep2Hobby4Value.value = true
            checkBoxUserJoinStep2Hobby5Value.value = true
            checkBoxUserJoinStep2Hobby6Value.value = true
        } else if(triStateCheckBoxUserJoinStep2HobbyAllValue.value == ToggleableState.Off){
            checkBoxUserJoinStep2Hobby1Value.value = false
            checkBoxUserJoinStep2Hobby2Value.value = false
            checkBoxUserJoinStep2Hobby3Value.value = false
            checkBoxUserJoinStep2Hobby4Value.value = false
            checkBoxUserJoinStep2Hobby5Value.value = false
            checkBoxUserJoinStep2Hobby6Value.value = false
        }
    }

    // 취미 요소들의 상태가 변경되었을 때
    fun checkBoxUserJoinStep2HobbyOnChanged(){
        // 체크된 체박스의 개수
        var checkedCount = 0

        if(checkBoxUserJoinStep2Hobby1Value.value == true){
            checkedCount++
        }
        if(checkBoxUserJoinStep2Hobby2Value.value == true){
            checkedCount++
        }
        if(checkBoxUserJoinStep2Hobby3Value.value == true){
            checkedCount++
        }
        if(checkBoxUserJoinStep2Hobby4Value.value == true){
            checkedCount++
        }
        if(checkBoxUserJoinStep2Hobby5Value.value == true){
            checkedCount++
        }
        if(checkBoxUserJoinStep2Hobby6Value.value == true){
            checkedCount++
        }

        triStateCheckBoxUserJoinStep2HobbyAllValue.value = if(checkedCount == 6){
            ToggleableState.On
        } else if(checkedCount == 0){
            ToggleableState.Off
        } else {
            ToggleableState.Indeterminate
        }
    }

    // 가입 완료 버튼을 눌렀을 때
    fun buttonUserJoinStep2SubmitOnClick(){
        Toast.makeText(buyerApplication, "가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
        buyerApplication.navHostController.popBackStack(MainScreenName.MAIN_SCREEN_USER_JOIN_STEP1.name, true)

        if(textFieldUserJoinStep2NickNameValue.value.isEmpty()){
            showDialogNickNameEmptyState.value = true
            return
        }

        if(textFieldUserJoinStep2AgeValue.value.isEmpty()){
            showDialogAgeEmptyState.value = true
            return
        }

        if(isCheckNickName.value == false){
            showDialogNickNameIsNotCheckState.value = true
            return
        }
//
//        // 저장할 데이터를 추출한다.
//        val userModel = UserModel()
//
//        userModel.userId = joinUserId
//        userModel.userPw = joinUserPw
//        userModel.userNickName = textFieldUserJoinStep2NickNameValue.value
//        userModel.userAge = textFieldUserJoinStep2AgeValue.value.toInt()
//        userModel.userHobby1 = checkBoxUserJoinStep2Hobby1Value.value
//        userModel.userHobby2 = checkBoxUserJoinStep2Hobby2Value.value
//        userModel.userHobby3 = checkBoxUserJoinStep2Hobby3Value.value
//        userModel.userHobby4 = checkBoxUserJoinStep2Hobby4Value.value
//        userModel.userHobby5 = checkBoxUserJoinStep2Hobby5Value.value
//        userModel.userHobby6 = checkBoxUserJoinStep2Hobby6Value.value
//        userModel.userTimeStamp = System.nanoTime()
//        userModel.userState = UserState.USER_STATE_NORMAL
//
//        // 저장한다.
//        CoroutineScope(Dispatchers.Main).launch {
//            val work1 = async(Dispatchers.IO){
//                userService.addUserData(userModel)
//            }
//            work1.join()
//
//            Toast.makeText(buyerApplication, "가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
//            buyerApplication.navHostController.popBackStack(MainScreenName.MAIN_SCREEN_USER_JOIN_STEP1.name, true)
//        }
    }

    // 중복확인 버튼을 눌렀을 때
    fun checkNickName(){
//        // 사용자가 입력한 닉네임
//        val userNickName = textFieldUserJoinStep2NickNameValue.value
//        // 입력한 것이 없다면
//        if(userNickName.isEmpty()){
//            showDialogNickNameEmptyState.value = true
//            return
//        }
//
//        // 사용할 수 있는 닉네임인지 검사한다.
//        CoroutineScope(Dispatchers.Main).launch {
//            val work1 = async(Dispatchers.IO){
//                userService.checkJoinUserNickName(userNickName)
//            }
//            isCheckNickName.value = work1.await()
//
//
//
//            if(isCheckNickName.value){
//                showDialogNickNameOk.value = true
//            } else{
//                textFieldUserJoinStep2NickNameValue.value = ""
//                nickNameFocusRequester.value.requestFocus()
//                showDialogNickNameNo.value = true
//            }
//        }
    }
}









