package com.example.bai2_tuan04


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview


import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000) // Chờ 2 giây
        onTimeout() // Gọi hàm chuyển sang MainActivity
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "UTH Logo",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "UTH SmartTasks",
                fontSize = 30.sp,
                color = Color(0xFF006EE9),
                fontWeight = FontWeight.Normal,
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(
                            googleFont = GoogleFont("Righteous"),
                            fontProvider = GoogleFont.Provider(
                                providerAuthority = "com.google.android.gms.fonts",
                                providerPackage = "com.google.android.gms",
                                certificates = emptyList()
                            ),
                            weight = FontWeight.Normal
                        )
                    )
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Greeting1Preview() {
    SplashScreen(

        onTimeout = {}
    )
}



