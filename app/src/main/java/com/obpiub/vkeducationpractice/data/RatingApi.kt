package com.obpiub.vkeducationpractice.data

import kotlinx.coroutines.delay
import javax.inject.Inject

class RatingApi @Inject constructor() {
    suspend fun getRating(id: String): Float {
        delay(1500L)
        return (30..50).random() / 10f
    }
}
