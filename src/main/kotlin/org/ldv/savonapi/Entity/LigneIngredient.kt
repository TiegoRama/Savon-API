package org.ldv.savonapi.Entity

import jakarta.persistence.*

@Entity
class LigneIngredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ligneIngredientId: Long? = null,
    val ingredient: String,
    val quantite: Float,
    val pourcentage: Float,
    @ManyToOne
    val recette: Recette
)