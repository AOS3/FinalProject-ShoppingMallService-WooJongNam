package com.lion.buyershop.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.util.MainScreenName
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class BuyerOderViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {
    private val buyerApplication = context as BuyerApplication
    val recipiantName = mutableStateOf("")

    val recipientPhoneNumber = mutableStateOf("")
    val PostalCode = mutableStateOf("")
    val address = mutableStateOf("")
    val deliveryMessage = mutableStateOf("")

     fun orderButtonOnClick(){
         buyerApplication.navHostController.navigate(MainScreenName.MAIN_SCREEN_MY_PAGE.name)
     }



}




