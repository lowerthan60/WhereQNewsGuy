package com.whereq.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whereq.fetcher.Fetcher;
import com.whereq.newsguy.gas.pojo.GasPrice;

public class BeanFactoryWrapperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTomorrowGasPriceFetcher() {
		Fetcher<GasPrice> tomorrowGasPriceFetcher = BeanFactoryWrapper.getTomorrowGasPriceFetcher();
		System.out.println(tomorrowGasPriceFetcher);

	}

}
