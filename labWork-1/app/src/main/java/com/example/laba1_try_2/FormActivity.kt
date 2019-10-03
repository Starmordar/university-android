package com.example.laba1_try_2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        TextViewForm.text = intent.getStringExtra("Question")

        ButtonForm.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Answer", EditTextForm.text.toString())

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
