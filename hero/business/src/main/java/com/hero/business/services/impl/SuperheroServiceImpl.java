package com.hero.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hero.business.bo.SuperheroBO;
import com.hero.business.services.SuperheroService;
import com.hero.commons.annotations.MeasureTime;
import com.hero.data.entity.SuperheroEntity;
import com.hero.data.repository.SuperheroRepository;
import com.hero.exception.SuperheroException;

@Service
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Transactional
	@MeasureTime
	public List<SuperheroBO> findAll() throws SuperheroException {

		List<SuperheroBO> result = new ArrayList<>();

		try {
			List<SuperheroEntity> listEntity = (List<SuperheroEntity>) superheroRepository.findAll();
			if (listEntity != null && !listEntity.isEmpty()) {
				result.addAll(new ArrayList<>(listEntity.parallelStream().map(r -> this.objectMapperEntityToBO(r))
						.collect(Collectors.toList())));
			}
		} catch (Exception e) {
			throw new SuperheroException();
		}

		return result;
	}

	@Transactional
	@MeasureTime
	public SuperheroBO findById(final Long id) throws SuperheroException {
		SuperheroBO result = null;
		try {
			SuperheroEntity entity = superheroRepository.findById(id).get();
			result = this.objectMapperEntityToBO(entity);

		} catch (Exception e) {
			throw new SuperheroException();
		}
		return result;

	}

	@Transactional
	@MeasureTime
	public List<SuperheroBO> findLike(final String name) throws SuperheroException {

		List<SuperheroBO> result = new ArrayList<>();

		try {
			List<SuperheroEntity> listEntity = superheroRepository.findLikeName(name);
			if (listEntity != null && !listEntity.isEmpty()) {
				result.addAll(new ArrayList<>(listEntity.parallelStream().map(r -> this.objectMapperEntityToBO(r))
						.collect(Collectors.toList())));

			}
		} catch (Exception e) {
			throw new SuperheroException(e.getMessage());
		}
		return result;
	}

	@Transactional
	@MeasureTime
	public void updateOrSaveSuperhero(SuperheroBO bo) throws SuperheroException {
		try {
			SuperheroEntity upd = this.objectMapperBOToEntity(bo);
			superheroRepository.save(upd);

		} catch (Exception e) {
			throw new SuperheroException();
		}
	}

	@Transactional
	@MeasureTime
	public void deleteSuperhero(final Long id) throws SuperheroException{
		try {
			superheroRepository.deleteById(id);
		} catch (Exception e) {
			throw new SuperheroException();
		}
	}

	private SuperheroBO objectMapperEntityToBO(SuperheroEntity object) {
		SuperheroBO superhero = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		superhero = mapper.convertValue(object, SuperheroBO.class);
		return superhero;
	}

	private SuperheroEntity objectMapperBOToEntity(SuperheroBO object) {

		SuperheroEntity superhero = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		superhero = mapper.convertValue(object, SuperheroEntity.class);
		return superhero;
	}
}
