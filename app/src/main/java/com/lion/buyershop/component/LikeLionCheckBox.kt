package com.lion.buyershop.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LikeLionCheckBox(
    text:String = "CheckBox",
    checkedValue: MutableState<Boolean> = mutableStateOf(false),
    paddingTop:Dp = 0.dp,
    onCheckedChange:() -> Unit = {},
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = paddingTop)
    ){
        Checkbox(
            checked = checkedValue.value,
            onCheckedChange = {
                checkedValue.value = it
                onCheckedChange()
            }
        )

        Text(
            modifier = Modifier.clickable {
                checkedValue.value = !checkedValue.value
                onCheckedChange()
            },
            text = text
        )
    }
}