package com.krty.foodapp.domain

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
class Food(var name: String, @ManyToOne @JoinColumn(name = "food_group_id") var foodGroup: FoodGroup ) : BaseEntity(){

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "food")
    var nutrientAmount = mutableListOf<NutrientAmount>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Food

        return id == other.id
    }

    override fun hashCode(): Int = 1756406091
    override fun toString(): String {
        return super.toString() + "name: " + name + "foodGroup: " + foodGroup + "nutrientAmount: " +  nutrientAmount
    }
}