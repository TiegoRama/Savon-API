package org.ldv.savonapi.DAO

import org.ldv.savonapi.Entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientDAO : JpaRepository<Ingredient, Long> {

}
