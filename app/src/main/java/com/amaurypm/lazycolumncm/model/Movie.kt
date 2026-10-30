package com.amaurypm.lazycolumncm.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie(
    val id: Long,
    val title: String,
    val type: String,
    val date: String,
    @param:DrawableRes val image: Int
)
