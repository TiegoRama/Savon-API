package org.ldv.savonapi.Controller

import org.ldv.savonapi.DAO.IngredientDAO
import org.ldv.savonapi.Entity.Ingredient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/rest/api/v1/ingredients"])
class IngredientController(private val IngredientDAO: IngredientDAO) {


    @GetMapping
    fun getAllIngredients(): List<Ingredient> {
        return IngredientDAO.findAll()
    }
    @GetMapping(value = ["/{id}"])
    fun getIngredientById(@PathVariable id: Long): ResponseEntity<Ingredient> {
        val ingredient = IngredientDAO.findById(id)
        return if (ingredient.isPresent){
            ResponseEntity.ok(ingredient.get())

        }
        else{
            ResponseEntity.notFound().build()
        }

    }
    @PostMapping
    fun createIngredient(@RequestBody ingredient: Ingredient): ResponseEntity<Ingredient> {
        val savedIngredient = IngredientDAO.save(ingredient)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient)
    }
    @PutMapping(value = ["/{id}"])
    fun updateIngredient(@PathVariable id: Long, @RequestBody ingredient: Ingredient): ResponseEntity<Ingredient> {
        return if (IngredientDAO.existsById(id)){
            ingredient.id = id
            val updatedIngredient = IngredientDAO.save(ingredient)
            ResponseEntity.ok(updatedIngredient)
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteIngredient(@PathVariable id: Long): ResponseEntity<Unit> {
        return if (IngredientDAO.existsById(id)){
            IngredientDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
}