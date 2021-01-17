package br.com.lucasmezuraro.controllers

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.CachePut;
import io.micronaut.cache.annotation.Cacheable;

import br.com.lucasmezuraro.dtos.MedicineDTO
import br.com.lucasmezuraro.entities.Medicine
import br.com.lucasmezuraro.repositories.MedicineRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated

import java.util.*
import javax.inject.Inject
import javax.validation.Valid

import java.net.InetAddress;

@Validated
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
    fun create(@Valid @Body medicineDTO: MedicineDTO): HttpResponse<*> {
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

    @Get("/teste")
    fun teste(): HttpResponse<*> {
        val inetAddress: InetAddress = InetAddress.getLocalHost()
        println("IP Address:- $inetAddress.getHostAddress()")
        println("Host Name:- $inetAddress.getHostName()")

        return HttpResponse.ok("Hostname: $inetAddress")
    }

}