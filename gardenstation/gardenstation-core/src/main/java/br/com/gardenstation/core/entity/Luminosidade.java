package br.com.gardenstation.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = "luminosidade")
public class Luminosidade {
	
	private Integer id;
	private Integer lumi1;
	private Integer lumi2;
	private Integer lumi3;
	private Integer lumi4;
	
	@Id
	@GeneratedValue
	@Column(name = "lumi_id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "lumi_1")
	public Integer getLumi1() {
		return lumi1;
	}
	public void setLumi1(Integer lumi1) {
		this.lumi1 = lumi1;
	}
	
	@Column(name = "lumi_2")
	public Integer getLumi2() {
		return lumi2;
	}
	public void setLumi2(Integer lumi2) {
		this.lumi2 = lumi2;
	}
	
	@Column(name = "lumi_3")
	public Integer getLumi3() {
		return lumi3;
	}
	public void setLumi3(Integer lumi3) {
		this.lumi3 = lumi3;
	}
	
	@Column(name = "lumi_4")
	public Integer getLumi4() {
		return lumi4;
	}
	public void setLumi4(Integer lumi4) {
		this.lumi4 = lumi4;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lumi1 == null) ? 0 : lumi1.hashCode());
		result = prime * result + ((lumi2 == null) ? 0 : lumi2.hashCode());
		result = prime * result + ((lumi3 == null) ? 0 : lumi3.hashCode());
		result = prime * result + ((lumi4 == null) ? 0 : lumi4.hashCode());
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
		Luminosidade other = (Luminosidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lumi1 == null) {
			if (other.lumi1 != null)
				return false;
		} else if (!lumi1.equals(other.lumi1))
			return false;
		if (lumi2 == null) {
			if (other.lumi2 != null)
				return false;
		} else if (!lumi2.equals(other.lumi2))
			return false;
		if (lumi3 == null) {
			if (other.lumi3 != null)
				return false;
		} else if (!lumi3.equals(other.lumi3))
			return false;
		if (lumi4 == null) {
			if (other.lumi4 != null)
				return false;
		} else if (!lumi4.equals(other.lumi4))
			return false;
		return true;
	}
}
