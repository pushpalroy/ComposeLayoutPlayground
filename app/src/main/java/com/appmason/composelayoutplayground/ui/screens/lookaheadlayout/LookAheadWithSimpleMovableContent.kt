package com.appmason.composelayoutplayground.ui.screens.lookaheadlayout

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
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.util.animatePlacementInScope

@Composable
fun LookAheadWithSimpleMovableContent() {
    val colors = listOf(
        Color(0xffff6f69),
        Color(0xffffcc5c),
        Color(0xff264653),
        Color(0xFF679138),
    )
    var isInColumn by remember { mutableStateOf(true) }
    LookaheadScope {
        // Creates movable content containing 4 boxes.
        // They will be put either in a [Row] or in a [Column] depending on the state.
        val items = remember {
            movableContentOf {
                colors.forEach { color ->
                    Box(
                        Modifier
                            .padding(8.dp)
                            .size(80.dp)
                            .animatePlacementInScope(this)
                            .background(color, RoundedCornerShape(10))
                    )
                }
            }
        }

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

@Preview(showBackground = true)
@Composable
fun LookAheadWithSimpleMovableContentPreview() {
    LookAheadWithSimpleMovableContent()
}