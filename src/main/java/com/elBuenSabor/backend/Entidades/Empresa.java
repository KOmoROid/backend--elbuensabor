package com.elBuenSabor.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "cuil")
    private Integer cuil;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales = new ArrayList<>();
}
