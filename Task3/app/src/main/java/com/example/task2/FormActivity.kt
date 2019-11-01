package com.example.task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.fragment.*

class FormActivity : AppCompatActivity() {

    private lateinit var fragment: FormFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        TextViewForm.text = intent.getStringExtra("Question")

        this.fragment = supportFragmentManager.findFragmentById(R.id.second) as FormFragment
        fragment.ButtonFragment.setOnClickListener {
            val intent = Intent()
                intent.putExtra("Answer", fragment.EditTextFragment.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.closeMenu -> {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager, "dialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun finishAndRemoveTask() {
        val intent = Intent()
        intent.putExtra("close app", "close app")
        
        setResult(Activity.RESULT_OK, intent)
        super.finishAndRemoveTask()
    }
}
