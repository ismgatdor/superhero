package com.hero.api.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hero.api.controller.SuperheroController;
import com.hero.api.to.SuperheroTO;
import com.hero.business.bo.SuperheroBO;
import com.hero.business.services.SuperheroService;
import com.hero.exception.SuperheroException;

@RestController
public class SuperheroControllerImpl implements SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	public ResponseEntity<List<SuperheroTO>> findAll() {

		List<SuperheroTO> result = new ArrayList<>();
		try {
			List<SuperheroBO> listEntity = (List<SuperheroBO>) superheroService.findAll();

			if (listEntity != null && !listEntity.isEmpty()) {
				result.addAll(new ArrayList<>(listEntity.parallelStream()
						.map(r -> SuperheroControllerImpl.objectMapperBOToTO(r)).collect(Collectors.toList())));

			}
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<SuperheroTO> findById(final Long id) {
		SuperheroTO result = null;
		try {
			SuperheroBO entity = superheroService.findById(id);
			result = SuperheroControllerImpl.objectMapperBOToTO(entity);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	public ResponseEntity<List<SuperheroTO>> findLike(final String name) {
		List<SuperheroTO> result = new ArrayList<>();
		try {
			List<SuperheroBO> listEntity = superheroService.findLike(name);
			if (listEntity != null && !listEntity.isEmpty()) {
				result.addAll(new ArrayList<>(listEntity.parallelStream()
						.map(r -> SuperheroControllerImpl.objectMapperBOToTO(r)).collect(Collectors.toList())));

			}
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<Boolean> saveSuperhero(SuperheroTO bo) {
		try {
			SuperheroBO upd = SuperheroControllerImpl.objectMapperTOToBO(bo);
			superheroService.updateOrSaveSuperhero(upd);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Boolean> updateSuperhero(SuperheroTO bo) {
		try {
			SuperheroBO upd = SuperheroControllerImpl.objectMapperTOToBO(bo);
			superheroService.updateOrSaveSuperhero(upd);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	public ResponseEntity<Boolean> deleteSuperhero(final Long id) {
		try {
			superheroService.deleteSuperhero(id);
		} catch (SuperheroException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	public static SuperheroTO objectMapperBOToTO(SuperheroBO object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		SuperheroTO superhero = mapper.convertValue(object, SuperheroTO.class);
		return superhero;
	}

	public static SuperheroBO objectMapperTOToBO(SuperheroTO object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		SuperheroBO superhero = mapper.convertValue(object, SuperheroBO.class);
		return superhero;
	}

}
