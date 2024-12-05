package com.soe.holybible.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Bible(
    val abbreviation: String?,
    val abbreviationLocal: String?,
    val audioBibles: List<AudioBible>,
    val countries: List<Country>,
    val dblId: String?,
    val description: String?,
    val descriptionLocal: String?,
    val id: String?,
    val language: Language,
    val name: String?,
    val nameLocal: String?,
    val relatedDbl: String?,
    val type: String?,
    val updatedAt: String?
) : Parcelable
