package com.example.bai2_tuan03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Controller()

        }
    }
}

@Composable
fun Controller() {
    val navHost = rememberNavController()

    NavHost(navController = navHost, startDestination = "home") {
        composable("home") { MainScreen(navHost) }
        composable("home2") { MainScreen2(navHost) }
        composable("home3") { MainScreen3(navHost) }

    }
}

@Composable
fun MainScreen(navHost: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row chứa Page Indicator (bên trái) và Skip (bên phải)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Page Indicator (Bên trái)

            PageIndicator(currentPage = 0, totalPages = 3)

            TextButton(onClick = { /* TODO: Skip action */ }) {
                Text(text = "Skip", color = Color.Gray)
            }

        }


        // Hình ảnh minh họa
        Image(
            painter = painterResource(id = R.drawable.bro),
            contentDescription = "Illustration",
            modifier = Modifier.size(250.dp)
        )

        // Tiêu đề
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Đoạn văn bản mô tả
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = { navHost.navigate("home2") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)

        ) {
            Text(text = "Next", fontSize = 18.sp)
        }

    }
}

@Composable
fun MainScreen2(navHost: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row chứa Page Indicator (bên trái) và Skip (bên phải)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Page Indicator (Bên trái)

            PageIndicator(currentPage = 1, totalPages = 3)

            TextButton(onClick = { }) {
                Text(text = "Skip", color = Color.Gray)
            }

        }

        // Hình ảnh minh họa
        Image(
            painter = painterResource(id = R.drawable.one),
            contentDescription = "Illustration",
            modifier = Modifier.size(250.dp)
        )

        // Tiêu đề
        Text(
            text = "Increase Work Effectiveness",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Đoạn văn bản mô tả
        Text(
            text = "Time management and the determination of more important tasks will give your job statistics better and always improve",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navHost.navigate("home") },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007BFF)
                ),
                modifier = Modifier.size(53.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Back",
                    modifier = Modifier.size(50.dp)
                )
            }

            Button(
                onClick = { navHost.navigate("home3") },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007BFF)
                ),
                modifier = Modifier.size(300.dp, 53.dp)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp
                )
            }
        }

    }
}

@Composable
fun MainScreen3(navHost: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row chứa Page Indicator (bên trái) và Skip (bên phải)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Page Indicator (Bên trái)

            PageIndicator(currentPage = 2, totalPages = 3)

            TextButton(onClick = { }) {
                Text(text = "Skip", color = Color.Gray)
            }

        }

        // Hình ảnh minh họa
        Image(
            painter = painterResource(id = R.drawable.two),
            contentDescription = "Illustration",
            modifier = Modifier.size(250.dp)
        )

        // Tiêu đề
        Text(
            text = "Reminder Notification",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Đoạn văn bản mô tả
        Text(
            text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navHost.navigate("home2") },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007BFF)
                ),
                modifier = Modifier.size(53.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Back",
                    modifier = Modifier.size(50.dp)
                )
            }

            Button(
                onClick = {  },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007BFF)
                ),
                modifier = Modifier.size(300.dp, 53.dp)
            ) {
                Text(
                    text = "Get Started",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp
                )
            }
        }

    }
}

// Component Page Indicator
@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(18.dp) // Chấm đang chọn to hơn
                    .padding(4.dp)
                    .background(
                        color = if (index == currentPage) Color(0xFF2196F3) else Color.LightGray,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Controller()
}
