package com.hero.api.controller;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hero.api.application.H2DemoApplication;
import com.hero.api.to.PowerTO;
import com.hero.api.to.SuperheroTO;

import io.restassured.response.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = H2DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@TestMethodOrder(OrderAnnotation.class)
public class SuperheroControllerTest {

	Logger logger = LoggerFactory.getLogger(SuperheroControllerTest.class);

	private final String URL = "http://localhost:8081";

	@Test
	@Order(1)
	@DisplayName("Create superhero")
	public void saveSuperhero_test() {
		logger.info("START Test saveSuperhero_test");
		SuperheroTO superhero = new SuperheroTO();
		superhero.setAge(3);
		superhero.setAlive(true);
		superhero.setDescription("Pokemon electrico");
		superhero.setHeroName("Pikachu");
		superhero.setHealth(80L);
		superhero.setResistance(50L);

		PowerTO power = new PowerTO();
		power.setIdPower(1L);
		superhero.setPower(power);

		given().request().contentType(MediaType.APPLICATION_JSON_VALUE).with().body(superhero).when()
				.put(URL + "/superhero/saveSuperhero").then().statusCode(201);

		logger.info("END Test saveSuperhero_test");
	}

	@Test
	@Order(2)
	@DisplayName("Update superhero")
	public void updateSuperhero_test() {

		logger.info("START Test updateSuperhero_test");

		//Get superhero to update
		Response res = when().get(URL + "/superhero/findById/1");
		res.then().statusCode(200).assertThat().body("idHero", equalTo(1));

		
		//Update superhero
		SuperheroTO superhero = res.getBody().as(SuperheroTO.class);
		superhero.setHealth(50L);
		given().request().contentType(MediaType.APPLICATION_JSON_VALUE).with().body(superhero).when()
				.put(URL + "/superhero/updateSuperhero").then().statusCode(200);

		logger.info("END Test saveSuperhero_test");

	}

	@Test
	@Order(3)
	@DisplayName("Find by Id")
	public void findById_test() {
		logger.info("START Test findById_test");

		Response res = when().get(URL + "/superhero/findById/1");
		res.then().statusCode(200).assertThat().body("idHero", equalTo(1));
		res.getBody().prettyPrint();
		logger.info("END Test findById_test");
	}

	@Test
	@Order(4)
	@DisplayName("Find all superheros")
	public void findAll_test() {
		when().get(URL + "/superhero/findAll").then().statusCode(200);
	}

	@Test
	@Order(5)
	@DisplayName("Find superhero like name")
	public void findLike_test() {
		logger.info("START Test findLike_test");
		String name = "man";
		Response res = when().get(URL + "/superhero/findLike/" + name);
		res.then().statusCode(200);
		logger.info("***** All supehero like name*****");
		res.getBody().prettyPrint();
		logger.info("************************");
		logger.info("END Test findLike_test");
	}

	@Test
	@Order(6)
	@DisplayName("Remove superhero")
	public void deleteSuperhero_test() {
		logger.info("START Test deleteSuperhero_test");
		when().delete(URL + "/superhero/deleteSuperhero/1").then().statusCode(200);
		Response res = when().get(URL + "/superhero/findAll");
		res.then().statusCode(200);
		logger.info("***** All supehero *****");
		res.getBody().prettyPrint();
		logger.info("************************");
		logger.info("END Test deleteSuperhero_test");
	}

}
