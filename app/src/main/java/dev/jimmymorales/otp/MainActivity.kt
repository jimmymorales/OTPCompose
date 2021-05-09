package dev.jimmymorales.otp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.otp.ui.theme.OTPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OTPTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OtpItem(value = 5)
                }
            }
        }
    }
}

@Composable
fun OtpItem(value: Int) {
    Box(
        modifier = Modifier.size(80.dp),
        contentAlignment = Alignment.Center,
    ) {
        val sweep = remember { Animatable(initialValue = 0f) }
        LaunchedEffect(value) {
            sweep.animateTo(
                targetValue = 2f,
                animationSpec = tween(durationMillis = 1_000, easing = LinearEasing),
            )
        }

        val sweepRange = 0f..1f
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .rotate(degrees = 180f),
            elevation = 4.dp,
            border = BorderStroke(
                width = 1.dp,
                brush = Brush.sweepGradient(
                    0F to MaterialTheme.colors.secondary,
                    (sweep.value - 1f).coerceIn(sweepRange) to MaterialTheme.colors.secondary,
                    sweep.value.coerceIn(sweepRange) to Color.Transparent,
                )
            ),
            shape = RoundedCornerShape(16.dp)
        ) {}
        Text(
            text = "$value",
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OTPTheme(darkTheme = true) {
        OtpItem(value = 5)
    }
}