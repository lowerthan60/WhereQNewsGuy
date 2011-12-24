package com.whereq.newsguy.gas.pojo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.whereq.newsguy.BasePojo;

public class GasPrice extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014580281551367447L;

	private Date date;
	private double todayPrice;
	private double delta;
	private double tomorrowPrice;
	private int trend;

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
		return new ToStringBuilder(this).append("date", date).append("todayPrice", todayPrice)
				.append("delta", delta).append("trend", trend).toString();
	}

}