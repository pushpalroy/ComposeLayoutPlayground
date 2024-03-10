package com.appmason.composelayoutplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.appmason.composelayoutplayground.ui.screens.LayoutModifierExample
import com.appmason.composelayoutplayground.ui.screens.ModifierChainExample1
import com.appmason.composelayoutplayground.ui.screens.ModifierChainExample2
import com.appmason.composelayoutplayground.ui.screens.SimpleIntrinsicExample
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookAheadWithSimpleMovableContent
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookaheadWithAnimatedContentSize
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookaheadWithFlowRow
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookaheadWithLazyColumn
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookaheadWithMovableContent
import com.appmason.composelayoutplayground.ui.screens.lookaheadlayout.LookaheadWithPopularBoxWithConstraintsUsage
import com.appmason.composelayoutplayground.ui.theme.ComposeLayoutPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutPlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Intrinsic Examples
                    // SimpleIntrinsicExample()

                    // Modifier Examples
                    // LayoutModifierExample()
                    // ModifierChainExample1()
                    // ModifierChainExample2()

                    // Look Ahead Examples
                    // LookaheadWithAnimatedContentSize()
                    // LookaheadWithPopularBoxWithConstraintsUsage()
                    // LookaheadWithLazyColumn()
                    // LookaheadWithMovableContent()
                    LookAheadWithSimpleMovableContent()
                    // LookaheadWithFlowRow()
                }
            }
        }
    }
}