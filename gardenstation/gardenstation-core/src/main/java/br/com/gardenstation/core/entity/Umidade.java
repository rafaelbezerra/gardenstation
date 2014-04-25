package br.com.gardenstation.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = "umidade")
public class Umidade {

	private Integer id;
	private Double ar;
	private Double terra;
	
	@Id
	@GeneratedValue
	@Column(name = "umi_id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "umi_ar")
	public Double getAr() {
		return ar;
	}
	public void setAr(Double ar) {
		this.ar = ar;
	}
	
	@Column(name = "umi_terra")
	public Double getTerra() {
		return terra;
	}
	public void setTerra(Double terra) {
		this.terra = terra;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ar == null) ? 0 : ar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((terra == null) ? 0 : terra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Umidade other = (Umidade) obj;
		if (ar == null) {
			if (other.ar != null)
				return false;
		} else if (!ar.equals(other.ar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (terra == null) {
			if (other.terra != null)
				return false;
		} else if (!terra.equals(other.terra))
			return false;
		return true;
	}
}
