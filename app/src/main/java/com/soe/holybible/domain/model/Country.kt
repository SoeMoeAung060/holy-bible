package com.soe.holybible.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: String,
    val name: String,
    val nameLocal: String
)