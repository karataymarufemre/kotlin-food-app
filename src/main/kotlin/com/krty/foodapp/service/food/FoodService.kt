package com.krty.foodapp.service.food

import com.krty.foodapp.api.response.SearchResponse
import com.krty.foodapp.dto.FoodDTO

interface FoodService {
    fun search(searchText: String, cursor: String?, size: Int) : SearchResponse
}