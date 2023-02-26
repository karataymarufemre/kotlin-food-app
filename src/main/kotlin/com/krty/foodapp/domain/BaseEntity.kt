package com.krty.foodapp.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open var id: Int = 0
}