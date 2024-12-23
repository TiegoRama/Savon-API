package org.ldv.savonapi.Controller

import org.ldv.savonapi.DAO.RecetteDAO
import org.ldv.savonapi.Entity.Mention
import org.ldv.savonapi.Entity.Recette
import org.ldv.savonapi.Service.SimulateurService
import org.springframework.http.*

import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/api-savon/v1/recette")
class RecetteController(
    val simulateurService: SimulateurService,
    val recetteController: RecetteDAO
) {

    @GetMapping("/all")
    fun index(): List<Recette> {
        return recetteController.findAll()
    }
    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<Recette> {
        return recetteController.findById(id).map { recette -> ResponseEntity.ok(recette) }.orElse(ResponseEntity.notFound().build())
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (recetteController.existsById(id)) {
            recetteController.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
