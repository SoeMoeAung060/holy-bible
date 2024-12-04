package com.soe.holybible.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val id: String,
    val name: String,
    val nameLocal: String,
    val script: String,
    val scriptDirection: String
)