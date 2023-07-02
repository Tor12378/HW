package com.example.hw3.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3.R
import com.example.hw3.repository.UserRepository

class DetailActivity : AppCompatActivity() {

    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val userId = intent.getIntExtra("userId", -1)
        val user = userRepository.getUserById(userId)

        val textViewId: TextView = findViewById(R.id.textViewId)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)
        val imageView: ImageView = findViewById(R.id.imageView)
        textViewId.text = "ID: ${user?.id}"
        textViewName.text = "Name: ${user?.name}"
        textViewDescription.text = "Description: ${user?.description}"
        imageView.setImageResource(user?.imageResId ?: 0)
    }
}