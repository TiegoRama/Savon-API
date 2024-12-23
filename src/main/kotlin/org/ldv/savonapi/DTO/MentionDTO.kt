package org.ldv.savonapi.DTO

import org.ldv.savonapi.Entity.Mention


data class MentionDTO(

    val id: Long? = null,
    val msavon: String,
    val savonMini: Int,
    val savonMaxi: Int

){
    fun toEntity(): Mention{
        return Mention(
            id = this.id,
            msavon = this.msavon,
            savonMini = this.savonMini,
            savonMaxi = this.savonMaxi
        )
    }
}
