package com.ade.oop2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ade.oop2.db.SiswaRoomDatabase
import com.ade.oop2.model.Siswa
import kotlinx.android.synthetic.main.activity_view_siswa.*

class ViewSiswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_siswa)

        getSiswaData()

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, EditSiswaActivity::class.java))
        }

    }

    private fun getSiswaData(){
        val database = SiswaRoomDatabase.getDatabase(applicationContext)
        val dao = database.getSiswaDao()
        val listItems = arrayListOf<Siswa>()
        listItems.addAll(dao.getAll())
        setupRecyclerView(listItems)
        if (listItems.isNotEmpty()){
            text_view_siswa_empty.visibility = View.GONE
        }
        else{
            text_view_siswa_empty.visibility = View.VISIBLE
        }
    }

    private fun setupRecyclerView(listItems: ArrayList<Siswa>){
        recycler_view_main.apply {
            adapter = SiswaAdapter(listItems, object : SiswaAdapter.SiswaListener{
                override fun OnItemClicked(siswa: Siswa) {
                    val intent = Intent(this@ViewSiswa, EditSiswaActivity::class.java)
                    intent.putExtra(EditSiswaActivity().EDIT_SISWA_EXTRA, siswa)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@ViewSiswa)
        }
    }

    override fun onResume() {
        super.onResume()
        getSiswaData()
    }
}
