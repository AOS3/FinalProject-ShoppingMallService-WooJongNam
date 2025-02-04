package com.lion.buyershop.viewmodel


import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import com.lion.buyershop.util.MainScreenName
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class BuyerMyPageViewModel @Inject constructor(
    @ApplicationContext context: Context,
) : ViewModel() {
    val buyerApplication = context as BuyerApplication
}