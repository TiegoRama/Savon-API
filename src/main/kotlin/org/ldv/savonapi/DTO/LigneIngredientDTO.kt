package org.ldv.savonapi.DTO

import org.ldv.savonapi.Entity.LigneIngredient

data class LigneIngredientDTO(
    var ingredientId : Long,
    var recetteId : Long,
    var quantite: Float,
    var pourcentage: Float

)
