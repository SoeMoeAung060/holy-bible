package com.soe.holybible.data.remote.dto

import com.soe.holybible.domain.model.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDTO(
    @SerialName("data")
    val data: List<Book>
)