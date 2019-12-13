package com.example.lab5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.dao.db.UserDatabase
import com.example.lab5.dao.entity.User
import com.example.lab5.dao.interfaces.UserDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var db: UserDatabase? = null
    private var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = UserDatabase.getInstance(this.applicationContext)
        userDao = db?.userDao()
    }

    fun getUser(view: View) {
        val firstName = firstNameInput.text.toString()
        val lastName = lastNameInput.text.toString()

        if (firstName.isEmpty() && lastName.isNotEmpty())
            textViewMain.text = userDao?.getUser(lastName).toString()
        else if (firstName.isNotEmpty() and lastName.isNotEmpty())
            textViewMain.text = userDao?.getUser(firstName, lastName).toString()
        else
            textViewMain.text = ""
    }

    fun insertUser(view: View) {
        val user: User = User()

        user.firstName = firstNameInput.text.toString()
        user.lastName = lastNameInput.text.toString()
        user.birthday = birthdayInput.text.toString()

        userDao?.insertUser(user)
    }
}
