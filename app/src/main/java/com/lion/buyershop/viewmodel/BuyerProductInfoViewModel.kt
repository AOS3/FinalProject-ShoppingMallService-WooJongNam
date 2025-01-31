package com.lion.buyershop.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lion.buyershop.BuyerApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class BuyerProductInfoViewModel @Inject constructor(
    @ApplicationContext context: Context,

    ) : ViewModel() {

    val buyerApplication = context as BuyerApplication
    var selectedColor by mutableStateOf("색상선택")
    var selectedGrade by mutableStateOf("등급선택")


}