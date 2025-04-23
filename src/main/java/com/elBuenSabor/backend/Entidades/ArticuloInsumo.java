package com.elBuenSabor.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo_insumo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumo extends Articulo {

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_maximo")
    private Integer stockMaximo;

    @Column(name = "es_para_elaborar")
    private Boolean esParaElaborar;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id")
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "articuloInsumo")
    private List<ArticuloManufacturadoDetalle> detallesManufacturados = new ArrayList<>();
}
