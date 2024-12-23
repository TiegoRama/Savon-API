package org.ldv.savonapi.Entity

import jakarta.persistence.*
import org.ldv.savonapi.Entity.Ingredient
@Entity
class Recette(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val titre: String,
    val description: String,
    val avecSoude: Boolean,
    val concentrationAlcalin: Float,
    var qteAlcalin: Float,
    var apportEnEau: Float,
    val surgraissage: Float,
    @OneToMany(mappedBy = "recette")
    val lignesIngredients: List<LigneIngredient> = mutableListOf(),
    @OneToMany(mappedBy = "recette")
    val resultats: List<Resultat> = mutableListOf()
) {

    fun calculQteAlcalin() {
        var qteAlcalinNormal = 0.0f

        for (ligneIngredient in lignesIngredients) {

            val ingredientEntity = findIngredientByName(ligneIngredient.ingredient)
            if (ingredientEntity != null) {
                qteAlcalinNormal += ligneIngredient.quantite * ingredientEntity.sapo
            }
        }

        qteAlcalinNormal = if (avecSoude) {
            qteAlcalinNormal / 40.0f
        } else {
            qteAlcalinNormal / 56.1f
        }


        var qteAlcalin = qteAlcalinNormal / (concentrationAlcalin / 100)

        qteAlcalin -= qteAlcalin * (surgraissage / 100)

        this.qteAlcalin = qteAlcalin
    }

    fun calculApportEau() {
        apportEnEau = qteAlcalin * ((100 - concentrationAlcalin) / 100)
    }


    fun calculPondere() {
        var totalDouceur = 0.0
        var totalLavant = 0.0
        var totalFoiMousse = 0.0
        var totalTenueMousse = 0.0
        var totalDurete = 0.0
        var totalSolubilite = 0.0
        var totalSechage = 0.0

        for (ligneIngredient in lignesIngredients) {
            val ingredientEntity = findIngredientByName(ligneIngredient.ingredient)
            if (ingredientEntity != null) {
                totalDouceur += ingredientEntity.douceur * (ligneIngredient.pourcentage / 100)
                totalLavant += ingredientEntity.lavant * (ligneIngredient.pourcentage / 100)
                totalFoiMousse += ingredientEntity.foiMousse * (ligneIngredient.pourcentage / 100)
                totalTenueMousse += ingredientEntity.tenueMousse * (ligneIngredient.pourcentage / 100)
                totalDurete += ingredientEntity.durete * (ligneIngredient.pourcentage / 100)
                totalSolubilite += ingredientEntity.solubilite * (ligneIngredient.pourcentage / 100)
                totalSechage += ingredientEntity.sechage * (ligneIngredient.pourcentage / 100)
            }
        }

        totalDouceur *= (1 + 0.01494 * surgraissage)
        totalLavant *= (1 - 0.01203 * surgraissage)
        totalFoiMousse *= (1 - 0.00303 * surgraissage)
        totalTenueMousse *= (1 - 0.01016 * surgraissage)
        totalDurete *= (1 - 0.00602 * surgraissage)
        totalSolubilite *= (1 + 0.00250 * surgraissage)
        totalSechage *= (1 - 0.00303 * surgraissage)

        if (resultats.size >= 7) {
            resultats[0].score = totalDouceur.toFloat()
            resultats[1].score = totalLavant.toFloat()
            resultats[2].score = totalFoiMousse.toFloat()
            resultats[3].score = totalTenueMousse.toFloat()
            resultats[4].score = totalDurete.toFloat()
            resultats[5].score = totalSolubilite.toFloat()
            resultats[6].score = totalSechage.toFloat()
        }
    }

    private fun findIngredientByName(name: String): Ingredient? {
        return null
    }
}
