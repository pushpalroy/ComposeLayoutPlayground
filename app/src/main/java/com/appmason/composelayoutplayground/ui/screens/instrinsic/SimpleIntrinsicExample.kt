package com.appmason.composelayoutplayground.ui.screens.instrinsic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleIntrinsicExample() {
    Box(modifier = Modifier.background(color = Color.LightGray)) {
        Column(
            modifier = Modifier.padding(16.dp).width(IntrinsicSize.Max)
        ) {
            Message(text = "This")
            Message(text = "Is")
            Message(text = "A")
            Message(text = "Simple")
            Message(text = "Intrinsic")
            Message(text = "Example")
        }
    }
}

@Composable
fun Message(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = modifier.background(color = Color.Gray).fillMaxWidth()
    )
}