package com.elBuenSabor.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturado extends Articulo {

    @Column(name = "tiempo_estimado_minutos")
    private Integer tiempoEstimadoMinutos;

    @Column(name = "preparacion", columnDefinition = "TEXT")
    private String preparacion;

    @OneToMany(mappedBy = "articuloManufacturado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticuloManufacturadoDetalle> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "articuloManufacturado", cascade = CascadeType.ALL)
    private List<Promocion> promociones = new ArrayList<>();
}
