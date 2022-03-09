package com.hero.business.bo;

import java.util.Objects;

public class PowerBO {

	private Long idPower;

	private String powerName;

	private String damage;

	private String element;


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

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
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
		return "PowerBO [idPower=" + idPower + ", powerName=" + powerName + ", damage=" + damage + ", element="
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
		PowerBO other = (PowerBO) obj;
		return Objects.equals(damage, other.damage) && Objects.equals(element, other.element)
				&& Objects.equals(idPower, other.idPower) && Objects.equals(powerName, other.powerName);
	}


	
	
}
