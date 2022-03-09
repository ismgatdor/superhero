package com.hero.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "superhero", name = "hero_power")
public class PowerEntity {

	@Id
	@SequenceGenerator(name = "HERO_SEQ_POWER", sequenceName = "superhero.hero_seq_power", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HERO_SEQ_POWER")
	@Column(name = "id_power", unique = true, precision = 10)
	private Long idPower;
	
	@Column(name = "power_name")
	private String powerName;
	
	@Column(name = "damage")
	private Long damage;
	
	@Column(name="element")
	private String element;

	
	public PowerEntity() {
		super();
	}

	public Long getIdPower() {
		return idPower;
	}

	public void setIdPower(Long idPower) {
		this.idPower = idPower;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}


	public Long getDamage() {
		return damage;
	}

	public void setDamage(Long damage) {
		this.damage = damage;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "PowerEntity [idPower=" + idPower + ", powerName=" + powerName + ", damage=" + damage + ", element="
				+ element + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(damage, element, idPower, powerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerEntity other = (PowerEntity) obj;
		return Objects.equals(damage, other.damage) && Objects.equals(element, other.element)
				&& Objects.equals(idPower, other.idPower) && Objects.equals(powerName, other.powerName);
	}

	
	
	
}
