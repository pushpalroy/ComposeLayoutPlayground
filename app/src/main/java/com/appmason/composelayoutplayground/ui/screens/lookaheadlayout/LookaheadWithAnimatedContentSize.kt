/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appmason.composelayoutplayground.ui.screens.lookaheadlayout

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay

@Preview
@Composable
fun LookaheadWithAnimatedContentSize() {
//    val expanded by produceState(initialValue = true) {
//        while (true) {
//            delay(2000)
//            value = !value
//        }
//    }
    var expanded by remember { mutableStateOf(false) }

    LookaheadScope {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    expanded = !expanded
                }
            ) {
                Text(text = "Toggle")
            }
            Spacer(modifier = Modifier.height(48.dp))
            Column(
                Modifier
                    .then(
                        if (expanded) Modifier.fillMaxWidth() else Modifier
                    )
                    .animateContentSize()
                    .zIndex(2f)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(pastelColors[0])
                )
                if (expanded) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .background(Color.White)
                    )
                }
            }
            Box(
                Modifier
                    .animateBounds()
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(pastelColors[1])
            )
        }
    }
}

internal val pastelColors = listOf(
    Color(0xFFffd7d7),
    Color(0xFFffe9d6),
    Color(0xFFfffbd0),
    Color(0xFFe3ffd9),
    Color(0xFFd0fff8)
)