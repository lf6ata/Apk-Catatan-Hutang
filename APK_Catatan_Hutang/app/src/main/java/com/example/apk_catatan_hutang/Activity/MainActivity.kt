package com.example.apk_catatan_hutang.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_catatan_hutang.Model.SubmitModel
import com.example.apk_catatan_hutang.Model.RespondRead
import com.example.apk_catatan_hutang.Network_DBMS_Mariadb.RetrofitClient
import com.example.apk_catatan_hutang.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { RetrofitClient().endpoint}
    private lateinit var viewAdater: Main_Adapter
    private lateinit var listNote: RecyclerView
    private lateinit var btnTambah : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupList()
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupView() {
        listNote = findViewById(R.id.recyclerView)
        btnTambah = findViewById(R.id.btn_tambah)
    }

    private fun setupListener() {
        btnTambah.setOnClickListener {
            startActivity(Intent(this,CreateActivity::class.java))
        }
    }

    private fun setupList() {
        viewAdater = Main_Adapter(arrayListOf(), object : Main_Adapter.OnAdapterListener{
            override fun onUpdate(hasil: RespondRead.Data) {
                startActivity(
                    Intent(this@MainActivity,Edit_Activitiy::class.java)
                        .putExtra("note",hasil)
                )
            }

            override fun onDelete(hasil: RespondRead.Data) {
                api.hapus(hasil.id!!)
                    .enqueue(object : Callback<SubmitModel>{
                        override fun onResponse(
                            call: Call<SubmitModel>,
                            response: Response<SubmitModel>
                        ) {
                            if (response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext,submit!!.pesan, Toast.LENGTH_SHORT).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        }

                    })
            }

        })
        listNote.adapter = viewAdater
    }

    private fun getData() {
        api.data().enqueue(object : Callback<RespondRead> {
            override fun onResponse(call: Call<RespondRead>, response: Response<RespondRead>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.hasil

                    //menampilkan data mysql di layout
                    viewAdater.setData(listData)

                }
            }

            override fun onFailure(call: Call<RespondRead>, t: Throwable) {
                Log.e("MainActivity-Log", t.toString())
            }

        })
    }
}