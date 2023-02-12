package com.inditex.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.dto.PriceDto;
import com.inditex.dto.RespuestaMensajeDTO;
import com.inditex.model.Price;
import com.inditex.service.ServicePrice;

@RestController
@RequestMapping("/prices")
public class ControllerPrecio {

	@Autowired
	private ServicePrice servicePrice;


	
	@PutMapping("/{id}")
	public ResponseEntity<Price> modificarPrice(@Validated  @PathVariable("id") Integer idPrice, @RequestBody Price price) {
		return new ResponseEntity<Price>(servicePrice.modificarPrice(idPrice,price), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> eliminarPrice(@Validated @PathVariable("id") Integer idPrice) {
		return new ResponseEntity<Boolean>(servicePrice.eliminarPrice(idPrice), HttpStatus.OK);
	}
	
}
