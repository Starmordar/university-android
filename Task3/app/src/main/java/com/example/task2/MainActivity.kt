package com.example.task2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment.*

class MainActivity : AppCompatActivity() {

    companion object {
        val REQUES_CODE_MAIN = 23
    }

    private lateinit var fragment: FormFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.fragment = supportFragmentManager.findFragmentById(R.id.first) as FormFragment

        fragment.ButtonFragment.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java).apply {
                putExtra("Question", fragment.EditTextFragment.text.toString())
            }
            startActivityForResult(intent, REQUES_CODE_MAIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUES_CODE_MAIN) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra("close app").equals("close app")) {
                    finish()
                }
                TextViewMain.text = data?.getStringExtra("Answer")
            }
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
}
