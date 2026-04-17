package com.amaurypm.lazycolumncm.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.amaurypm.lazycolumncm.model.Movie
import com.amaurypm.lazycolumncm.ui.components.MovieItem


@Composable
fun MainScreen(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
){
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(movies){ movie ->
            MovieItem(movie){ selectedMovie ->
                //Manejo de los clics
                Log.d("APPLOGS",
                    "Clic en elemento con título ${selectedMovie.title} y id: ${selectedMovie.id}")
                Toast.makeText(
                    context,
                    "Clic en elemento con título ${selectedMovie.title} y id: ${selectedMovie.id}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}