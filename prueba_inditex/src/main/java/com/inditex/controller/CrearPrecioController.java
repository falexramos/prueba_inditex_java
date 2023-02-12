package com.inditex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.dto.PriceDto;
import com.inditex.dto.RespuestaMensajeDTO;
import com.inditex.service.ServicePrice;

@RestController
@RequestMapping("/prices")
public class CrearPrecioController {

	@Autowired
	private ServicePrice servicePrice;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crear")
	public RespuestaMensajeDTO crearPrice(@Validated  @RequestBody PriceDto priceGuadar) {
		return servicePrice.guardarPrice(priceGuadar);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crearVarios")
	public RespuestaMensajeDTO crearPriceVarios(@Validated @RequestBody List<PriceDto> priceGuadar) {
		return servicePrice.guardarPriceVarios(priceGuadar);
	}
}
