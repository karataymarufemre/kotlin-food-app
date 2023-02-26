package com.krty.foodapp.repository

import com.krty.foodapp.domain.Food
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : PagingAndSortingRepository<Food, Int> {

    fun findByNameContainingIgnoreCase(name : String, pageable: Pageable) : Page<Food>
}