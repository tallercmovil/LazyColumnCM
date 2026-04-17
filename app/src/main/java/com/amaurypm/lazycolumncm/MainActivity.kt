package com.amaurypm.lazycolumncm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amaurypm.lazycolumncm.model.Movie
import com.amaurypm.lazycolumncm.ui.screens.MainScreen
import com.amaurypm.lazycolumncm.ui.theme.LazyColumnCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val movies = mutableListOf<Movie>()

        repeat(1000){ index ->
            movies.add(
                Movie(
                    id = index.toLong(),
                    title = "Título ${index+1}",
                    type = "Categoría ${index+1}",
                    date = "Fecha ${index+1}",
                    image = R.drawable.icon2
                )
            )
        }

        setContent {
            LazyColumnCMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        movies,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
