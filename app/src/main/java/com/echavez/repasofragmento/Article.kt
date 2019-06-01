package com.echavez.repasofragmento

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val title: String,
    val subTitle: String,
    val content: String,
    val image: String
) : Parcelable