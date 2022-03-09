package com.hero.business.services;

import java.util.List;

import com.hero.business.bo.SuperheroBO;
import com.hero.exception.SuperheroException;

public interface SuperheroService {
	
	public List<SuperheroBO> findAll() throws SuperheroException;
	
	public SuperheroBO findById(final Long id) throws SuperheroException;
	
	public List<SuperheroBO> findLike(final String name) throws SuperheroException;
	
	public void updateOrSaveSuperhero(SuperheroBO bo) throws SuperheroException;
	
	public void deleteSuperhero(final Long id) throws SuperheroException;
}
