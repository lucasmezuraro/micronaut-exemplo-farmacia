package br.com.lucasmezuraro.entities

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Medicine()  {
    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(nullable = false)
    lateinit var name: String
    @Column(nullable = false)
    lateinit var price: BigDecimal

    constructor(name: String, price: BigDecimal) : this() {
        this.name = name
        this.price = price
    }
}