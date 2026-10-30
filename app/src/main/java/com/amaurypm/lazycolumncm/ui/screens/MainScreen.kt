package com.amaurypm.lazycolumncm.ui.screens

import android.media.Image
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amaurypm.lazycolumncm.model.Movie
import com.amaurypm.lazycolumncm.ui.theme.LazyColumnCMTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.amaurypm.lazycolumncm.R
import com.amaurypm.lazycolumncm.ui.components.MovieItem


@Composable
fun MainScreen(
    movies: List<Movie>,
    modifier: Modifier = Modifier
){

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.moviesbanner),
            contentDescription = "Banner principal",
            modifier = Modifier.fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop

        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            items(movies){movie ->
                MovieItem(movie){ selectedMovie ->
                    //Manejamos el clic a cada elemento
                    Log.d("APPLOGS", "Clic en la película ${selectedMovie.title} con id ${selectedMovie.id}")
                    Toast.makeText(
                        context,
                        "Clic en la película ${selectedMovie.title} con id ${selectedMovie.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(){
    LazyColumnCMTheme {
        MainScreen(
            movies = mutableListOf()
        )
    }
}