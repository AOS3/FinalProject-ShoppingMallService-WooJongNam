package com.lion.buyershop.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LikeLionOutlinedButtonRow(
    text: String = "OutlinedButton",
    paddingTop: Dp = 10.dp,
    modifier: Modifier = Modifier, // ✅ modifier 매개변수 추가
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier.padding(top = paddingTop), // ✅ 외부에서 받은 modifier 적용
        onClick = onClick
    ) {
        Text(text = text)
    }
}
