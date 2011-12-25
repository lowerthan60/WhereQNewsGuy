package com.whereq.newsguy.gas.service;

import java.util.HashMap;
import java.util.Map;

import com.whereq.exception.ApplicationException;
import com.whereq.fetcher.newsguy.gas.TomorrowGasPrice;
import com.whereq.newsguy.gas.pojo.GasPrice;
import com.whereq.newsguy.service.BaseManager;

public class GasPriceManager extends BaseManager {
	public GasPrice getGasPrice(String cityId) {
		String url = "http://tomorrowsgaspricetoday.com/gas-prices.html";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cityId", cityId);

		GasPrice gasPrice = null;

		TomorrowGasPrice tgp = new TomorrowGasPrice();
		try {
			gasPrice = tgp.fetch(url, parameters);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gasPrice;
	}
}
