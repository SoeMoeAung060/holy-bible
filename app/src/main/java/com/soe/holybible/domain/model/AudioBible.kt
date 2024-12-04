package com.soe.holybible.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AudioBible(
    val dblId: String,
    val id: String,
    val name: String,
    val nameLocal: String
)