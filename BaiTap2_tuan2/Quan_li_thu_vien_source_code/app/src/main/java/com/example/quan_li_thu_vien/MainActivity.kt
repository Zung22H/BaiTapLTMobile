package com.example.quan_li_thu_vien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryManagementUI()
        }
    }
}

@Composable
fun LibraryManagementUI() {
    var selectedTab by remember { mutableStateOf(0) }
    val employees = remember { mutableStateListOf<String>() }
    val books = remember { mutableStateListOf<String>() }
    var employeeInput by remember { mutableStateOf(TextFieldValue("")) }
    var bookInput by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Quản Lý") },
                    label = { Text("Quản Lý") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Book, contentDescription = "DS Sách") },
                    label = { Text("DS Sách") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Nhân viên") },
                    label = { Text("Nhân viên") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hệ thống Quản lý Thư viện",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            when (selectedTab) {
                0 -> ManagementScreen(employees, books)
                1 -> BookScreen(books, bookInput, { bookInput = it }, { books.add(it) })
                2 -> EmployeeScreen(employees, employeeInput, { employeeInput = it }, { employees.add(it) })
            }
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ManagementScreen(employees: List<String>, books: List<String>) {
    var checkedBooks by remember { mutableStateOf(mutableMapOf<String, Boolean>()) }
    var expanded by remember { mutableStateOf(false) }
    var selectedEmployee by remember { mutableStateOf<String?>(null) }
    val borrowedBooks = remember { mutableStateListOf<Pair<String, List<String>>>() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Nhân viên",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
        )



        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = selectedEmployee ?: "",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .weight(1f)
                        .menuAnchor(), // Đảm bảo menu luôn hiển thị đúng vị trí
                    label = { Text("Chọn nhân viên") }
                )

                Spacer(modifier = Modifier.width(8.dp))


                Button(
                    onClick = { expanded = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
                ) {
                    Text("Đổi", color = Color.White)
                }
            }

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                employees.forEach { employee ->
                    DropdownMenuItem(
                        onClick = {
                            selectedEmployee = employee
                            expanded = false
                        },
                        text = { Text(employee) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Danh sách sách",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        LazyColumn {
            items(books) { book ->
                OutlinedTextField(
                    value = book,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    trailingIcon = {
                        Checkbox(
                            checked = checkedBooks[book] ?: false,
                            onCheckedChange = { isChecked ->
                                checkedBooks = checkedBooks.toMutableMap().apply {
                                    this[book] = isChecked
                                }
                            }
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (selectedEmployee != null) {
                    val selectedBooks = checkedBooks.filterValues { it }.keys.toList()
                    if (selectedBooks.isNotEmpty()) {
                        borrowedBooks.add(selectedEmployee!! to selectedBooks)
                        checkedBooks = mutableMapOf() // Reset sau khi thêm
                    }
                }
            },
            modifier = Modifier.size(200.dp,50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
        ) {
            Text("Thêm", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (borrowedBooks.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp)), // Viền đen
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White) // Nền trắng
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        "Danh sách nhân viên đã mượn sách:",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn {
                        items(borrowedBooks) { (employee, books) ->
                            Text(
                                "$employee đã mượn: ${books.joinToString(", ")}",
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

    }
}








@Composable
fun BookScreen(books: List<String>, inputText: TextFieldValue, onTextChange: (TextFieldValue) -> Unit, onAdd: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Danh sách Sách", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        // Input Field
        OutlinedTextField(
            value = inputText,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            label = { Text("Nhập tên sách") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Add Button
        Button(
            onClick = { if (inputText.text.isNotEmpty()) onAdd(inputText.text) },
            modifier = Modifier.size(200.dp,50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
        ) {
            Text("Thêm")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Book List
        LazyColumn {
            items(books) { book ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray)
                ) {
                    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = false, onCheckedChange = {})
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(book)
                    }
                }
            }
        }
    }
}

@Composable
fun EmployeeScreen(employees: List<String>, inputText: TextFieldValue, onTextChange: (TextFieldValue) -> Unit, onAdd: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Danh sách Nhân viên", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        // Input Field
        OutlinedTextField(
            value = inputText,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            label = { Text("Nhập tên nhân viên") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Add Button
        Button(
            onClick = { if (inputText.text.isNotEmpty()) onAdd(inputText.text) },
            modifier = Modifier.size(200.dp,50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))

        ) {
            Text("Thêm")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Employee List
        LazyColumn {
            items(employees) { employee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(8.dp)), // Viền đen
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White) // Nền trắng
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(employee, color = Color.Black) // Đảm bảo chữ màu đen
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLibraryManagementUI() {
    LibraryManagementUI()
}
