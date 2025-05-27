package com.example.izhevskplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.izhevskplaces.data.IzhevskPlacesApp
import com.example.izhevskplaces.UI.IzhevskPlacesTheme
import com.example.izhevskplaces.UI.PlacesViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PlacesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IzhevskPlacesTheme {
                IzhevskPlacesApp(viewModel)
            }
        }
    }
}