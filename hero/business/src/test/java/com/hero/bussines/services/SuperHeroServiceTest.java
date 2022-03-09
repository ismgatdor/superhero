package com.hero.bussines.services;



import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hero.business.bo.PowerBO;
import com.hero.business.bo.SuperheroBO;
import com.hero.business.services.SuperheroService;
import com.hero.data.application.H2DemoApplication;
import com.hero.exception.SuperheroException;


@SpringBootTest(classes = H2DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SuperHeroServiceTest {

	Logger logger = LoggerFactory.getLogger(SuperHeroServiceTest.class);
	
	@Autowired
	private SuperheroService superheroService;
	
	@Test
	@Order(1)
	@DisplayName("Create superhero")
	public void saveSuperhero_test() {
		logger.info("START Test saveSuperhero_test");
		SuperheroBO superhero = new SuperheroBO();
		superhero.setAge(3);
		superhero.setAlive(true);
		superhero.setDescription("Pokemon electrico");
		superhero.setHeroName("Pikachu");
		superhero.setHealth(80L);
		superhero.setResistance(50L);

		PowerBO power = new PowerBO();
		power.setIdPower(1L);
		superhero.setPower(power);
		
		try {
			
			superheroService.updateOrSaveSuperhero(superhero);
		} catch (SuperheroException e) {
			Assertions.assertTrue(false);
		}

		logger.info("END Test saveSuperhero_test");
	}
	
	
	@Test
	@Order(2)
	@DisplayName("Find superhero like name")
	public void findLike_test() {
		logger.info("START Test findLike_test");
		try {
			List<SuperheroBO> listBo = superheroService.findLike("man");
			logger.info("***** All supehero like name*****");
			logger.info(listBo.toString());
			logger.info("************************");
		} catch (SuperheroException e) {
			Assertions.assertTrue(false);
		}
		
		logger.info("END Test findLike_test");
	}
}
