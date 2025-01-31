package com.lion.buyershop

import android.app.Application
import androidx.compose.material3.DrawerState
import androidx.navigation.NavHostController
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class BuyerApplication : Application()    {
    // 네비게이션
    lateinit var navHostController: NavHostController
    // NavigationDrawer를 제어하기 위한 변수
    lateinit var navigationDrawerState : DrawerState
    // 로그인한 사용자 객체
    //lateinit var loginUserModel:UserModel
}