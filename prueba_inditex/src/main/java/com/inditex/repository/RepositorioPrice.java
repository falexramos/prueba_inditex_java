package com.inditex.repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inditex.model.Price;

@Repository
public interface RepositorioPrice extends JpaRepository<Price, Integer> {

	@Query(value = "select p from Price p where p.startDate >= :startDate and p.endDate <= :endDate and p.productId = :productId and p.brandId = :brandId")

	public Optional<List<Price>> obtenerPrecios(@Param("startDate") LocalDateTime startDate,
			@Param("endDate") LocalDateTime endDate, @Param("productId") Integer productId, @Param("brandId") Integer brandId)
			throws SQLException;

}
