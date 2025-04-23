package com.elBuenSabor.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

    @OneToMany(mappedBy = "articulo")
    private List<DetallePedido> detallesPedido = new ArrayList<>();
}
