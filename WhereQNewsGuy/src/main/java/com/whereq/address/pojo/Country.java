package com.whereq.address.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "code", length = 100, nullable = false)
	private String code;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@OneToMany(mappedBy = "country", targetEntity = City.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<City> cities;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setAirports(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.toString();
	}

}
