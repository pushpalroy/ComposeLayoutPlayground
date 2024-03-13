package com.appmason.composelayoutplayground.ui.screens.lookaheadlayout

import androidx.compose.animation.core.DeferredTargetAnimation
import androidx.compose.animation.core.ExperimentalAnimatableApi
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round

@Composable
fun ContainerTransformAnimationWithLookahead() {
    var isExpanded by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxSize().clickable { isExpanded = !isExpanded },
        color = Color(0xFFFFFFFF)
    ) {
        val headerImage = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .drawBehind {
                            drawCircle(Color(0xFF949494))
                        }
                )
            }
        }
        val headerTitle = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(100)
                        }
                        .background(Color(0xFFACACAC))
                )
            }
        }
        val headerSubTitle = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(100)
                        }
                        .background(Color(0xFFC2C2C2))
                )
            }
        }
        val headerContainer = remember {
            movableContentWithReceiverOf<LookaheadScope, @Composable () -> Unit> { content ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .padding(16.dp)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(10)
                        }
                        .background(Color(0xFFE7E7E7))
                ) {
                    content()
                }
            }
        }
        val attributeColors = listOf(
            Color(0xFFFF928D),
            Color(0xFFFFDB8D),
            Color(0xFFA7E5FF),
            Color(0xFFB6E67F),
        )
        val attributes = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier, @Composable () -> Unit> { modifier, content ->
                attributeColors.forEach { color ->
                    Box(
                        Modifier
                            .animateLayout()
                            .graphicsLayer {
                                clip = true
                                shape = RoundedCornerShape(10)
                            }
                            .background(color)
                            .then(modifier)
                    ) {
                        content()
                    }
                }
            }
        }
        val attributeImage = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .drawBehind {
                            drawCircle(Color(0x99FFFFFF))
                        }
                )
            }
        }
        val attributeTitle = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(100)
                        }
                        .background(Color(0x99FFFFFF))
                )
            }
        }
        val attributeSubtitle = remember {
            movableContentWithReceiverOf<LookaheadScope, Modifier> { modifier ->
                Box(
                    modifier = Modifier
                        .animateLayout()
                        .then(modifier)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(100)
                        }
                        .background(Color(0x99FFFFFF))
                )
            }
        }
        LookaheadScope {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(if (isExpanded) 1f else 4f),
                    contentAlignment = if (isExpanded) Alignment.TopStart else Alignment.Center
                ) {
                    if (isExpanded) {
                        headerContainer {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                headerImage(Modifier.size(48.dp))
                                Spacer(Modifier.width(16.dp))
                                Column {
                                    headerTitle(Modifier.height(20.dp).width(280.dp))
                                    Spacer(Modifier.height(16.dp))
                                    headerSubTitle(Modifier.height(20.dp).width(172.dp))
                                }
                            }
                        }
                    } else {
                        headerContainer {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                headerImage(Modifier.size(120.dp))
                                Spacer(Modifier.height(32.dp))
                                headerTitle(Modifier.height(24.dp).width(280.dp))
                                Spacer(Modifier.height(16.dp))
                                headerSubTitle(Modifier.height(24.dp).width(172.dp))
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(if (isExpanded) 4f else 1f)
                        .padding(horizontal = 8.dp)
                ) {
                    if (isExpanded) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            attributes(
                                Modifier.height(140.dp).fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp).fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    attributeImage(Modifier.size(64.dp))
                                    Spacer(Modifier.width(16.dp))
                                    Column {
                                        attributeTitle(Modifier.height(20.dp).fillMaxWidth())
                                        Spacer(Modifier.height(16.dp))
                                        attributeSubtitle(Modifier.height(20.dp).fillMaxWidth())
                                    }
                                }
                            }
                        }
                    } else {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            attributes(
                                Modifier.size(width = 64.dp, height = 80.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    attributeImage(Modifier.size(32.dp))
                                    Spacer(Modifier.height(8.dp))
                                    attributeTitle(Modifier.height(16.dp).fillMaxWidth())
                                    attributeSubtitle(Modifier.size(0.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

context (LookaheadScope)
@OptIn(ExperimentalAnimatableApi::class, ExperimentalComposeUiApi::class)
fun Modifier.animateLayout(): Modifier = composed {
    val sizeAnim = remember { DeferredTargetAnimation(IntSize.VectorConverter) }
    val offsetAnim = remember { DeferredTargetAnimation(IntOffset.VectorConverter) }
    val scope = rememberCoroutineScope()
    this.approachLayout(
        isMeasurementApproachComplete = { lookaheadSize ->
            sizeAnim.updateTarget(lookaheadSize, scope, tween(1800))
            sizeAnim.isIdle
        },
        isPlacementApproachComplete = { lookaheadCoordinates ->
            val target = lookaheadScopeCoordinates.localLookaheadPositionOf(lookaheadCoordinates)
            offsetAnim.updateTarget(target.round(), scope, tween(1800))
            offsetAnim.isIdle
        }
    ) { measurable, _ ->
        val (animWidth, animHeight) = sizeAnim.updateTarget(lookaheadSize, scope)
        measurable.measure(Constraints.fixed(animWidth, animHeight))
            .run {
                layout(width, height) {
                    coordinates?.let {
                        val target = lookaheadScopeCoordinates.localLookaheadPositionOf(it).round()
                        val animOffset = offsetAnim.updateTarget(target, scope)
                        val current = lookaheadScopeCoordinates.localPositionOf(it, Offset.Zero).round()
                        val (x, y) = animOffset - current
                        place(x, y)
                    } ?: place(0, 0)
                }
            }
    }
}

@Preview
@Composable
fun ContainerTransformAnimationWithLookaheadPreview() {
    ContainerTransformAnimationWithLookahead()
}