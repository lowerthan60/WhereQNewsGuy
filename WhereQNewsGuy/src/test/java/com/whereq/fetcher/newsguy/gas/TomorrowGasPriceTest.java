package com.whereq.fetcher.newsguy.gas;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whereq.exception.ApplicationException;
import com.whereq.newsguy.gas.pojo.GasPrice;

public class TomorrowGasPriceTest extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPost() {
		String url = "http://tomorrowsgaspricetoday.com/gas-prices.html";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cityId", "81");

		GasPrice gasPrice = null;

		TomorrowGasPrice tgp = new TomorrowGasPrice();
		try {
			gasPrice = tgp.fetch(url, parameters);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(gasPrice.getTodayPrice() > 0 || gasPrice.getTomorrowPrice() > 0);
	}

}
