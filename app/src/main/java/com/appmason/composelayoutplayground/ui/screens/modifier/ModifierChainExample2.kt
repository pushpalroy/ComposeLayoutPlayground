package com.appmason.composelayoutplayground.ui.screens.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appmason.composelayoutplayground.R

@Composable
fun ModifierChainExample2() {
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.Gray),
    ) {
        // Scenario: 1
        // Say the incoming constraints are 300.dp in width and 200.dp in height
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_background),
//            contentDescription = null,
//            modifier = Modifier
//                .align(Alignment.Center)
//                // Results in fixed constraints: Changes the constraints to set both the width and height to the max value passed (300 x 200)
//                .fillMaxSize()
//                // So even though the size modifier requests a size of 100 x 100 it still needs to adhere to the incoming min constraints
//                // Thus it will also output the exact bounds of 300 x 200, ignoring the value we provided in size modifier
//                .size(100.dp)
//        )

        // Scenario: 2
        // Say the incoming constraints are 300.dp in width and 200.dp in height
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                // Results in fixed constraints: Behaves the same as above
                .fillMaxSize()
                // Resets the min constraints, i.e. it resets it back to bounded constraints
                // So the following node can either take entire space or can be smaller
                // Also this has a special modifier: It takes its child and places it in the center of the available min bounds that were passed to it
                .wrapContentSize()
                // Now the size modifier sets the constraints to the min and max value to 100
                .size(100.dp)
        )
    }

}