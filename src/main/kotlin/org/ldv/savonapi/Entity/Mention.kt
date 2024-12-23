package org.ldv.savonapi.Entity
import jakarta.persistence.*
import org.ldv.savonapi.DTO.MentionDTO

@Entity
@Table(name = "mentions")
class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "msavon", nullable = false)
    var msavon: String = ""

    @Column(name = "savonmini", nullable = false)
    var savonMini: Int = 0

    @Column(name = "savonmaxi", nullable = false)
    var savonMaxi: Int = 0

    @ManyToOne
    @JoinColumn(name = "caracteristique_id")
    var caracteristique: Caracteristique? = null

    constructor() : this(
        id = null,
        msavon= "",
        savonMini = 0,
        savonMaxi = 0,
        caracteristique = null
    )
    constructor(
        id: Long? = null,
        msavon:String = "",
        savonMini: Int = 0,
        savonMaxi: Int = 0,
        caracteristique: Caracteristique? = null
    ) {

        this.id = id
        this.msavon = msavon
        this.savonMini = savonMini
        this.savonMaxi = savonMaxi
        this.caracteristique = caracteristique
    }
    fun toDTO(): MentionDTO {
        return MentionDTO(
        id = this.id,
        msavon = this.msavon,
        savonMini = this.savonMini,
        savonMaxi = this.savonMaxi
        )
    }
}