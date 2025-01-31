package com.lion.buyershop.component

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDropdown(
    title: String,
    options: List<String>,
    selectedOption: String, // 외부에서 상태를 받음
    onOptionSelected: (String) -> Unit, // 선택 시 호출될 함수 추가
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedOption, // 외부 상태 사용
            onValueChange = {},
            readOnly = true,
            label = { Text(title, fontSize = 14.sp) },
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 11.sp),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, fontSize = 16.sp, fontWeight = FontWeight.Normal) },
                    onClick = {
                        onOptionSelected(option) // 선택한 값 업데이트
                        expanded = false
                    }
                )
            }
        }
    }
}
