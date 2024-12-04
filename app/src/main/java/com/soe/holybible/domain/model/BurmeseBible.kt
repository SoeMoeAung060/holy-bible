package com.soe.holybible.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class BurmeseBible(
    val abbr: String,
    val dir: String,
    val divisionAbbreviations: List<String>,
    val divisionNames: List<String>,
    val divisions: List<String>,
    val generator: String,
    val id: String,
    val lang: String,
    val langName: String,
    val langNameEnglish: String,
    val name: String,
    val nameEnglish: String,
    val sections: List<String>,
    val stylesheet: String,
    val type: String
)