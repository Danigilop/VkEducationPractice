package com.obpiub.vkeducationpractice.data

import com.obpiub.vkeducationpractice.domain.App
import javax.inject.Inject

class AppMapper @Inject constructor() {
    fun toDomain(dto: AppDto): App {
        return App(
            name = dto.name,
            developer = dto.developer,
            category = dto.category,
            ageRating = dto.ageRating,
            size = dto.size,
            iconUrl = dto.iconUrl,
            screenshotUrlList = dto.screenshotUrlList,
            description = dto.description,
            id = dto.id


        )
    }
}