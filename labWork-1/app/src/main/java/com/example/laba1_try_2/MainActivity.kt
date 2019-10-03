package com.example.laba1_try_2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val REQUES_CODE_MAIN = 23
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButtonMain.setOnClickListener(){
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("Question", EditTextMain.text.toString())
            startActivityForResult(intent, REQUES_CODE_MAIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUES_CODE_MAIN){
            if(resultCode == Activity.RESULT_OK)
                TextViewMain.text = data?.getStringExtra("Answer")
        }
    }
}
