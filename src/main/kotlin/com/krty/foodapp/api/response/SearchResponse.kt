package com.krty.foodapp.api.response

import com.krty.foodapp.dto.FoodDTO

data class SearchResponse(
    val items: Iterable<FoodDTO>,
    val cursor: String?
)
