package com.example.baitap1_tuan5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.common.api.ApiException
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable


class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        // Cấu hình Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Lấy từ strings.xml
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        setContent {
            val context = LocalContext.current

            // State lưu thông tin người dùng
            var userName by rememberSaveable { mutableStateOf("") }
            var userEmail by rememberSaveable { mutableStateOf("") }
            var userPhotoUrl by rememberSaveable { mutableStateOf("") }


            val googleSignInLauncher =
                rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    try {
                        val account = task.getResult(ApiException::class.java)
                        firebaseAuthWithGoogle(
                            account.idToken!!,
                            onSuccess = { name, email, photoUrl ->
                                userName = name
                                userEmail = email
                                userPhotoUrl = photoUrl
                            }
                        )
                    } catch (e: Exception) {
                        Toast.makeText(context, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show()
                    }
                }

            val signInWithGoogle: () -> Unit = {
                googleSignInClient.signOut().addOnCompleteListener {
                    val signInIntent = googleSignInClient.signInIntent
                    googleSignInLauncher.launch(signInIntent)
                }

            }
            val signInAsGuest : () -> Unit = {
                auth.signInAnonymously()
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val guestName = "Guest"
                            val guestEmail = "N/A"
                            val guestPhotoUrl = ""

                            // Cập nhật UI với thông tin Guest
                            userName = guestName
                            userEmail = guestEmail
                            userPhotoUrl = guestPhotoUrl
                        } else {
                            Toast.makeText(this, "Guest login failed!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }


            // Kiểm tra nếu đã có user -> Chuyển sang màn hình Profile
            if (userName.isNotEmpty()) {
                ProfileScreen(userName, userEmail, userPhotoUrl)
            } else {
                SmartTasksScreen(onSignInClick = signInWithGoogle,onGuestClick = signInAsGuest)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String, onSuccess: (String, String, String) -> Unit) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.reload()?.addOnCompleteListener { reloadTask -> // Thêm reload() để cập nhật thông tin mới
                        if (reloadTask.isSuccessful) {
                            val updatedUser = auth.currentUser
                            updatedUser?.let {
                                val name = it.displayName ?: "Unknown"
                                val email = it.email ?: "No email"
                                val photoUrl = it.photoUrl?.toString() ?: ""

                                // Gọi callback để cập nhật UI
                                onSuccess(name, email, photoUrl)
                            }
                        } else {
                            Toast.makeText(this, "Không thể cập nhật thông tin người dùng!", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show()
                }
            }
    }
}





    @Composable
fun SmartTasksScreen(onSignInClick: () -> Unit , onGuestClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.uth_logo), // Thay bằng logo của bạn
            contentDescription = "UTH Logo",
            modifier = Modifier.size(140.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "SmartTasks",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3) // Sửa màu HEX đúng
        )
        Text(
            text = "A simple and efficient to-do app",
            fontSize = 14.sp,
            color = Color(0xFF2196F3)
        )

        Spacer(modifier = Modifier.height(170.dp)) // Giảm khoảng cách

        Text(
            text = "Welcome",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Ready to explore? Log in to get started.",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp)) // Giữ khoảng cách hợp lý


        GoogleSignInButton(onClick = onSignInClick)
        Button(
            onClick = onGuestClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            modifier = Modifier.fillMaxWidth().height(60.dp)
        ) {
            Text(text = "Continue as Guest", color = Color.White, fontSize = 18.sp)
        }



        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "© UTHSmartTasks",
            modifier = Modifier.padding(bottom = 4.dp),
            color = Color.Gray,
            fontSize = 18.sp
        )

    }
}


@Composable
fun GoogleSignInButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Xóa màu nền
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier

            .fillMaxWidth()
            .height(60.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.google_signin), // Thay bằng icon Google
            contentDescription = "Google Sign-In",
            contentScale = ContentScale.FillBounds, // Giúp ảnh tràn đều nút
            modifier = Modifier.size(250.dp)// Ảnh tràn toàn bộ button
        )
    }
}

    @Composable
    fun ProfileScreen(name: String, email: String, photoUrl: String) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop
                )
                IconButton (onClick = { /* Mở gallery để thay ảnh */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera_profile),
                        contentDescription = "Change Profile Picture",
                        tint = Color(0xFF2196F3),
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White, CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Profile", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))

            Spacer(modifier = Modifier.height(16.dp))

            ProfileTextField("Name", name)
            ProfileTextField("Email", email)
            

            Spacer(modifier = Modifier.height(32.dp))
            val context = LocalContext.current
            Button(
                onClick = {val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text(text = "Back", color = Color.White, fontSize = 18.sp)
            }
        }
    }

    // Composable hiển thị thông tin người dùng
    @Composable
    fun ProfileTextField(label: String, value: String) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = label, fontSize = 14.sp, color = Color.Gray)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = value, fontSize = 16.sp, color = Color.Black)
            }
        }
    }



    @Preview(showBackground = true)
@Composable
fun GreetingPreview() {


}