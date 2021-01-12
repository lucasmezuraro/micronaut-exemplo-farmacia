package br.com.lucasmezuraro.controllers

import br.com.lucasmezuraro.dtos.MedicineDTO
import br.com.lucasmezuraro.entities.Medicine
import br.com.lucasmezuraro.repositories.MedicineRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.exceptions.HttpClientResponseException

import java.util.*
import javax.inject.Inject

@Controller("/")
class MedicineController {

    @Inject
    lateinit var medicineRepository: MedicineRepository


    @Get("/")
    fun findAll(): HttpResponse<*> {
        val medicines: Iterable<Medicine> = medicineRepository.findAll()
       return HttpResponse.ok(medicines)
    }

    @Post("/")
    fun create(medicineDTO: MedicineDTO): HttpResponse<*> {
       val medicine: Medicine = medicineRepository.save(medicineDTO.toModel())
        return HttpResponse.ok(medicine)
    }

    @Get("/{id}", produces = arrayOf(MediaType.APPLICATION_JSON))
    fun findById(@PathVariable("id") id: Long): HttpResponse<*> {
        println("ID")
        val medicine: Optional<Medicine> = medicineRepository.findById(id)
        if (medicine.isPresent) {
            return HttpResponse.ok(medicine)
        }else {
           val error: Map<String, String> = mapOf("message" to "medicamento com o id: $id não encontrado.")
            return HttpResponse.notFound(error)
        }
    }

}