package com.inditex.service.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inditex.dto.ConsultaPriceDto;
import com.inditex.dto.PriceDto;
import com.inditex.dto.PriceResponseCosultaDto;
import com.inditex.dto.RespuestaMensajeDTO;
import com.inditex.model.Price;
import com.inditex.repository.RepositorioPrice;
import com.inditex.service.ServicePrice;
import com.inditex.util.Constantes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServicePriceImpl implements ServicePrice {

	
	@Autowired
	private RepositorioPrice repositorioPrice;

	
	@Override
	public RespuestaMensajeDTO guardarPrice(PriceDto priceGuadarDto) throws ServiceException {
		ModelMapper modelMapper = new ModelMapper();
		Price priceGuardar = modelMapper.map(priceGuadarDto, Price.class);
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();

		
		try {
			repositorioPrice.save(priceGuardar);
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage(Constantes.MENSAJE_CREADO_EXITO);
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			//respuestaMensajeDTO.setMensage(Constantes.MENSAJE_NO_EXITOSO_CREAR);
			respuestaMensajeDTO.setMensage(e.getMessage());
		}

		return respuestaMensajeDTO;
	}

	@Override
	public Price modificarPrice(Integer id, Price priceModificar) {
		return repositorioPrice.save(priceModificar);
	}

	@Override
	public boolean eliminarPrice(Integer id) {
		try {
			repositorioPrice.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Optional<List<PriceResponseCosultaDto>> obtenerPrecio(ConsultaPriceDto consultaPriceDto)
			throws ServiceException {
		ModelMapper modelMapper = new ModelMapper();
		Optional<List<PriceResponseCosultaDto>> listaObtenerPrice = java.util.Optional.empty();
		try {
			Optional<List<Price>> listaPrice = repositorioPrice.obtenerPrecios(consultaPriceDto.getStartDate(),
					consultaPriceDto.getEndDate(), consultaPriceDto.getProductId(), consultaPriceDto.getBrandId());
			
			listaObtenerPrice = listaPrice.map(list -> list.stream()
					.map(price -> modelMapper.map(price, PriceResponseCosultaDto.class)).collect(Collectors.toList()));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return listaObtenerPrice;
	}

	@Override
	public List<PriceResponseCosultaDto> obtenerTodos() throws ServiceException {
	    ModelMapper modelMapper = new ModelMapper();
	    List<PriceResponseCosultaDto> todos = new ArrayList<>();
	    
	    try {
	        List<Price> listaPrice = repositorioPrice.findAll();
	        
	        for (Price price : listaPrice) {
	            PriceResponseCosultaDto priceDto = modelMapper.map(price, PriceResponseCosultaDto.class);
	            todos.add(priceDto);
	        }
	    } catch (Exception e) {
	        throw new ServiceException("Error al obtener la lista de precios", e);
	    }
	    
	    return todos;
	}

	@Override
	public RespuestaMensajeDTO guardarPriceVarios(List<PriceDto> priceGuadar) throws ServiceException {
		
		ModelMapper modelMapper = new ModelMapper();
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();
		
		try {
			priceGuadar.forEach(priceDto -> {
				Price price = modelMapper.map(priceDto, Price.class);
				repositorioPrice.save(price);
			});
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage(Constantes.MENSAJE_CREADO_EXITO);
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuestaMensajeDTO.setMensage(Constantes.MENSAJE_NO_EXITOSO_CREAR);
		}
		return respuestaMensajeDTO;
		
		
	}
	

}
