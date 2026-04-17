package com.amaurypm.lazycolumncm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amaurypm.lazycolumncm.R
import com.amaurypm.lazycolumncm.model.Movie
import com.amaurypm.lazycolumncm.ui.theme.LazyColumnCMTheme
import com.amaurypm.lazycolumncm.ui.theme.MovieTitle
import com.amaurypm.lazycolumncm.ui.theme.Pink40
import com.amaurypm.lazycolumncm.ui.theme.Pink80

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit
){
    Row(
        modifier = modifier.fillMaxWidth()
            .heightIn(
                min = 130.dp
            )
            .padding(10.dp)
            .clickable(
                onClick = {
                    onMovieClick(movie)
                }
            )
    ){
        Column(
            modifier = modifier.weight(0.3f)
        ) {
            Image(
                painter = painterResource(movie.image),
                contentDescription = "Ícono de la película",
                modifier = Modifier.fillMaxWidth()
                    .heightIn(120.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = modifier.weight(0.7f)
        ) {
            Text(
                text = movie.title,
                modifier = Modifier.fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .padding(start = 10.dp)
                    .wrapContentHeight(
                        Alignment.CenterVertically
                    ),
                fontFamily = FontFamily(Font(R.font.paytone_one)),
                fontSize = 20.sp,
                color = MovieTitle,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = movie.type,
                modifier = Modifier.fillMaxWidth()
                    .heightIn(40.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(start = 30.dp),
                fontSize = 18.sp
            )
            Text(
                text = movie.date,
                modifier = Modifier.fillMaxWidth()
                    .heightIn(40.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.End)
                    .padding(end = 30.dp),
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
            )
        }
    }
    HorizontalDivider(
        thickness = 4.dp,
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    )
}

@Preview(
    showBackground = true
)
@Composable
fun MovieItemPreview(){
    LazyColumnCMTheme() {
        MovieItem(
            movie = Movie(
                id = 0,
                title = "Mario Galaxy",
                type = "Animación",
                date = "2026",
                image = R.drawable.icon2
            )
        ){

        }
    }
}