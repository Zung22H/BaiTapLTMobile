package com.example.bai2_tuan04

import android.os.Bundle
import androidx.compose.material3.NavigationBar


import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
//import retrofit2.
//import retrofit2.
//import retrofit2.
import java.net.HttpURLConnection
import java.net.URL


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
        composable("home4") { MainScreen4(navHost) }

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
                onClick = { navHost.navigate("home4") },
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


@Composable
fun MainScreen4(navHost: NavHostController) {
    Scaffold(bottomBar = { Bottom_Bar() }, content = { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image1),
                    contentDescription = "UTH Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "SmartTasks",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2196F3),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "A simple and efficient to-do app",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.notifications_1),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(50.dp)

                )
            }


            Spacer(modifier = Modifier.height(32.dp))



            TaskListScreen()


        }
    })

}

@Composable
fun TaskItem(
    title: String,
    description: String,
    status: String,
    time: String,
    backgroundColor: Color
) {
    var isChecked by remember { mutableStateOf(false) } // Trạng thái của Checkbox
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }, // Cập nhật trạng thái khi nhấn
                modifier = Modifier.padding(end = 8.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(text = description, fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Status: $status", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(text = time, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun TaskListScreen(viewModel: TaskViewModel = TaskViewModel()) {
    val tasks by viewModel.tasks.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTasks() // Gọi API khi màn hình được mở
    }
if(tasks.isEmpty()){
    EmptyScreen()
}else {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(tasks) { task ->
            TaskItem(
                title = task?.title.toString(),
                description = task?.description.toString(),
                status = task?.status.toString(),
                time = task?.dueDate.toString(),
                backgroundColor = when (task?.status) {
                    "In Progress" -> Color(0xFFFFC1C1) // Màu hồng
                    "Pending" -> Color(0xFFDFF0B4) // Màu xanh nhạt
                    else -> Color(0xFFBEE3F8) // Màu xanh dương
                },
            )
        }
    }
}
}

@Composable
fun EmptyScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.emty),
                contentDescription = "No Tasks",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.6f), // Chiếm 60% chiều cao màn hình
                contentScale = ContentScale.Fit // Hiển thị vừa đủ không méo ảnh
            )
            Text(
                text = "No tasks available",
                fontSize = 18.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .padding(4.dp)
                    .background(
                        color = if (index == currentPage) Color(0xFF2196F3) else Color.LightGray,
                        shape = CircleShape
                    )
            )
        }
    }
}


@Composable
fun Bottom_Bar() {
    BottomAppBar {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Nền của Bottom Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {

            }

            // Hàng chứa các icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithText(Icons.Default.Home)
                IconWithText(Icons.Default.DateRange)


                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFF2196F3)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

                IconWithText(Icons.Default.MailOutline)
                IconWithText(Icons.Default.Settings)
            }
        }
    }
}

@Composable
fun IconWithText(icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}



