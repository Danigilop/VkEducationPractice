package com.obpiub.vkeducationpractice.data

import com.obpiub.vkeducationpractice.domain.Category

data class AppDetailsDto(
    val name: String,
    val developer: String,
    val category: String,
    val id: String,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,

)
