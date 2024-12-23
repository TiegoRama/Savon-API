package org.ldv.savonapi.Repository

import org.ldv.savonapi.Entity.Caracteristique
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface CaracteristiqueRepository : JpaRepository<Caracteristique, Long> {
}