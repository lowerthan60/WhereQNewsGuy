package com.whereq.newsguy.gas.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.whereq.address.pojo.City;
import com.whereq.newsguy.BasePojo;

@Entity(name = "gas_price")
public class GasPrice extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014580281551367447L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;
	
	@Column(name = "today_price", precision = 2)
	private double todayPrice;

	@Column(name = "delta", precision = 2)
	private double delta;

	@Column(name = "tomorrow_price", precision = 2)
	private double tomorrowPrice;

	@Column(name = "trend")
	private int trend;

	@Column(name = "record_time")
	private Date date;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTodayPrice() {
		return todayPrice;
	}

	public void setTodayPrice(double todayPrice) {
		this.todayPrice = todayPrice;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public double getTomorrowPrice() {
		return tomorrowPrice;
	}

	public void setTomorrowPrice(double tomorrowPrice) {
		this.tomorrowPrice = tomorrowPrice;
	}

	public int getTrend() {
		return trend;
	}

	public void setTrend(int trend) {
		this.trend = trend;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("date", date).append("todayPrice", todayPrice)
				.append("delta", delta).append("trend", trend)
				.append("city", city.getId()).toString();
	}

}
