package com.krty.foodapp.dto

import com.krty.foodapp.domain.Food
import com.krty.foodapp.domain.FoodGroup
import com.krty.foodapp.domain.NutrientAmount

data class FoodDTO(val id: Int, val name: String, val foodGroup: FoodGroupDTO, val nutrientAmounts: List<NutrientAmountDTO>) {
    object ObjectMapper {
        fun fromEntity(food: Food) = FoodDTO(food.id, food.name, food.foodGroup.let { FoodGroupDTO.ObjectMapper.fromEntity(it) }, food.nutrientAmount.map { NutrientAmountDTO.ObjectMapper.fromEntity(it) })
    }
}

data class FoodGroupDTO(val id: Int, val name: String) {
    object ObjectMapper {
        fun fromEntity(foodGroup: FoodGroup) = FoodGroupDTO(foodGroup.id, foodGroup.name)
    }
}

data class NutrientAmountDTO(val id: Int, val code: Int, val symbol: String, val value: Double, val unit: String) {
    object ObjectMapper {
        fun fromEntity(nutrientAmount: NutrientAmount) = NutrientAmountDTO(nutrientAmount.id, nutrientAmount.code, nutrientAmount.symbol, nutrientAmount.value, nutrientAmount.unit)
    }
}
