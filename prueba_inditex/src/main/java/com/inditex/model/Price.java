package com.inditex.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.inditex.util.LocalDateTimeDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer brandId;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(nullable = false)
	private LocalDateTime startDate;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(nullable = false)
	private LocalDateTime endDate;
	
	@Column(nullable = false)
	private Integer priceList;
	
	@Column(nullable = false)
	private Integer productId;
	
	@Column(nullable = false)
	private Integer priority;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private String curr;
}
