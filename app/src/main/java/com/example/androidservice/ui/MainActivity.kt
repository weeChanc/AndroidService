package com.example.androidservice.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.example.androidservice.R
import com.example.androidservice.uitls.getHostIp
import com.weechan.httpserver.httpserver.HttpServerBuilder
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MediaRepository.init()
        val service = HttpServerBuilder
                .with(this)
                .port(8080)
                .getHttpServer()

        val port = service.start()
        textView.text = getHostIp()+":${port}  tempFile${Environment.getExternalStorageDirectory().path}"



    }




}
