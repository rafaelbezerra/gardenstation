package br.com.gardenstation.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name = "medicoes")
public class Medicoes {
	
	private Integer id;
	private Umidade umidade;
	private Luminosidade luminosidade;
	private Temperatura temperatura;
	
	@Id
	@GeneratedValue
	@Column(name = "med_id", nullable = false)
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	@Required
	@OneToOne
	@PrimaryKeyJoinColumn(name = "umi_id")
	public Umidade getUmidade() {
		return umidade;
	}
	public void setUmidade(Umidade umidade) {
		this.umidade = umidade;
	}
	
	@Required
	@OneToOne
	@PrimaryKeyJoinColumn(name = "lumi_id")
	public Luminosidade getLuminosidade() {
		return luminosidade;
	}
	public void setLuminosidade(Luminosidade luminosidade) {
		this.luminosidade = luminosidade;
	}
	
	@Required
	@OneToOne
	@PrimaryKeyJoinColumn(name = "temp_id")
	public Temperatura getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((luminosidade == null) ? 0 : luminosidade.hashCode());
		result = prime * result
				+ ((temperatura == null) ? 0 : temperatura.hashCode());
		result = prime * result + ((umidade == null) ? 0 : umidade.hashCode());
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
		Medicoes other = (Medicoes) obj;
		if (luminosidade == null) {
			if (other.luminosidade != null)
				return false;
		} else if (!luminosidade.equals(other.luminosidade))
			return false;
		if (temperatura == null) {
			if (other.temperatura != null)
				return false;
		} else if (!temperatura.equals(other.temperatura))
			return false;
		if (umidade == null) {
			if (other.umidade != null)
				return false;
		} else if (!umidade.equals(other.umidade))
			return false;
		return true;
	}
}
