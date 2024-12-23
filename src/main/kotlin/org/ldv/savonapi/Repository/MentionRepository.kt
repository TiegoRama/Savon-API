package org.ldv.savonapi.Repository

import org.ldv.savonapi.Entity.Mention
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MentionRepository : JpaRepository<Mention, Long> {
}