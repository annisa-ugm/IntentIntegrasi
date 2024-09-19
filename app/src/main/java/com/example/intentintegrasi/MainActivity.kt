package com.example.intentintegrasi

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.intentintegrasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        with (binding) {
            btnRegister.setOnClickListener {
                val name = editName.text.toString().trim()
                val email = editEmail1.text.toString().trim()
                val nomorHP = editNomor.text.toString().trim()
                val gender = editGender.text.toString().trim()
                val password = editPassword1.text.toString().trim()

                if (name.isEmpty() || email.isEmpty() || nomorHP.isEmpty() || gender.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val editor = sharedPreferences.edit()
                editor.putString("NAME", name)
                editor.putString("EMAIL", email)
                editor.putString("NOMOR_HP", nomorHP)
                editor.putString("GENDER", gender)
                editor.putString("PASSWORD", password)
                editor.apply()

                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intentToSecondActivity)
                finish()
            }

        }
    }
}