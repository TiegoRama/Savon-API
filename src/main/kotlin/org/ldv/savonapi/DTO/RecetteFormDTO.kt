package org.ldv.savonapi.DTO

import org.ldv.savonapi.Entity.LigneIngredient

data class RecetteFormDTO(
    var id : Long? = null,
    var titre: String,
    var description : String,
    var surgraissage : Float,
    var avecSoude: Boolean,
    var concentrationAlcalin: Float,
    var ligneIn : MutableList<LigneIngredient> = mutableListOf()

)
