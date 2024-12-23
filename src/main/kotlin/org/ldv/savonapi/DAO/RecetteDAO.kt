package org.ldv.savonapi.DAO

import org.ldv.savonapi.Entity.Recette
import org.springframework.data.jpa.repository.JpaRepository

interface RecetteDAO : JpaRepository<Recette, Long> {
}