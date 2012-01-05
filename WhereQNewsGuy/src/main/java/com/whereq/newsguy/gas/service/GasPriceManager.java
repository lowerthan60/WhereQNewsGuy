package com.whereq.newsguy.gas.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whereq.address.dao.CityDAO;
import com.whereq.address.pojo.City;
import com.whereq.exception.ApplicationException;
import com.whereq.fetcher.newsguy.gas.TomorrowGasPrice;
import com.whereq.newsguy.gas.dao.GasPriceDAO;
import com.whereq.newsguy.gas.pojo.GasPrice;
import com.whereq.service.BaseManager;

public class GasPriceManager extends BaseManager {

	private static String GAS_PRICE_URL = "http://tomorrowsgaspricetoday.com/gas-prices.html";

	private CityDAO cityDAO;
	private GasPriceDAO gasPriceDAO;

	private TomorrowGasPrice tomorrowGasPrice;

	public GasPrice getGasPrice(String cityId) throws ApplicationException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cityId", cityId);

		GasPrice gasPrice = null;

		gasPrice = tomorrowGasPrice.fetch(GAS_PRICE_URL, parameters);
		return gasPrice;
	}

	public void fetchAllGasPrice() throws ApplicationException {

		GasPrice gasPrice = null;
		Map<String, String> parameters = new HashMap<String, String>();

		List<City> cities = cityDAO.getCities();
		for (City city : cities) {
			parameters.put("cityId", Long.toString(city.getId()));
			gasPrice = tomorrowGasPrice.fetch(GAS_PRICE_URL, parameters);
		}
	}

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public GasPriceDAO getGasPriceDAO() {
		return gasPriceDAO;
	}

	public void setGasPriceDAO(GasPriceDAO gasPriceDAO) {
		this.gasPriceDAO = gasPriceDAO;
	}

	public TomorrowGasPrice getTomorrowGasPrice() {
		return tomorrowGasPrice;
	}

	public void setTomorrowGasPrice(TomorrowGasPrice tomorrowGasPrice) {
		this.tomorrowGasPrice = tomorrowGasPrice;
	}

}
