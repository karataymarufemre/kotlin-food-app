package com.krty.foodapp.service.food.impl

import com.krty.foodapp.api.response.SearchResponse
import com.krty.foodapp.dto.FoodDTO
import com.krty.foodapp.repository.FoodRepository
import com.krty.foodapp.service.food.FoodService
import com.krty.foodapp.util.PageUtil
import org.springframework.stereotype.Service

@Service
class FoodServiceImpl(val foodRepository: FoodRepository) : FoodService{

    override fun search(searchText: String, cursor: String?, size: Int) : SearchResponse {
        return foodRepository.findByNameContainingIgnoreCase(
            searchText,
            cursor?.let {PageUtil.fromCursor(it)} ?: PageUtil.firstPage(size))
            .map { FoodDTO.ObjectMapper.fromEntity(it) }
            .let { SearchResponse(
                items = it.toList(),
                cursor = if(it.hasNext()) PageUtil.toCursor(it.nextPageable()) else null
            ) }
    }
}