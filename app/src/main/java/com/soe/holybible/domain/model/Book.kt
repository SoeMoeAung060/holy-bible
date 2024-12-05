package com.soe.holybible.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Book(
    val abbreviation: String,
    val bibleId: String,
    val id: String,
    val name: String,
    val nameLong: String
) : Parcelable