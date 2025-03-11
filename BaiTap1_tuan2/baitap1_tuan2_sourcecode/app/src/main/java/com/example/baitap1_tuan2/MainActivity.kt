package com.example.baitap1_tuan2

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.baitap1_tuan2.ui.theme.Baitap1_tuan2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Baitap1_tuan2Theme {
                AgeCheckerScreen()
                }
            }
        }
    }


@Composable
fun AgeCheckerScreen() {
    var name by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "THỰC HÀNH 01",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
        )


        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Họ và tên",
                        modifier = Modifier.align(Alignment.CenterVertically)
                            .width(80.dp)
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tuổi",
                        modifier = Modifier.align(Alignment.CenterVertically)
                                .width(80.dp),
                    )
                    OutlinedTextField(
                        value = ageInput,
                        onValueChange = { ageInput = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp), // Bo góc input
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .weight(0.5f)
                            .height(50.dp)
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val age = ageInput.toIntOrNull()
                result = when {
                    name.isBlank() || age == null  -> "Vui lòng nhập đầy đủ thông tin!"
                    age <= 0 -> "Tuổi không xác định vui lòng nhập lại"
                    age > 65 -> "$name thuộc nhóm: Người già"
                    age in 7..65 -> "$name thuộc nhóm: Người lớn"
                    age in 2..6 -> "$name thuộc nhóm: Trẻ em"
                    else -> "$name thuộc nhóm: Em bé"
                }
            },
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally),
            colors =ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Blue
            )

        ) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = result, style = MaterialTheme.typography.bodyLarge, color = Color.Red)
    }
}
 @Preview(showBackground = true)
@Composable
fun PreviewAgeChecker() {
    Baitap1_tuan2Theme {
        AgeCheckerScreen()
    }
}