package org.ldv.savonapi.DTO

import org.ldv.savonapi.Entity.Caracteristique

data class CaracteristiqueDTO(
    val id : Long?,
    val nom : String,
) {
    fun toEntity(): Caracteristique {
        return Caracteristique(
            id = this.id,
            nom = this.nom
        )
    }

}