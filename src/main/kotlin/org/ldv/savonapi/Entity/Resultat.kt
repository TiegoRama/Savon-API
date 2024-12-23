package org.ldv.savonapi.Entity
import jakarta.persistence.*
@Entity
class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    var resultatid: Long? = null

    @Column(name = "score", nullable = false)
    var score: Float = 0.0F

    @JoinColumn(name = "recette", nullable = false)
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    var recette: Recette? = null

    @JoinColumn(name = "mention", nullable = false)
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    var mention: Mention? = null

    @JoinColumn(name = "caracteristique", nullable = false)
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    var caracteristique: Caracteristique? = null

    constructor() : this(
        resultatid = null,
        score = 0.0F,
        recette = null,
        mention = null,
        caracteristique = null
    )
    constructor(resultatid: Long?, score: Float, recette: Recette?, mention: Mention?, caracteristique: Caracteristique?){

        this.resultatid = resultatid
        this.score = score
        this.recette = recette
        this.mention= mention
        this.caracteristique = caracteristique


    }
}