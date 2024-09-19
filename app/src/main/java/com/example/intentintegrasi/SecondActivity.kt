package com.example.intentintegrasi

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentintegrasi.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        with(binding) {
            btnLogin.setOnClickListener {
                val inputEmail = editEmail2.text.toString().trim()
                val inputPassword = editPassword2.text.toString().trim()

                val savedEmail = sharedPreferences.getString("EMAIL", null)
                val savedPassword = sharedPreferences.getString("PASSWORD", null)

                if (inputEmail == savedEmail && inputPassword == savedPassword) {
                    Toast.makeText(this@SecondActivity, "Login berhasil!", Toast.LENGTH_SHORT).show()

                    val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)
                    startActivity(intentToThirdActivity)
                } else {
                    Toast.makeText(this@SecondActivity, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}