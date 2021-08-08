package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var startBtn : Button
    private lateinit var etNameText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.btn_start)
        etNameText = findViewById(R.id.et_name)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        startBtn.setOnClickListener {
            if (etNameText.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(applicationContext,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etNameText.text.toString())
                startActivity(intent)
                finish()

            }
        }


    }
}