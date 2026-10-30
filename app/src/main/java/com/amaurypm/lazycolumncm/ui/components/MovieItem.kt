package com.amaurypm.lazycolumncm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amaurypm.lazycolumncm.R
import com.amaurypm.lazycolumncm.model.Movie
import com.amaurypm.lazycolumncm.ui.theme.LazyColumnCMTheme
import com.amaurypm.lazycolumncm.ui.theme.Pink40
import com.amaurypm.lazycolumncm.ui.theme.Pink80
import com.amaurypm.lazycolumncm.ui.theme.TitleColor

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 130.dp)
            .padding(all = 10.dp)
            .clickable(
                onClick = {
                    onMovieClick(movie)
                }
            )
    ){
        Column(
            modifier = modifier.weight(0.3f)
        ){
            /*Box(
                modifier = modifier.fillMaxWidth()
                    .heightIn(120.dp)
                    .background(Pink40)
            )*/
            Image(
                painter = painterResource(R.drawable.movieicon),
                contentDescription = "Ícono de la película",
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(120.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = modifier.weight(0.7f)
        ){
            /*Box(
                modifier = modifier.fillMaxWidth()
                    .heightIn(120.dp)
                    .background(Pink80)
            )*/
            Text(
                text = movie.title,
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(40.dp)
                    .wrapContentHeight(
                        Alignment.CenterVertically
                    )
                    .padding(start = 10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TitleColor

            )
            Text(
                text = movie.type,
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(40.dp)
                    .wrapContentHeight(
                        Alignment.CenterVertically
                    )
                    .padding(start = 30.dp),
                fontSize = 18.sp
            )
            Text(
                text = movie.date,
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(40.dp)
                    .wrapContentHeight(
                        Alignment.CenterVertically
                    )
                    .wrapContentWidth(
                        Alignment.End
                    )
                    .padding(end = 30.dp),
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
    HorizontalDivider(
        thickness = 2.dp,
        modifier = modifier.fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview(){
    LazyColumnCMTheme {
        MovieItem(
            movie = Movie(
                id = 0,
                title = "Mario Galaxy",
                type = "Animación",
                date = "2026",
                image = R.drawable.movieicon
            )
        ){}
    }
}