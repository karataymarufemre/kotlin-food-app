package com.krty.foodapp.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import org.hibernate.Hibernate

@Entity
class FoodGroup(var name: String) : BaseEntity() {


    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "foodGroup")
    var foods = mutableListOf<Food>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as FoodGroup

        return id == other.id
    }

    override fun hashCode(): Int = 1756406091
    override fun toString(): String {
        return super.toString() + "name: " + name
    }
}