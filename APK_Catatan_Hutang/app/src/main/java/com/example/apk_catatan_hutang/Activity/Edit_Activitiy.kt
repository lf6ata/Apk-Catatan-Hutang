package com.example.apk_catatan_hutang.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.apk_catatan_hutang.Model.SubmitModel
import com.example.apk_catatan_hutang.Model.RespondRead
import com.example.apk_catatan_hutang.Network_DBMS_Mariadb.RetrofitClient
import com.example.apk_catatan_hutang.R
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Edit_Activitiy : AppCompatActivity() {
    private val api by lazy { RetrofitClient().endpoint }
    private lateinit var ed_Jumlah: EditText
    private lateinit var ed_NmHutang: EditText
    private lateinit var edCatatan: EditText
    //val total1? : ?

    private lateinit var btnEdit: MaterialButton
    private val note by lazy {intent.getSerializableExtra("note") as RespondRead.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar!!.title = "Edit"
        setupView()
        setupListener()
    }
    private fun setupView(){
        ed_Jumlah = findViewById(R.id.edt_JmlhHutang)
        ed_NmHutang = findViewById(R.id.edt_NmHutang)
        edCatatan = findViewById(R.id.et_Catatan)
        btnEdit = findViewById(R.id.btn_SaveEdit)

        ed_Jumlah.setText(note.jumlah)
        ed_NmHutang.setText(note.nm_penghutang)
        edCatatan.setText(note.catatan)


    }
    private fun setupListener(){

        btnEdit.setOnClickListener{
            api.edit(note.id!!, ed_NmHutang.text.toString(), edCatatan.text.toString(),ed_Jumlah.text.toString() )
                .enqueue(object : Callback<SubmitModel>{
                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {

                    }

                })
        }
    }
}

