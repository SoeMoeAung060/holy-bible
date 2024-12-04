package com.soe.holybible.data.remote.dto

import com.soe.holybible.domain.model.Bible
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BibleDTO(
    @SerialName("data")
    val data: List<Bible>
)