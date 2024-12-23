package org.ldv.savonapi.Service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.ldv.savonapi.DTO.IngredientDTO
import org.ldv.savonapi.Repository.IngredientRepository
@Service
class IngredientService @Autowired constructor(private val ingredientRepository: IngredientRepository) {

    fun getAllIngredients(): List<IngredientDTO> {
        return ingredientRepository.findAll().map { it.toDTO() }
    }

    fun getIngredientById(id: Long): IngredientDTO? {
        return ingredientRepository.findById(id).map { it.toDTO() }.orElse(null)
    }

    fun saveIngredient(ingredientDTO: IngredientDTO): IngredientDTO {
        val ingredient = ingredientDTO.toEntity()
        return ingredientRepository.save(ingredient).toDTO()
    }

    fun deleteIngredient(id: Long) {
        ingredientRepository.deleteById(id)
    }

}

