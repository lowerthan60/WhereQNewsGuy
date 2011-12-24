package com.whereq.newsguy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whereq.newsguy.gas.pojo.GasPrice;
import com.whereq.newsguy.gas.service.GasPriceManager;

@Controller
public class GasPriceController {

	private GasPriceManager gasPriceManager;

	public void setGasPriceManager(GasPriceManager gasPriceManager) {
		this.gasPriceManager = gasPriceManager;
	}

	// //////////////////////// @ResponseBody ////////////////////////
	@RequestMapping(method = RequestMethod.GET, value = "/gasprice/{id}", headers = "Accept=application/xml, application/json")
	public @ResponseBody
	GasPrice getGasPrice(@PathVariable String id) {
		GasPrice gasPrice = gasPriceManager.getGasPrice(id);
		return gasPrice;
	}

}
