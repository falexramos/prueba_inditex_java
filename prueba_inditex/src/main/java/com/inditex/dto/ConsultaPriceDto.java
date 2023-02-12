package com.inditex.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.inditex.util.LocalDateTimeDeserializer;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ConsultaPriceDto {
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Nonnull
	private LocalDateTime startDate;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Nonnull
	private LocalDateTime endDate;
	
	@Nonnull
	private Integer productId;
	
	@Nonnull
	private Integer brandId;
	}
