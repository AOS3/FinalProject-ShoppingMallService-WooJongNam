package com.lion.buyershop




import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lion.buyershop.screen.BuyerBuyListScreen
import com.lion.buyershop.screen.BuyerFirstScreen
//import com.lion.buyershop.screen.BuyerFirstScreen
import com.lion.buyershop.screen.BuyerMainScreen
import com.lion.buyershop.screen.BuyerOrderScreen
import com.lion.buyershop.screen.BuyerProductInfoScreen
import com.lion.buyershop.screen.UserJoinStep1Screen
import com.lion.buyershop.screen.UserJoinStep2Screen
import com.lion.buyershop.screen.UserLoginScreen
import com.lion.buyershop.ui.theme.BuyerShopTheme
import com.lion.buyershop.util.MainScreenName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuyerShopTheme {
                BuyerShopMain()

            }
        }
    }
}

@Composable
fun BuyerShopMain(){
    // 네비게이션 객체
    val navHostController = rememberNavController()
    // Application 객체에 담는다.
    val buyerApplication = LocalContext.current.applicationContext as BuyerApplication
    buyerApplication.navHostController = navHostController

    // 네비게이션 처리
    NavHost(
        navController = navHostController,
        //startDestination = MainScreenName.MAIN_SCREEN_BUYER_MAIN.name,
        //startDestination = MainScreenName.MAIN_SCREEN_MAIN.name,
        startDestination = MainScreenName.MAIN_SCREEN_USER_LOGIN.name,
        enterTransition = {
            fadeIn(
                tween(300)
            ) +
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start,
                        tween(300)
                    )
        },
        popExitTransition = {
            fadeOut(
                tween(300)
            ) +
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End,
                        tween(300)
                    )
        },
        exitTransition = {
            fadeOut(
                tween(300)
            )
        },
        popEnterTransition = {
            fadeIn(
                tween(300)
            )
        },
    ){
//        composable(
//            route = MainScreenName.MAIN_SCREEN_BUYER_MAIN.name
//        ){
//            //BuyerFirstScreen()
//        }
        composable(
            route = MainScreenName.MAIN_SCREEN_BUY_LIST.name
        ){
            BuyerBuyListScreen()
        }
        composable(
            route = MainScreenName.MAIN_SCREEN_PRODUCT_INFO.name
        ){
            BuyerProductInfoScreen()
        }
        composable(
            route = MainScreenName.MAIN_SCREEN_ORDER.name
        ){
            BuyerOrderScreen()


        }
        composable(
            route = MainScreenName.MAIN_SCREEN_MAIN.name
        ){
            BuyerMainScreen()
        }
        composable(
            route = MainScreenName.MAIN_SCREEN_USER_LOGIN.name
        ){
            UserLoginScreen()
        }
        //////
        composable(
            route = MainScreenName.MAIN_SCREEN_USER_JOIN_STEP1.name
        ){
            UserJoinStep1Screen()
        }
        composable(
            route = "${MainScreenName.MAIN_SCREEN_USER_JOIN_STEP2.name}/{joinUserId}/{joinUserPw}"
        ){
            val joinUserId = it.arguments?.getString("joinUserId")!!
            val joinUserPw = it.arguments?.getString("joinUserPw")!!
            UserJoinStep2Screen(joinUserId = joinUserId, joinUserPw = joinUserPw)
        }
        composable(
            route = MainScreenName.MAIN_SCREEN_PRODUCT_INFO.name
        ){
            BuyerProductInfoScreen()
        }
        composable(
            route = MainScreenName.MAIN_SCREEN_PRODUCT_INFO.name
        ){
            BuyerProductInfoScreen()
        }


    }
}