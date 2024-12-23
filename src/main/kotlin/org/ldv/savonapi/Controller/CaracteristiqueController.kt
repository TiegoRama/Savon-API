package org.ldv.savonapi.Controller
import org.ldv.savonapi.DAO.CaracteristiqueDAO
import org.ldv.savonapi.Entity.Caracteristique
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/rest/api/v1/caracterisquetique"])
class CaracteristiqueController (private val CaracteristiqueDAO : CaracteristiqueDAO) {
    @GetMapping
    fun getAllCaracteristique(): List<Caracteristique> {
        return CaracteristiqueDAO.findAll()
    }
    @GetMapping(value = ["/{id}"])
    fun getCaracteristiqueById(@PathVariable id: Long): ResponseEntity<Caracteristique> {
        val caracteristique = CaracteristiqueDAO.findById(id)
        return if (caracteristique.isPresent){
            ResponseEntity.ok(caracteristique.get())

        }
        else{
            ResponseEntity.notFound().build()
        }

    }
    @PostMapping
    fun createCaracteristique(@RequestBody caracteristique: Caracteristique): ResponseEntity<Caracteristique> {
        val savedCaracteristique = CaracteristiqueDAO.save(caracteristique)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaracteristique)
    }
    @PutMapping(value = ["/{id}"])
    fun updateCaracteristique(@PathVariable id: Long, @RequestBody caracteristique: Caracteristique): ResponseEntity<Caracteristique> {
        return if (CaracteristiqueDAO.existsById(id)){
            caracteristique.id = id
            val updatedCaracteristique = CaracteristiqueDAO.save(caracteristique)
            ResponseEntity.ok(updatedCaracteristique)
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteCaracteristique(@PathVariable id: Long): ResponseEntity<Unit> {
        return if (CaracteristiqueDAO.existsById(id)){
            CaracteristiqueDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
}
    
