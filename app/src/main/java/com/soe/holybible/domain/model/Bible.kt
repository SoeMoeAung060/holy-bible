package com.soe.holybible.domain.model

import kotlinx.serialization.Serializable

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
)
