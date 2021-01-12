package br.com.lucasmezuraro.repositories

import br.com.lucasmezuraro.entities.Medicine
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface MedicineRepository: CrudRepository<Medicine, Long> {
}