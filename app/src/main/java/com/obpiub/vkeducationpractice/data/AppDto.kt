package com.obpiub.vkeducationpractice.data

import com.obpiub.vkeducationpractice.domain.Category

data class AppDto (
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
    val id: String
)