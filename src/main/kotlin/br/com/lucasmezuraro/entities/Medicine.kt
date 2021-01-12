package br.com.lucasmezuraro.entities

import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Medicine()  {
    @Id
    @GeneratedValue
    var id: Long = 0

    @NotBlank
    @Column(nullable = false)
    lateinit var name: String
    @NotNull
    @Column(nullable = false)
    lateinit var price: BigDecimal

    constructor(name: String, price: BigDecimal) : this() {
        this.name = name
        this.price = price
    }
}