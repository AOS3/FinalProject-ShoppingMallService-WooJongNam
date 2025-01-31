package com.lion.buyershop.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.R
import com.lion.buyershop.component.LikeLionAlertDialog
import com.lion.buyershop.component.LikeLionCheckBox
import com.lion.buyershop.component.LikeLionDivider
import com.lion.buyershop.component.LikeLionOutlinedButton
import com.lion.buyershop.component.LikeLionOutlinedTextField
import com.lion.buyershop.component.LikeLionOutlinedTextFieldEndIconMode
import com.lion.buyershop.component.LikeLionOutlinedTextFieldInputType
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.component.LikeLionTriStateCheckBox
import com.lion.buyershop.viewmodel.UserJoinStep2ViewModel
import kotlinx.coroutines.launch

@Composable
fun UserJoinStep2Screen(
    userJoinStep2ViewModel: UserJoinStep2ViewModel = hiltViewModel(),
    joinUserId:String,
    joinUserPw:String,
) {

    // step1에서 전달한 아이디와 비밀번호를 ViewModel에 담아준다.
    userJoinStep2ViewModel.joinUserId = joinUserId
    userJoinStep2ViewModel.joinUserPw = joinUserPw


    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "회원 가입",
                navigationIconImage = Icons.AutoMirrored.Filled.ArrowBack,
                navigationIconOnClick = {
                    userJoinStep2ViewModel.buyerApplication.navHostController.popBackStack()
                },
            )
        },

        ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(start = 10.dp, end = 10.dp)
        ) {
            // 닉네임 입력 요소
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep2ViewModel.textFieldUserJoinStep2NickNameValue,
                label = "이름",
                placeHolder = "이름을 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.person_add_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                focusRequest = userJoinStep2ViewModel.nickNameFocusRequester,
                isCheckValue = userJoinStep2ViewModel.isCheckNickName,
            )
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep2ViewModel.textFieldUserJoinStep2NickNameValue,
                label = "전화번호",
                placeHolder = "전화번호를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.person_add_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                focusRequest = userJoinStep2ViewModel.nickNameFocusRequester,
                isCheckValue = userJoinStep2ViewModel.isCheckNickName,
            )
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep2ViewModel.textFieldUserJoinStep2NickNameValue,
                label = "이메일",
                placeHolder = "이메일을 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.person_add_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                focusRequest = userJoinStep2ViewModel.nickNameFocusRequester,
                isCheckValue = userJoinStep2ViewModel.isCheckNickName,
            )

            // 닉네임 중복 확인 버튼
            LikeLionOutlinedButton(
                text = "이메일 중복 확인",
                paddingTop = 10.dp,
                onClick = {
                    userJoinStep2ViewModel.checkNickName()
                }
            )

            // 나이 입력 요소
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep2ViewModel.textFieldUserJoinStep2AgeValue,
                label = "우편번호",
                placeHolder = "우편번호를 입력해주세요",
                inputCondition = "[^0-9]",
                leadingIcon = ImageVector.vectorResource(R.drawable.face_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                paddingTop = 10.dp,
                inputType = LikeLionOutlinedTextFieldInputType.NUMBER,
                focusRequest = userJoinStep2ViewModel.ageFocusRequester,
            )
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep2ViewModel.textFieldUserJoinStep2NickNameValue,
                label = "주소",
                placeHolder = "주소를 입력해주세요",
                leadingIcon = ImageVector.vectorResource(R.drawable.person_add_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                focusRequest = userJoinStep2ViewModel.nickNameFocusRequester,
                isCheckValue = userJoinStep2ViewModel.isCheckNickName,
            )


            LikeLionDivider(
                paddingTop = 10.dp,
                color = Color.DarkGray
            )


            LikeLionOutlinedButton(
                text = "가입 완료",
                paddingTop = 10.dp,
                onClick = {
                    userJoinStep2ViewModel.buttonUserJoinStep2SubmitOnClick()
                },
            )

            // 닉네임을 입력하지 않았을 경우
            LikeLionAlertDialog(
                showDialogState = userJoinStep2ViewModel.showDialogNickNameEmptyState,
                confirmButtonTitle = "확인",
                confirmButtonOnClick = {
                    userJoinStep2ViewModel.showDialogNickNameEmptyState.value = false
                    userJoinStep2ViewModel.nickNameFocusRequester.value.requestFocus()
                },
                title = "이메일 입력 오류",
                text = "이메일을 입력해주세요"
            )

            // 나이를 입력하지 않았을 경우
            LikeLionAlertDialog(
                showDialogState = userJoinStep2ViewModel.showDialogAgeEmptyState,
                confirmButtonTitle = "확인",
                confirmButtonOnClick = {
                    userJoinStep2ViewModel.showDialogAgeEmptyState.value = false
                    userJoinStep2ViewModel.ageFocusRequester.value.requestFocus()
                },
                title = "나이 입력 오류",
                text = "나이를 입력해주세요"
            )

            // 닉네임 중복 확인을 하지 않은 경우
            LikeLionAlertDialog(
                showDialogState = userJoinStep2ViewModel.showDialogNickNameIsNotCheckState,
                confirmButtonTitle = "확인",
                confirmButtonOnClick = {
                    userJoinStep2ViewModel.showDialogNickNameIsNotCheckState.value = false
                },
                title = "닉네임 중복 확인 오류",
                text = "닉네임 중복 확인을 해주세요"
            )

            // 사용할 수 있는 닉네임인 경우
            LikeLionAlertDialog(
                showDialogState = userJoinStep2ViewModel.showDialogNickNameOk,
                confirmButtonTitle = "확인",
                confirmButtonOnClick = {
                    userJoinStep2ViewModel.showDialogNickNameOk.value = false
                },
                title = "닉네임 중복 확인",
                text = "사용할 수 있는 닉네임 입니다",
            )

            // 이미 존재하는 닉네임인 경우
            LikeLionAlertDialog(
                showDialogState = userJoinStep2ViewModel.showDialogNickNameNo,
                confirmButtonTitle = "확인",
                confirmButtonOnClick = {
                    userJoinStep2ViewModel.showDialogNickNameNo.value = false
                },
                title = "닉네임 중복 확인",
                text = "이미 존재하는 닉네임 입니다"
            )
        }
    }
}