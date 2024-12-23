package org.ldv.savonapi.DAO

import org.ldv.savonapi.Entity.Resultat
import org.springframework.data.jpa.repository.JpaRepository

interface ResultatDAO : JpaRepository<Resultat, Long> {
}