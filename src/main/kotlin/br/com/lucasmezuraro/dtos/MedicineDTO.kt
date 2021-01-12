package br.com.lucasmezuraro.dtos

import br.com.lucasmezuraro.entities.Medicine
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MedicineDTO(@NotBlank
                       val name: String,@NotNull val price: BigDecimal) {

    fun toModel(): Medicine {
        return Medicine(this.name, this.price)
    }
}