package com.example.apk_catatan_hutang.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.apk_catatan_hutang.Model.SubmitModel
import com.example.apk_catatan_hutang.Network_DBMS_Mariadb.RetrofitClient
import com.example.apk_catatan_hutang.R
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {

    private val api by lazy { RetrofitClient().endpoint }

    private lateinit var inCatatan: EditText
    private lateinit var JumlahHutang: EditText
    private lateinit var NmPenghutang: EditText
    private lateinit var btnSave: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar!!.title = "Create"
        setupView()
        setupListener()
    }

    private fun setupView(){
        NmPenghutang = findViewById(R.id.put_NmPenghutang)
        inCatatan = findViewById(R.id.put_Catatan)
        JumlahHutang = findViewById(R.id.put_JumlahHutang)
        btnSave = findViewById(R.id.btn_SaveEdit)

    }

    private fun setupListener(){
        btnSave.setOnClickListener{
            if (inCatatan.text.toString().isNotEmpty()){

                api.tambah(NmPenghutang.text.toString(),inCatatan.text.toString(),JumlahHutang.text.toString())
                    .enqueue(object :Callback<SubmitModel>{
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

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) { }
                    })
            }
            else{
                Toast.makeText(applicationContext,"Inputan Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
            }
        }
    }
}