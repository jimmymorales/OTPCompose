package dev.jimmymorales.otp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Surface(elevation = 4.dp) {
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "$value",
            style = MaterialTheme.typography.h1
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