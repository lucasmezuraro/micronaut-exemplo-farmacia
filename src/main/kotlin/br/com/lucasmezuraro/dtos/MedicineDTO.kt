package br.com.lucasmezuraro.dtos

import br.com.lucasmezuraro.entities.Medicine
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class MedicineDTO(@NotBlank(message = "nome é um campo obrigatório.")
                       val name: String,@NotNull(message = "preço é um campo obrigatório.") val price: BigDecimal) {

    fun toModel(): Medicine {
        return Medicine(this.name, this.price)
    }
}