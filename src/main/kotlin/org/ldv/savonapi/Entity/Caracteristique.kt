package org.ldv.savonapi.Entity

import jakarta.persistence.*
import org.ldv.savonapi.DTO.CaracteristiqueDTO


@Entity
@Table(name = "caracteristique")
class Caracteristique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "nom", nullable = false)
    var nom: String = ""


    constructor() : this (

    id = null,
    nom =""
    )
    constructor(
    id: Long?,
    nom: String
    ) {
    this.id = id
    this.nom = nom
    }

    fun toDTO(): CaracteristiqueDTO {
        return CaracteristiqueDTO(
            id = this.id,
            nom = this.nom
        )
    }
}