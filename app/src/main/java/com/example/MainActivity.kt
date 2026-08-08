package com.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.supabase.supabaseClient
import com.example.ui.screens.MainScreen
import com.example.ui.theme.MyApplicationTheme
import io.github.jan.supabase.auth.handleDeeplinks

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        supabaseClient.handleDeeplinks(intent)
        
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}
