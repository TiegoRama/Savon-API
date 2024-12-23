package org.ldv.savonapi.Service

import org.ldv.savonapi.DAO.*
import org.springframework.stereotype.Service

@Service
class SimulateurService(
    val caracteristiqueDAO: CaracteristiqueDAO,
    val recetteDAO: RecetteDAO,
    val ingredientDAO: IngredientDAO,
    val ligneIngredientDAO: LigneIngredientDAO,
    val mentionDAO: MentionDAO,
    val resultatDAO: ResultatDAO


    ) {
}