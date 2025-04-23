package com.elBuenSabor.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.elBuenSabor.backend.Entidades.ArticuloManufacturado;

@SpringBootApplication
public class ElBuenSaborApplication {

	public static void main(String[] args) {

		SpringApplication.run(ElBuenSaborApplication.class, args);


		// Alta (Create)
		ArticuloManufacturado pizza = new ArticuloManufacturado();
		pizza.setDenominacion("Pizza Napolitana");
		pizza.setPrecioVenta(2500.0);
		pizza.setTiempoEstimadoMinutos(20);
		pizza.setPreparacion("Estirar la masa, agregar salsa, queso y hornear.");


	}

}
