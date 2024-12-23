package org.ldv.savonapi.Entity

import jakarta.persistence.*
import org.ldv.savonapi.DTO.IngredientDTO

// Ingredient.kt

import jakarta.persistence.*
// Ingredient.kt

import jakarta.persistence.*

import jakarta.persistence.*

@Entity
@Table(name = "ingredients")
class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "corps_gras", nullable = false)
    lateinit var corpsGras: String

    @Column(name = "sapo", nullable = false)
    var sapo: Int = 0

    @Column(name = "iode", nullable = false)
    var iode: Int = 0

    @Column(name = "INS", nullable = false)
    var ins: Int = 0

    @Column(name = "douceur", nullable = false)
    var douceur: Double = 0.0

    @Column(name = "lavant", nullable = false)
    var lavant: Double = 0.0

    @Column(name = "foi_mousse", nullable = false)
    var foiMousse: Double = 0.0

    @Column(name = "tenue_mousse", nullable = false)
    var tenueMousse: Double = 0.0

    @Column(name = "durete", nullable = false)
    var durete: Double = 0.0

    @Column(name = "solubilite", nullable = false)
    var solubilite: Double = 0.0

    @Column(name = "sechage", nullable = false)
    var sechage: Double = 0.0

    constructor() : this(
        id = null,
        corpsGras = "",
        sapo = 0,
        iode = 0,
        ins = 0,
        douceur = 0.0,
        lavant = 0.0,
        foiMousse = 0.0,
        tenueMousse = 0.0,
        durete = 0.0,
        solubilite = 0.0,
        sechage = 0.0
    )

    constructor(
        id: Long?,
        corpsGras: String,
        sapo: Int,
        iode: Int,
        ins: Int,
        douceur: Double,
        lavant: Double,
        foiMousse: Double,
        tenueMousse: Double,
        durete: Double,
        solubilite: Double,
        sechage: Double
    ) {
        this.id = id
        this.corpsGras = corpsGras
        this.sapo = sapo
        this.iode = iode
        this.ins = ins
        this.douceur = douceur
        this.lavant = lavant
        this.foiMousse = foiMousse
        this.tenueMousse = tenueMousse
        this.durete = durete
        this.solubilite = solubilite
        this.sechage = sechage
    }

    fun toDTO(): IngredientDTO {
        return IngredientDTO(
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
} }