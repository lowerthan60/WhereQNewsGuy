package com.whereq.address.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whereq.address.pojo.City;

public class CityDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListCities() {
		CityDAO cityDAO = new CityDAO();
		List<City> cities = cityDAO.getCities();
		for (City city : cities) {
			System.out.println(city);
		}

	}

}
