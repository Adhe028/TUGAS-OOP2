package com.ade.oop2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);
        btn_siswa.setOnClickListener {

            val go = Intent(this@Home, ViewSiswa::class.java)

            startActivity(go)
        }

        btn_guru.setOnClickListener {

            val go = Intent(this@Home, ViewGuru::class.java)

            startActivity(go)
        }
    }
}