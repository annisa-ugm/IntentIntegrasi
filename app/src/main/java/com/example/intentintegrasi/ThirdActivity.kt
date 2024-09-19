package com.example.intentintegrasi

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentintegrasi.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        val nameUser = sharedPreferences.getString("NAME", "Nama tidak ditemukan")
        val emailUser = sharedPreferences.getString("EMAIL", "Email tidak ditemukan")
        val nomorHPUser = sharedPreferences.getString("NOMOR_HP", "Nomor HP tidak ditemukan")
        val genderUser = sharedPreferences.getString("GENDER", "Jenis Kelamin tidak ditemukan")

        with(binding) {
            name.text = "Nama: $nameUser"
            email.text = "Email: $emailUser"
            nomorHP.text = "Nomor telepon: $nomorHPUser"
            gender.text = "Jenis kelamin: $genderUser"

            btnBack.setOnClickListener {
                val intentToMainActivity = Intent(this@ThirdActivity, MainActivity::class.java)
                startActivity(intentToMainActivity)
            }
        }

    }
}