package com.soe.holybible.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Country(
    val id: String,
    val name: String,
    val nameLocal: String
) : Parcelable