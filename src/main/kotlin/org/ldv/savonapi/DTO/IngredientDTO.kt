package org.ldv.savonapi.DTO

import org.ldv.savonapi.Entity.Ingredient

// IngredientDTO.kt

// IngredientDTO.kt

data class IngredientDTO(
    val id: Long?,
    val corpsGras: String,
    val sapo: Int,
    val iode: Int,
    val ins: Int,
    val douceur: Double,
    val lavant: Double,
    val foiMousse: Double,
    val tenueMousse: Double,
    val durete: Double,
    val solubilite: Double,
    val sechage: Double
) {
    fun toEntity(): Ingredient {
        return Ingredient(
            id = this.id,
            corpsGras = this.corpsGras,
            sapo = this.sapo,
            iode = this.iode,
            ins = this.ins,
            douceur = this.douceur,
            lavant = this.lavant,
            foiMousse = this.foiMousse,
            tenueMousse = this.tenueMousse,
            durete = this.durete,
            solubilite = this.solubilite,
            sechage = this.sechage
        )
    }
}
