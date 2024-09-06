package com.rendrapcx.terka

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rendrapcx.terka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            btnNew.setOnClickListener {
                Const.terkaSet = Const.TerkaSet.PLAY
                val intent = Intent(this@MainActivity, TerkaActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnEditor.setOnClickListener {
                Const.terkaSet = Const.TerkaSet.EDITOR
                val intent = Intent(this@MainActivity, TerkaActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}