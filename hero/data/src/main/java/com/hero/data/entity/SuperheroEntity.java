package com.hero.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "superhero", name = "hero_superhero")
public class SuperheroEntity {
	
	@Id
	@SequenceGenerator(name = "HERO_SEQ_SUPERHERO", sequenceName = "superhero.hero_seq_superhero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HERO_SEQ_SUPERHERO")
	@Column(name = "id_hero", unique = true, precision = 10)
	private Long idHero;
	
	@Column(name = "hero_name")
	private String heroName;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_power")
	private PowerEntity power;
	
	@Column(name = "alive")
	private Boolean alive;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "health")
	private Long health;
	
	@Column(name = "resistance")
	private Long resistance;
	
	public SuperheroEntity() {
		super();
	}
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

	public PowerEntity getPower() {
		return power;
	}
	public void setPower(PowerEntity power) {
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
		return "SuperheroEntity [idHero=" + idHero + ", heroName=" + heroName + ", power=" + power + ", alive=" + alive
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
		SuperheroEntity other = (SuperheroEntity) obj;
		return age == other.age && Objects.equals(alive, other.alive) && Objects.equals(description, other.description)
				&& Objects.equals(health, other.health) && Objects.equals(heroName, other.heroName)
				&& Objects.equals(idHero, other.idHero) && Objects.equals(power, other.power)
				&& Objects.equals(resistance, other.resistance);
	}
	
	
	
	

}
