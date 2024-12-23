package org.ldv.savonapi.DAO

import org.ldv.savonapi.Entity.Caracteristique
import org.springframework.data.jpa.repository.JpaRepository

interface CaracteristiqueDAO : JpaRepository<Caracteristique, Long> {
}