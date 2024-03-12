package com.appmason.composelayoutplayground.ui.screens.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

@Composable
fun LayoutModifierExample() {
    Box(modifier = Modifier.background(color = Color.LightGray)) {
        Column(
            modifier = Modifier.padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Element()
            Element()
            // Here the layout modifier lambda grants access to the element we are measuring using measurable
            Element(
                modifier = Modifier.layout { measurable, constraints ->
                    val placeable = measurable.measure(
                        constraints.copy(
                            // Resize the item's maxWidth by adding extra DPs to the incoming constraints
                            maxWidth = constraints.maxWidth + 80.dp.roundToPx()
                        )
                    )
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, 0)
                    }
                }
            )
            // Incoming constraints in the parent layout do not override the set width and instead respect it
            Element(
                modifier = Modifier.requiredWidth(1000.dp)
            )
            // Here the set width is overridden by the parent layout and incoming constraints in the measurement phase
            Element(
                modifier = Modifier.width(1000.dp)
            )
        }
    }
}

@Composable
fun Element(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .background(color = Color.Gray)
            .fillMaxWidth()
    )
}