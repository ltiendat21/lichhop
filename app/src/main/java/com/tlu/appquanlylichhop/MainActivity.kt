package com.tlu.appquanlylichhop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnThemCuocHop:Button
    private lateinit var btn_DanhSachCuocHop : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThemCuocHop = findViewById(R.id.btn_ThemCuocHop)
        btnThemCuocHop.setOnClickListener {
            val intent: Intent = Intent(this, ThemActivity::class.java)
            startActivity(intent)

        }

        btn_DanhSachCuocHop = findViewById(R.id.btn_DanhSachCuocHop)
        btn_DanhSachCuocHop.setOnClickListener {
            val intent: Intent = Intent(this, DsCuocHopActivity::class.java)
            startActivity(intent)

        }


    }

}