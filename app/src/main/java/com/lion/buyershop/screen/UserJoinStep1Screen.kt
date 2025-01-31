package com.lion.buyershop.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.buyershop.R
import com.lion.buyershop.component.LikeLionOutlinedButton
import com.lion.buyershop.component.LikeLionOutlinedTextField
import com.lion.buyershop.component.LikeLionOutlinedTextFieldEndIconMode
import com.lion.buyershop.component.LikeLionOutlinedTextFieldInputType
import com.lion.buyershop.component.LikeLionTopAppBar
import com.lion.buyershop.viewmodel.UserJoinStep1ViewModel

@Composable
fun UserJoinStep1Screen(userJoinStep1ViewModel: UserJoinStep1ViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            LikeLionTopAppBar(
                title = "회원 가입",
                navigationIconImage = Icons.AutoMirrored.Filled.ArrowBack,
                navigationIconOnClick = {
                    userJoinStep1ViewModel.navigationIconOnClick()
                },
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(start = 10.dp, end = 10.dp)
        ) {
            // 아이디 입력 요소
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep1ViewModel.textFieldUserJoinStep1IdValue,
                label = "아이디",
                placeHolder = "아이디를 입력해주세요",
                inputCondition = "[^a-zA-Z0-9_]",
                leadingIcon = ImageVector.vectorResource(R.drawable.person_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,
                supportText = userJoinStep1ViewModel.textFieldUserJoinStep1IdErrorText,
                isError = userJoinStep1ViewModel.textFieldUserJoinStep1IdIsError,
                isCheckValue = userJoinStep1ViewModel.isCheckUserId,

                )

            // 중복 확인 버튼
            LikeLionOutlinedButton(
                text = "아이디 중복 확인",
                paddingTop = 10.dp,
                onClick = {
                    userJoinStep1ViewModel.buttonCheckUserIdOnClick()
                }
            )

            // 비밀번호 입력 1 요소
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep1ViewModel.textFieldUserJoinStep1Password1Value,
                label = "비밀번호",
                placeHolder = "비밀번호를 입력해주세요",
                inputCondition = "[^a-zA-Z0-9_]",
                leadingIcon = ImageVector.vectorResource(R.drawable.key_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.PASSWORD,
                singleLine = true,
                paddingTop = 10.dp,
                inputType = LikeLionOutlinedTextFieldInputType.PASSWORD,
                supportText = userJoinStep1ViewModel.textFieldUserJoinStep1Password1ErrorText,
                isError = userJoinStep1ViewModel.textFieldUserJoinStep1Password1IsError,
            )

            // 비밀번호 입력 2 요소
            LikeLionOutlinedTextField(
                textFieldValue = userJoinStep1ViewModel.textFieldUserJoinStep1Password2Value,
                label = "비밀번호",
                placeHolder = "비밀번호를 입력해주세요",
                inputCondition = "[^a-zA-Z0-9_]",
                leadingIcon = ImageVector.vectorResource(R.drawable.key_24px),
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.PASSWORD,
                singleLine = true,
                paddingTop = 10.dp,
                inputType = LikeLionOutlinedTextFieldInputType.PASSWORD,
                supportText = userJoinStep1ViewModel.textFieldUserJoinStep1Password2ErrorText,
                isError = userJoinStep1ViewModel.textFieldUserJoinStep1Password2IsError,
            )

            // 다음 버튼
            LikeLionOutlinedButton(
                text = "다음",
                paddingTop = 10.dp,
                onClick = {
                    userJoinStep1ViewModel.buttonNextOnClick()
                }
            )
        }
    }
}