package com.ade.oop2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ade.oop2.db.GuruRoomDatabase
import com.ade.oop2.model.Guru
import kotlinx.android.synthetic.main.activity_view_guru.*
import kotlinx.android.synthetic.main.activity_view_siswa.floatingActionButton
import kotlinx.android.synthetic.main.activity_view_siswa.recycler_view_main

class ViewGuru : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_guru)

        getGuruData()

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, EditGuru::class.java))
        }

    }

    private fun getGuruData(){
        val database = GuruRoomDatabase.getDatabase(applicationContext)
        val dao = database.getGuruDao()
        val listItem = arrayListOf<Guru>()
        listItem.addAll(dao.getAll())
        setupRecyclerView(listItem)
        if (listItem.isNotEmpty()){
            text_view_guru_empty.visibility = View.GONE
        }
        else{
            text_view_guru_empty.visibility = View.VISIBLE
        }
    }

    private fun setupRecyclerView(listItem: ArrayList<Guru>){
        recycler_view_main.apply {
            adapter = GuruAdapter(listItem, object : GuruAdapter.GuruListener{
                override fun OnItemClicked(guru: Guru) {
                    val intent = Intent(this@ViewGuru, EditGuru::class.java)
                    intent.putExtra(EditGuru().EDIT_GURU_EXTRA, guru)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@ViewGuru)
        }
    }

    override fun onResume() {
        super.onResume()
        getGuruData()
    }
}