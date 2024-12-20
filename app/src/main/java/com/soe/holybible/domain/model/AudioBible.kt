package com.soe.holybible.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class AudioBible(
    val dblId: String,
    val id: String,
    val name: String,
    val nameLocal: String
) : Parcelable