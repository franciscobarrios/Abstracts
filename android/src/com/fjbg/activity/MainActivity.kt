package com.fjbg.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fjbg.abstract.NodeConnectionApp
import com.fjbg.abstract.TilesApp
import com.fjbg.abstracts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNodeConnection.setOnClickListener(this)
        binding.btnTiles.setOnClickListener(this)
        binding.btnSettings.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnNodeConnection -> startActivity(Intent(this, NodeConnectionApp::class.java))
            binding.btnTiles -> startActivity(Intent(this, TilesApp::class.java))
        }
    }
}