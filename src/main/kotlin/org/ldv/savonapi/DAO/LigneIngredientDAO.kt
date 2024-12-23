package org.ldv.savonapi.DAO

import org.ldv.savonapi.Entity.LigneIngredient
import org.springframework.data.jpa.repository.JpaRepository

interface LigneIngredientDAO : JpaRepository<LigneIngredient, Long> {
}