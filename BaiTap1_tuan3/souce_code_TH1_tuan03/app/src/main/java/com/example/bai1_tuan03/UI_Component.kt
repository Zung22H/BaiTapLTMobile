package com.example.bai1_tuan03


import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UI_Component : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ui_component_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ui_component)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<LinearLayout>(R.id.layout1).setOnClickListener {
            startActivity(Intent(this, TextDetailActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layout4).setOnClickListener {
            startActivity(Intent(this, ImageDetailActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            startActivity(Intent(this, TextFieldDetailActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layout5).setOnClickListener {
            startActivity(Intent(this, PasswordFieldDetailActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            startActivity(Intent(this, ColumnDetailActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layout6).setOnClickListener {
            startActivity(Intent(this, RowDetailActivity::class.java))
        }
    }
}