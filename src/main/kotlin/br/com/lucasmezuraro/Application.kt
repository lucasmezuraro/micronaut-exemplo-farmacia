package br.com.lucasmezuraro

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.lucasmezuraro")
		.start()
}

