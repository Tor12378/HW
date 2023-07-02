package com.example.hw3.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3.R
import com.example.hw3.model.User
import com.example.hw3.repository.UserRepository

class ListActivity : AppCompatActivity() {

    private val userRepository = UserRepository()
    private lateinit var userList: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val buttonShowUsers = findViewById<Button>(R.id.buttonShowUsers)
        buttonShowUsers.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        userList = userRepository.getUserList()

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList.map { it.name })
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val userId = userList[position].id
            navigateToDetailScreen(userId)
        }
    }

    private fun navigateToDetailScreen(userId: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("userId", userId)
        startActivity(intent)
    }
}