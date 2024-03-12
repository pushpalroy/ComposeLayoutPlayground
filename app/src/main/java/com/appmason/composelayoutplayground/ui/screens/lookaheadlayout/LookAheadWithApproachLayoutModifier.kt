package com.appmason.composelayoutplayground.ui.screens.lookaheadlayout

import androidx.compose.animation.core.DeferredTargetAnimation
import androidx.compose.animation.core.ExperimentalAnimatableApi
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round

@Composable
fun LookAheadWithApproachLayoutModifier() {
    val colors = listOf(
        Color(0xffff6f69),
        Color(0xffffcc5c),
        Color(0xff264653),
        Color(0xFF679138),
    )
    var isInColumn by remember { mutableStateOf(true) }
    // Creates movable content with [LookaheadScope] as receiver containing 4 boxes.
    // They will be put either in a [Row] or in a [Column] depending on the state.
    val items = remember {
        movableContentWithReceiverOf<LookaheadScope> {
            colors.forEach { color ->
                Box(
                    Modifier
                        .padding(8.dp)
                        .size(80.dp)
                        .animateBounds()
                        .background(color, RoundedCornerShape(10))
                )
            }
        }
    }
    LookaheadScope {
        Box(
            modifier = Modifier.fillMaxSize().clickable { isInColumn = !isInColumn },
            contentAlignment = Alignment.Center
        ) {
            // As the items get moved between Column and Row, their positions in LookaheadScope
            // will change. The `animatePlacementInScope` modifier created above will
            // observe that final position change via `localLookaheadPositionOf`, and create
            // a position animation.
            if (isInColumn) {
                Column { items() }
            } else {
                Row { items() }
            }
        }
    }
}

context (LookaheadScope)
@OptIn(ExperimentalAnimatableApi::class, ExperimentalComposeUiApi::class)
fun Modifier.animateBounds(): Modifier = composed {
    val offsetAnim = remember { DeferredTargetAnimation(IntOffset.VectorConverter) }
    val scope = rememberCoroutineScope()
    this.approachLayout(
        isMeasurementApproachComplete = {
            true
        },
        isPlacementApproachComplete = {
            val target = lookaheadScopeCoordinates.localLookaheadPositionOf(it)
            offsetAnim.updateTarget(target.round(), scope)
            offsetAnim.isIdle
        }
    ) { measurable, constraints ->
        measurable.measure(constraints)
            .run {
                layout(width, height) {
                    coordinates?.let {
                        val target = lookaheadScopeCoordinates.localLookaheadPositionOf(it).round()
                        val animOffset = offsetAnim.updateTarget(target, scope, spring())
                        val current = lookaheadScopeCoordinates.localPositionOf(it, Offset.Zero).round()
                        val (x, y) = animOffset - current
                        place(x, y)
                    } ?: place(0, 0)
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun LookAheadWithApproachLayoutModifierPreview() {
    LookAheadWithApproachLayoutModifier()
}