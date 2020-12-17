package com.ade.oop2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        btn_siswa.setOnClickListener {

            val go = Intent(this@MainActivity, EditSiswa::class.java)

            startActivity(go)
        }

        btn_guru.setOnClickListener{
            val go = Intent(this@MainActivity, MainActivityEditGuru::class.java)
            startActivity(go)
        }

    }


}