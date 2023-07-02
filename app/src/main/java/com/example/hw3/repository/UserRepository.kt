package com.example.hw3.repository

import com.example.hw3.R
import com.example.hw3.model.User



class UserRepository {

    private val userList = listOf(
        User(1, "https://example.com/user1", "John", "Description 1", R.drawable.user1),
        User(2, "https://example.com/user2", "Emma", "Description 2", R.drawable.user2),
        User(3, "https://example.com/user3", "Michael", "Description 3", R.drawable.user3),
        // Добавьте остальных пользователей в список
    )

    fun getUserList(): List<User> {
        return userList
    }

    fun getUserById(userId: Int): User? {
        return userList.find { it.id == userId }
    }
}