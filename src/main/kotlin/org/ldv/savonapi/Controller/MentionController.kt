package org.ldv.savonapi.Controller

import org.ldv.savonapi.DAO.MentionDAO
import org.ldv.savonapi.Entity.Mention
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path = ["/rest/api/v1/mention"])
class MentionController (private val MentionDAO: MentionDAO) {

    @GetMapping
    fun getAllMention(): List<Mention> {
        return MentionDAO.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getMentionById(@PathVariable id: Long): ResponseEntity<Mention> {
        val mention = MentionDAO.findById(id)
        return if (mention.isPresent){
            ResponseEntity.ok(mention.get())

        }
        else{
            ResponseEntity.notFound().build()
        }

    }
    @PostMapping
    fun createMention(@RequestBody mention: Mention): ResponseEntity<Mention> {
        val savedMention = MentionDAO.save(mention)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMention)
    }
    @PutMapping(value = ["/{id}"])
    fun updateMention(@PathVariable id: Long, @RequestBody mention: Mention): ResponseEntity<Mention> {
        return if (MentionDAO.existsById(id)){
            mention.id = id
            val updatedMention = MentionDAO.save(mention)
            ResponseEntity.ok(updatedMention)
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteMention(@PathVariable id: Long): ResponseEntity<Unit> {
        return if (MentionDAO.existsById(id)){
            MentionDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
}