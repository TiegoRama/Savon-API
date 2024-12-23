package org.ldv.savonapi.DAO
import org.ldv.savonapi.Entity.Caracteristique
import org.ldv.savonapi.Entity.Mention
import org.ldv.savonapi.Entity.Resultat
import org.springframework.data.jpa.repository.*
import org.springframework.data.repository.query.Param


interface MentionDAO : JpaRepository<Mention, Long>{

    @Query ("SELECT m FROM Mention m WHERE m.caracteristique = :carateristique AND :score BETWEEN m.savonMini AND m.savonMaxi")
    fun findMentionByScoreAndCaracteristique(
        @Param("score") score: Float,
        @Param("caracteristique") caracterique: Caracteristique,

    ):Mention?
}