package com.whereq.address.dao;

import java.util.List;

import com.whereq.address.pojo.City;
import com.whereq.address.pojo.Country;
import com.whereq.dao.HibernateDao;
import com.whereq.dao.SessionManager;

public class CityDAO extends HibernateDao<City, Long> {

	public List getCities() {

		return SessionManager.currentSession()
				.createQuery("from City as city order by city.name")
				.setCacheable(true).list();
	}
}
