package com.ade.oop2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ade.oop2.db.SiswaDao
import com.ade.oop2.db.SiswaRoomDatabase
import com.ade.oop2.model.Siswa
import kotlinx.android.synthetic.main.activity_edit_siswa.*

class EditSiswa : AppCompatActivity() {

    val EDIT_SISWA_EXTRA = "edit_siswa_extra"
    private lateinit var siswa: Siswa
    private var isUpdate = false
    private lateinit var database: SiswaRoomDatabase
    private lateinit var dao: SiswaDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_siswa)

        database = SiswaRoomDatabase.getDatabase(applicationContext)
        dao = database.getSiswaDao()

        if (intent.getParcelableExtra<Siswa>(EDIT_SISWA_EXTRA) != null){
            button_delete.visibility = View.VISIBLE
            isUpdate = true
            siswa = intent.getParcelableExtra(EDIT_SISWA_EXTRA)
            edit_text_nama.setText(siswa.nama)
            edit_text_nis.setText(siswa.nis)
            edit_text_kelas.setText(siswa.kelas)

            edit_text_nama.setSelection(siswa.nama.length)

        }

        button_save.setOnClickListener {
            val nama = edit_text_nama.text.toString()
            val nis = edit_text_nis.text.toString()
            val kelas = edit_text_kelas.text.toString()

            if (nama.isEmpty() && nis.isEmpty() && kelas.isEmpty()){
                Toast.makeText(applicationContext, "Siswa cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                if (isUpdate){
                    saveSiswa(Siswa(id = siswa.id, nama = nama, nis = nis, kelas = kelas))
                }
                else{
                    saveSiswa(Siswa(nama = nama, nis = nis, kelas = kelas))
                }
            }

            finish()
        }

        button_delete.setOnClickListener {
            deleteSiswa(siswa)
            finish()
        }

    }

    private fun saveSiswa(siswa: Siswa){

        if (dao.getById(siswa.id).isEmpty()){

            dao.insert(siswa)
        }
        else{

            dao.update(siswa)
        }

        Toast.makeText(applicationContext, "Siswa saved", Toast.LENGTH_SHORT).show()

    }

    private fun deleteSiswa(siswa: Siswa){
        dao.delete(siswa)
        Toast.makeText(applicationContext, "Siswa removed", Toast.LENGTH_SHORT).show()
    }
}
