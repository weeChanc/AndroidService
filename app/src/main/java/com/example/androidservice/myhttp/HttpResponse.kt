package com.example.androidservice.myhttp

import com.example.androidservice.myhttp.`interface`.Response
import java.io.OutputStream
import java.io.RandomAccessFile

/**
 * Created by 铖哥 on 2018/3/17.
 */
class HttpResponse : Response {

    val headers : MutableMap<String,String> by lazy {  hashMapOf<String,String>() }
    var write : ((OutputStream)->Unit)?= null
    lateinit var httpState : String


    fun write( answer : (OutputStream)->Unit){
        this.write = answer
    }

    fun addHeaders( add : HttpResponse.() -> Unit){
        this.add()
    }

    operator fun String.minus (value : String){
        headers.put(this,value)
    }



}