package com.elBuenSabor.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elBuenSabor.backend.Entidades.ArticuloManufacturado;

public interface ArticuloManufacturadoRepository extends JpaRepository<ArticuloManufacturado, Long> {}
