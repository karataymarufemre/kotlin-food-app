package com.krty.foodapp.domain

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.Hibernate

@Entity
class NutrientAmount(@ManyToOne @JoinColumn(name = "food_id") var food: Food, var value: Double, var code: Int, var symbol: String, var unit: String, var name: String) : BaseEntity() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as NutrientAmount

        return id == other.id
    }

    override fun hashCode(): Int = 1756406091
    override fun toString(): String {
        return super.toString() + "foodId: " + food.id + "value: " + value + "code: " + code + "symbol: " + symbol + "unit: " + unit + "name: " + name
    }
}