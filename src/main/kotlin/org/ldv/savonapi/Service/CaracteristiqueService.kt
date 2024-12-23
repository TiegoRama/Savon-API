package org.ldv.savonapi.Service

import org.ldv.savonapi.DTO.CaracteristiqueDTO
import org.ldv.savonapi.Repository.CaracteristiqueRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CaracteristiqueService @Autowired constructor(private val caracteristiqueRepository: CaracteristiqueRepository){
    fun getAllCaracteristique(): List<CaracteristiqueDTO>{
        return caracteristiqueRepository.findAll().map { it.toDTO() }
    }
    fun getCaracteristiqueById(id: Long): CaracteristiqueDTO? {
        return caracteristiqueRepository.findById(id).map { it.toDTO() }.orElse(null)
    
}

    fun saveCaracteristique(caracteristiqueDTO: CaracteristiqueDTO): CaracteristiqueDTO {
        val caracteristique = caracteristiqueDTO.toEntity()
        return caracteristiqueRepository.save(caracteristique).toDTO()
    }

    fun deleteCaracteristique(id: Long) {
        caracteristiqueRepository.deleteById(id)
    }
}