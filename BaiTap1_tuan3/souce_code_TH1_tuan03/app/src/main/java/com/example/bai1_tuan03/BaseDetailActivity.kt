package com.example.bai1_tuan03

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = findViewById<TextView>(R.id.detailTitle)
        val content = findViewById<TextView>(R.id.detailContent)

        title.text = getTitleText()
        content.text = getContentText()

        val backbutton = findViewById<ImageView>(R.id.backbutton)
        backbutton.setOnClickListener {
            finish()
        }
    }

    abstract fun getTitleText(): String
    abstract fun getContentText(): String
}
