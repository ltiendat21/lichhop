package com.tlu.appquanlylichhop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DsCuocHopActivity : AppCompatActivity() {
    private lateinit var btn_trove : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dong_ds)

        btn_trove = findViewById(R.id.btn_trove)
        btn_trove.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



}