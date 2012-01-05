package com.whereq.fetcher.newsguy.gas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/**/whereq-context*.xml" })
public class GasPriceManagerTest extends
		AbstractTransactionalSpringContextTests {

	
	@Test
	public void testListCities() {
//		GasPriceManager gasPriceManager = new GasPriceManager();
//		try {
//			gasPriceManager.fetchAllGasPrice();
//			// gasPriceManager.getGasPrice("101");
//		} catch (ApplicationException e) {
//			e.printStackTrace();
//		}

	}

}
