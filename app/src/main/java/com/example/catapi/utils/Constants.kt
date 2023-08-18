package com.example.catapi.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val THE_CAT_API_URL = "https://api.thecatapi.com"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "live_mZ9lTQb3I7eD0COQ7kTefHJN8UmD203rDY8zucv51VqaIGXysVGrSq4Z8igdH1lP "
        const val PRIVATE_KEY = "Enter Your Own Key"
        const val limit = "20"
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}