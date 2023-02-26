package com.krty.foodapp.api.controller.food

import com.krty.foodapp.service.food.FoodService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FoodController(val foodService: FoodService) {

    @GetMapping("/search")
    fun search(@RequestParam searchText: String, @RequestParam cursor: String?, @RequestParam(defaultValue = "10") size: Int) =
        foodService.search(searchText, cursor, size)

}