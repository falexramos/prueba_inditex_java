package com.inditex.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

import com.inditex.dto.ConsultaPriceDto;
import com.inditex.dto.PriceDto;
import com.inditex.dto.PriceResponseCosultaDto;
import com.inditex.dto.RespuestaMensajeDTO;
import com.inditex.model.Price;

public interface ServicePrice {

	RespuestaMensajeDTO guardarPrice(PriceDto priceGuadar)  throws ServiceException;
	
	RespuestaMensajeDTO guardarPriceVarios( List<PriceDto> priceGuadar)  throws ServiceException;
	
	Optional<List<PriceResponseCosultaDto>> obtenerPrecio(ConsultaPriceDto consultaPriceDto )  throws ServiceException;
	
	Price modificarPrice(Integer id, Price priceModificar)  throws ServiceException;
	
	boolean eliminarPrice(Integer id)  throws ServiceException;
	
	
	List<PriceResponseCosultaDto> obtenerTodos( )  throws ServiceException;
}
