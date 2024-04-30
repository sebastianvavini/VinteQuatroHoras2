package com.sebastiaomoura.vintequatrohoras2

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sebastiaomoura.vintequatrohoras2.ui.theme.VinteQuatroHoras2Theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Canvas



import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.graphics.red
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinteQuatroHoras2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CircleWithLetters()
                }
            }
        }
    }
}
@Composable
fun CircleWithLetters() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val density = LocalDensity
        val radius = size.minDimension / 2 - 50 // Adjust as needed

        val centerX = size.width / 2
        val centerY = size.height / 2

        // Draw circle
       // drawCircle(Color.Black, radius = radius)

        // Draw letters
        drawIntoCanvas {
            val canvas = it.nativeCanvas
            val angleStep = (2 * PI) / 24
            val letterSize = with(density) { 0.6.sp.toPx() }

            for (i in 0 until 24) {
                val x = centerX + (radius * cos(i * angleStep)).toFloat()
                val y = centerY + (radius * sin(i * angleStep)).toFloat()

                val letter = (0 + i).toString()

                //canvas.drawCircle(x, y, 5f, Paint()) // Example: Draw a small circle at each point
               canvas.drawText(letter, x - letterSize / 2, y + letterSize / 2, Paint())
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VinteQuatroHoras2Theme {
        CircleWithLetters()
    }
}