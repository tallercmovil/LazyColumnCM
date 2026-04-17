package com.amaurypm.lazycolumncm.model

import androidx.annotation.DrawableRes

data class Movie(
    val id: Long,
    val title: String,
    val type: String,
    val date: String,
    @field:DrawableRes val image: Int
)
