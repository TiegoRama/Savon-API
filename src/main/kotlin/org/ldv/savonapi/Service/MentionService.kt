package org.ldv.savonapi.Service

import org.ldv.savonapi.DTO.MentionDTO
import org.ldv.savonapi.Repository.MentionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class MentionService @Autowired constructor(val mentionRepository : MentionRepository) {

    fun getAllMentions(): List<MentionDTO> {
        return mentionRepository.findAll().map { it.toDTO() }
    }

    fun getMentionById(id: Long): MentionDTO? {
        return mentionRepository.findById(id).map { it.toDTO() }.orElse(null)
    }

    fun saveMention(mentionDTO: MentionDTO): MentionDTO {
        val mention = mentionDTO.toEntity()
        return mentionRepository.save(mention).toDTO()
    }

    fun deleteMention(id: Long) {
        mentionRepository.deleteById(id)
    }
}