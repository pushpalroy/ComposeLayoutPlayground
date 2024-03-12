package com.appmason.composelayoutplayground.ui.screens.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appmason.composelayoutplayground.R

/**
 * Constraints are passed from parent to child in the UI tree during the Layout phase.
 * When a parent node measures its children, it provides these constraints to each child to let them know how
 * big or small they are allowed to be.
 * Constraints can be bounded indicating a min and max width and height.
 * Constraints can also be unbounded in which case the node is not constrained to any size, the max with and heights are then set to infinity.
 * Constraints can also be exact, where a node is asked to follow an exact size requirement, the mix and max bounds are set to the same value
 * Parents measure before their children, but are sized and placed after their children.
 */
@Composable
fun ModifierChainExample1() {
    Column(
        modifier = Modifier.padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .padding(10.dp)
                .size(160.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(160.dp)
        )
    }
}