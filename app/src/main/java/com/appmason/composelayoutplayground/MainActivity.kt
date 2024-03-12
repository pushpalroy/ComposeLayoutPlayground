package com.appmason.composelayoutplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookAheadWithApproachLayoutModifier
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookAheadWithApproachLayoutModifier2
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookAheadWithCustomApproachLayoutModifierNode
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.advanced.LookaheadWithAnimatedContentSize
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.advanced.LookaheadWithFlowRow
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.advanced.LookaheadWithLazyColumn
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.advanced.LookaheadWithMovableContent
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.advanced.LookaheadWithPopularBoxWithConstraintsUsage
import com.appmason.composelayoutplayground.ui.theme.ComposeLayoutPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutPlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    /**
                     * Uncomment one example at a time and run
                     */
                    // Intrinsic Examples
                    // SimpleIntrinsicExample()

                    // Modifier Examples
                    // LayoutModifierExample()
                    // ModifierChainExample1()
                    // ModifierChainExample2()

                    // Look Ahead Examples
                    LookAheadWithApproachLayoutModifier()
                    // LookAheadWithApproachLayoutModifier2()
                    // LookAheadWithCustomApproachLayoutModifierNode()

                    // Look Ahead Advanced Examples
                    // LookaheadWithAnimatedContentSize()
                    // LookaheadWithPopularBoxWithConstraintsUsage()
                    // LookaheadWithLazyColumn()
                    // LookaheadWithMovableContent()
                    // LookaheadWithFlowRow()
                }
            }
        }
    }
}