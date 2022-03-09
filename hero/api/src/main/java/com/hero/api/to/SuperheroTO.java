package com.hero.api.to;

import java.util.Objects;

public class SuperheroTO {

	
	private Long idHero;

	private String heroName;

	private PowerTO power;

	private Boolean alive;

	private String description;

	private int age;

	private Long health;

	private Long resistance;

	public Long getIdHero() {
		return idHero;
	}

	public void setIdHero(Long idHero) {
		this.idHero = idHero;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public PowerTO getPower() {
		return power;
	}

	public void setPower(PowerTO power) {
		this.power = power;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getHealth() {
		return health;
	}

	public void setHealth(Long health) {
		this.health = health;
	}

	public Long getResistance() {
		return resistance;
	}

	public void setResistance(Long resistance) {
		this.resistance = resistance;
	}

	@Override
	public String toString() {
		return "SuperheroTO [idHero=" + idHero + ", heroName=" + heroName + ", power=" + power + ", alive=" + alive
				+ ", description=" + description + ", age=" + age + ", health=" + health + ", resistance=" + resistance
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, alive, description, health, heroName, idHero, power, resistance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperheroTO other = (SuperheroTO) obj;
		return age == other.age && Objects.equals(alive, other.alive) && Objects.equals(description, other.description)
				&& Objects.equals(health, other.health) && Objects.equals(heroName, other.heroName)
				&& Objects.equals(idHero, other.idHero) && Objects.equals(power, other.power)
				&& Objects.equals(resistance, other.resistance);
	}



	
	
}
