package com.elBuenSabor.backend;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elBuenSabor.backend.Entidades.ArticuloInsumo;
import com.elBuenSabor.backend.Entidades.ArticuloManufacturado;
import com.elBuenSabor.backend.Entidades.ArticuloManufacturadoDetalle;
import com.elBuenSabor.backend.Repositories.ArticuloInsumoRepository;
import com.elBuenSabor.backend.Repositories.ArticuloManufacturadoRepository;

@SpringBootApplication
public class ElBuenSaborApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElBuenSaborApplication.class, args);
    }

    @Bean
    CommandLineRunner init(
        ArticuloInsumoRepository insumoRepo,
        ArticuloManufacturadoRepository manufacturadoRepo
    ) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Crear ingrediente");
                System.out.println("2. Crear artículo manufacturado");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> {
                        ArticuloInsumo insumo = new ArticuloInsumo();
                        System.out.print("Nombre del ingrediente: ");
                        insumo.setDenominacion(scanner.nextLine());

                        System.out.print("Precio de venta: ");
                        insumo.setPrecioVenta(Double.parseDouble(scanner.nextLine()));

                        System.out.print("Precio de compra: ");
                        insumo.setPrecioCompra(Double.parseDouble(scanner.nextLine()));

                        System.out.print("Stock actual: ");
                        insumo.setStockActual(Integer.parseInt(scanner.nextLine()));

                        System.out.print("Stock máximo: ");
                        insumo.setStockMaximo(Integer.parseInt(scanner.nextLine()));

                        insumo.setEsParaElaborar(true); // por defecto
                        // insumo.setUnidadMedida(...); // si lo necesitás

                        insumoRepo.save(insumo);
                        System.out.println("Ingrediente creado: " + insumo.getDenominacion());
                    }
                    case "2" -> {
                        ArticuloManufacturado producto = new ArticuloManufacturado();
                        System.out.print("Nombre del artículo: ");
                        producto.setDenominacion(scanner.nextLine());

                        System.out.print("Precio de venta: ");
                        producto.setPrecioVenta(Double.parseDouble(scanner.nextLine()));

                        System.out.print("Preparación: ");
                        producto.setPreparacion(scanner.nextLine());

                        System.out.print("Tiempo estimado (minutos): ");
                        producto.setTiempoEstimadoMinutos(Integer.parseInt(scanner.nextLine()));

                        // No se agregan detalles todavía
                        manufacturadoRepo.save(producto);
                        System.out.println("Artículo manufacturado creado: " + producto.getDenominacion());
                    }
                    case "3" -> {
                        continuar = false;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida. Intenta de nuevo.");
                }
            }
        };
    }
}