package com.inditex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.dto.ConsultaPriceDto;
import com.inditex.dto.PriceResponseCosultaDto;
import com.inditex.service.ServicePrice;

@RestController
@RequestMapping("/prices")
public class ConsultaPriceController {

	@Autowired
	private ServicePrice servicePrice;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/listar")
	public Optional<List<PriceResponseCosultaDto>> obtenerPrice(@RequestBody ConsultaPriceDto consultaPriceDto ) {
		return servicePrice.obtenerPrecio(consultaPriceDto);
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<PriceResponseCosultaDto> obtenerTodos() {
		return servicePrice.obtenerTodos();
	}
	
}
