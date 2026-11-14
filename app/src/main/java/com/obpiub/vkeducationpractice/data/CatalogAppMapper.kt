package com.obpiub.vkeducationpractice.data

import com.obpiub.vkeducationpractice.domain.CatalogApp
import javax.inject.Inject

class CatalogAppMapper @Inject constructor(){
    fun toDomain(dto: CatalogAppDto): CatalogApp {
        return CatalogApp(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            category = dto.category,
            iconUrl = dto.iconUrl,)
    }
}