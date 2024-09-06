package com.rendrapcx.terka

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rendrapcx.terka.databinding.ActivityTerkaBinding

class TerkaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTerkaBinding
    var box = arrayListOf<TextView>()
    var key = arrayListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerkaBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initBox()
        initkey()

        if (Const.terkaSet == Const.TerkaSet.PLAY) {
            binding.terkaEmpat.visibility = View.GONE
            binding.terkaLima.visibility = View.VISIBLE
        } else {
            binding.terkaEmpat.visibility = View.VISIBLE
            binding.terkaLima.visibility = View.GONE
        }

        binding.includeViewTopPanel.imgBackButton.setOnClickListener(){
            val intent = Intent(this@TerkaActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun initkey() {
        val count = binding.includeViewKeyboard.viewKeyboard.childCount
        for (i in 0 until count) {
            val child = binding.includeViewKeyboard.viewKeyboard.getChildAt(i)
            if (child is TextView) {
                key.add(child)
                key[i].text = ""
            }
        }
        key[7].text = "🔙"
        key[15].text = "🔀"
    }

    private fun initBox() {
        val count = binding.includeViewBoxSoal.viewBoxSoal.childCount
        for (i in 0 until count) {
            val child = binding.includeViewBoxSoal.viewBoxSoal.getChildAt(i)
            if (child is TextView) {
                box.add(child)
                box[i].text = ""
            }
        }
    }
}