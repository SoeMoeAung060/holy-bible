package com.soe.holybible.data.mapper

import com.soe.holybible.data.remote.dto.BibleDTO
import com.soe.holybible.data.remote.dto.BurmeseBibleDTO
import com.soe.holybible.domain.model.Bible

fun BibleDTO.toBible(): List<Bible> {
    return data.map {
        Bible(
            abbreviation = it.abbreviation,
            abbreviationLocal = it.abbreviationLocal,
            audioBibles = it.audioBibles,
            countries = it.countries,
            dblId = it.dblId,
            description = it.description,
            descriptionLocal = it.descriptionLocal,
            id = it.id,
            language = it.language,
            name = it.name,
            nameLocal = it.nameLocal,
            relatedDbl = it.relatedDbl,
            type = it.type,
            updatedAt = it.updatedAt
        )
    }
}

