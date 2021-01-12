package br.com.lucasmezuraro.dtos

import br.com.lucasmezuraro.entities.Medicine
import java.math.BigDecimal

data class MedicineDTO(val name: String, val price: BigDecimal) {

    fun toModel(): Medicine {
        return Medicine(this.name, this.price)
    }
}