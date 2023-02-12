package com.inditex.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.inditex.dto.ConsultaPriceDto;
import com.inditex.dto.PriceDto;
import com.inditex.dto.PriceResponseCosultaDto;
import com.inditex.dto.RespuestaMensajeDTO;
import com.inditex.repository.RepositorioPrice;
import com.inditex.service.impl.ServicePriceImpl;
import com.inditex.util.Constantes;

public class ServicePriceTest {

	@Mock
	private RepositorioPrice repositorioPrice;

	@InjectMocks
	private ServicePriceImpl servicePrice;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		servicePrice.guardarPriceVarios(prices);
	}

	public void initialize() {
		servicePrice = new ServicePriceImpl(repositorioPrice);
	}

	@DisplayName("Dado un price para crear cuando se realice " + "el llamado el servicio guardarPrice esperamos "
			+ "que el price se cree con exito ")
	@Test
	public void dadoUnPriceParaCrearEsperamosUnPriceCreado() {

		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T10:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		PriceDto priceDto = new PriceDto();

		priceDto.setBrandId(1);
		priceDto.setStartDate(LocalDateTime.parse("2020-06-14T10:00:00.0000"));
		priceDto.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59.0000"));
		priceDto.setPriceList(4);
		priceDto.setProductId(35455);
		priceDto.setPriority(1);
		priceDto.setPrice(38.95);
		priceDto.setCurr("EUR");

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPrice(priceDto);

		Assertions.assertEquals(respuestaEsperada, respuestaMensaje);

	}

	@DisplayName("Dada una lista de price para crear cuando, se realice "
			+ "el llamado el servicio guardarPriceVarios esperamos " + "que el price se cree con exito ")
	@Test
	public void dadoUnaListaDePriceParaCrearEsperamosLosPriceCreados() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
	}

	@Test
	public void consultarTodoslosPriceCreadosCuandoYaEstanRegistrados() {

		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		// Assertions.assertEquals(respuestaEsperada, respuestaMensaje);

		List<PriceResponseCosultaDto> listEsperada = new ArrayList<>();
		listEsperada.add(new PriceResponseCosultaDto(35455, 1, 0, startdate, enddate, 35.5));
		listEsperada.add(new PriceResponseCosultaDto(35455, 1, 1, startdate1, enddate1, 25.45));
		listEsperada.add(new PriceResponseCosultaDto(35455, 1, 1, startdate2, enddate2, 30.5));
		listEsperada.add(new PriceResponseCosultaDto(35455, 1, 1, startdate3, enddate3, 38.95));

		List<PriceResponseCosultaDto> respuestaList = servicePrice.obtenerTodos();

		Assertions.assertEquals(listEsperada, respuestaList);

	}
	
	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistrado() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdate,enddate,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}

	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistradoDos() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		LocalDateTime startdateconsulta = LocalDateTime.parse("2020-06-14T10:00:00.0000");
		LocalDateTime enddateconsulta = LocalDateTime.parse("2020-06-14T23:00:00.0000");
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdateconsulta,enddateconsulta,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}
	
	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistradoTres() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		LocalDateTime startdateconsulta = LocalDateTime.parse("2020-06-14T16:00:00.0000");
		LocalDateTime enddateconsulta = LocalDateTime.parse("2020-06-14T23:00:00.0000");
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdateconsulta,enddateconsulta,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}
	
	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistradoCuatro() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		LocalDateTime startdateconsulta = LocalDateTime.parse("2020-06-14T21:00:00.0000");
		LocalDateTime enddateconsulta = LocalDateTime.parse("2020-06-14T23:00:00.0000");
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdateconsulta,enddateconsulta,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}
	
	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistradoCinco() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		LocalDateTime startdateconsulta = LocalDateTime.parse("2020-06-15T10:00:00.0000");
		LocalDateTime enddateconsulta = LocalDateTime.parse("2020-06-15T23:00:00.0000");
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdateconsulta,enddateconsulta,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}
	
	@Test
	public void consultarUnPriceCreadoCuandoYaEstaRegistradoSeis() {
		RespuestaMensajeDTO respuestaEsperada = new RespuestaMensajeDTO();
		respuestaEsperada.setCodigoStatus(HttpStatus.CREATED.value());
		respuestaEsperada.setMensage(Constantes.MENSAJE_CREADO_EXITO);

		LocalDateTime startdate = LocalDateTime.parse("2020-06-14T00:00:00.0000");
		LocalDateTime enddate = LocalDateTime.parse("2020-12-31T23:59:59.0000");
		LocalDateTime startdate1 = LocalDateTime.parse("2020-06-14T15:00:00.0000");
		LocalDateTime enddate1 = LocalDateTime.parse("2020-06-14T18:30:00.0000");
		LocalDateTime startdate2 = LocalDateTime.parse("2020-06-15T00:00:00.0000");
		LocalDateTime enddate2 = LocalDateTime.parse("2020-06-15T11:00:00.0000");
		LocalDateTime startdate3 = LocalDateTime.parse("2020-06-15T16:00:00.0000");
		LocalDateTime enddate3 = LocalDateTime.parse("2020-12-31T23:59:59.0000");

		List<PriceDto> prices = Arrays.<PriceDto>asList(
				new PriceDto(null, 1, startdate, enddate, 1, 35455, 0, 35.50, "EUR"),
				new PriceDto(null, 1, startdate1, enddate1, 2, 35455, 1, 25.45, "EUR"),
				new PriceDto(null, 1, startdate2, enddate2, 3, 35455, 1, 30.50, "EUR"),
				new PriceDto(null, 1, startdate3, enddate3, 4, 35455, 1, 38.95, "EUR"));

		RespuestaMensajeDTO respuestaMensaje = servicePrice.guardarPriceVarios(prices);

		//Assertions.assertEquals(respuestaEsperada, respuestaMensaje);
		
		LocalDateTime startdateconsulta = LocalDateTime.parse("2020-06-16T21:00:00.0000");
		LocalDateTime enddateconsulta = LocalDateTime.parse("2020-06-16T23:00:00.0000");
		
		ConsultaPriceDto consultaPriceDto = new ConsultaPriceDto(startdateconsulta,enddateconsulta,35455,1);
		
		Optional<List<PriceResponseCosultaDto>> listRespuesta = servicePrice.obtenerPrecio(consultaPriceDto);
		
		 Assertions.assertEquals(respuestaEsperada, listRespuesta);
	}
	
}
