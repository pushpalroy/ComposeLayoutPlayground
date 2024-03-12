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
package com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.officialSamples

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.appmason.composelayoutplayground.R
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.util.animateBounds

@Preview
@Composable
fun LookaheadWithPopularBoxWithConstraintsUsage() {
//    val padding by produceState(initialValue = 0.dp) {
//        while (true) {
//            delay(2000)
//            value = if (value == 0.dp) {
//                100.dp
//            } else {
//                0.dp
//            }
//        }
//    }
    var padding by remember { mutableStateOf(0.dp) }

    LookaheadScope {
        Column {
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = {
                    padding = if (padding == 0.dp) {
                        100.dp
                    } else {
                        0.dp
                    }
                }
            ) {
                Text("Toggle")
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .animateBounds(Modifier.padding(padding))
                    .background(pastelColors[3])
            ) {
                DetailsContent()
            }
        }
    }
}

@Composable
fun DetailsContent() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    Header(this@BoxWithConstraints.maxHeight)
                    Content(this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
fun Content(containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.heightIn(8.dp))
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "John Doe",
                modifier = Modifier.paddingFromBaseline(20.dp),
                fontWeight = FontWeight.Bold
            )
        }
        Property("last name", "Doe")
        Property("first name", "John")
        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun Property(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        HorizontalDivider()
        Text(
            text = label,
            modifier = Modifier.paddingFromBaseline(24.dp),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = value,
            modifier = Modifier.paddingFromBaseline(24.dp),
        )
    }
}

@Composable
fun Header(containerHeight: Dp) {
    val height by animateDpAsState(containerHeight, label = "")
    Image(
        modifier = Modifier
            .heightIn(max = height / 2)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.pepper),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}