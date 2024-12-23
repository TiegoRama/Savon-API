package org.ldv.savonapi.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.ldv.savonapi.Entity.Ingredient

@Repository
interface IngredientRepository : JpaRepository<Ingredient, Long> {
}
