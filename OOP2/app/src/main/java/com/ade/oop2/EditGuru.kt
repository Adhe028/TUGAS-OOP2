package com.ade.oop2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ade.oop2.db.GuruDao
import com.ade.oop2.db.GuruRoomDatabase
import com.ade.oop2.model.Guru
import kotlinx.android.synthetic.main.activity_edit_guru.*
import kotlinx.android.synthetic.main.activity_edit_siswa.button_delete
import kotlinx.android.synthetic.main.activity_edit_siswa.button_save
import kotlinx.android.synthetic.main.activity_edit_siswa.edit_text_nama


class EditGuru : AppCompatActivity() {

    val EDIT_GURU_EXTRA = "edit_guru_extra"
    private lateinit var guru: Guru
    private var isUpdate = false
    private lateinit var database: GuruRoomDatabase
    private lateinit var dao: GuruDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_guru)

        database = GuruRoomDatabase.getDatabase(applicationContext)
        dao = database.getGuruDao()

        if (intent.getParcelableExtra<Guru>(EDIT_GURU_EXTRA) != null){
            button_delete.visibility = View.VISIBLE
            isUpdate = true
            guru = intent.getParcelableExtra(EDIT_GURU_EXTRA)
            edit_text_nama.setText(guru.nama)
            edit_text_nip.setText(guru.nip)
            edit_text_ngajar.setText(guru.ngajar)

            edit_text_nama.setSelection(guru.nama.length)

        }

        button_save.setOnClickListener {
            val nama = edit_text_nama.text.toString()
            val nip = edit_text_nip.text.toString()
            val ngajar = edit_text_ngajar.text.toString()

            if (nama.isEmpty() && nip.isEmpty() && ngajar.isEmpty()){
                Toast.makeText(applicationContext, "guru cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                if (isUpdate){
                    saveGuru(Guru(id = guru.id, nama = nama, nip = nip, ngajar = ngajar))
                }
                else{
                    saveGuru(Guru(nama = nama, nip = nip, ngajar = ngajar))
                }
            }

            finish()
        }

        button_delete.setOnClickListener {
            deleteGuru(guru)
            finish()
        }

    }

    private fun saveGuru(guru: Guru){

        if (dao.getById(guru.id).isEmpty()){

            dao.insert(guru)
        }
        else{

            dao.update(guru)
        }

        Toast.makeText(applicationContext, "Guru saved", Toast.LENGTH_SHORT).show()

    }

    private fun deleteGuru(guru: Guru){
        dao.delete(guru)
        Toast.makeText(applicationContext, "Guru removed", Toast.LENGTH_SHORT).show()
    }
}