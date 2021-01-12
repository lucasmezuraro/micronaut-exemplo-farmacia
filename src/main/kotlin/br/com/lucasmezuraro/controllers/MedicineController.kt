package br.com.lucasmezuraro.controllers

import br.com.lucasmezuraro.dtos.MedicineDTO
import br.com.lucasmezuraro.entities.Medicine
import br.com.lucasmezuraro.repositories.MedicineRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
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

}