package com.whereq.address.dao;

import java.util.List;

import com.whereq.address.pojo.Country;
import com.whereq.dao.HibernateDao;
import com.whereq.dao.SessionManager;

public class CountryDAO extends HibernateDao<Country, Long> {

	public Country findCountryByCode(String code) {
		return (Country) SessionManager
				.currentSession()
				.createQuery(
						"from Country as country where country.code = :code")
				.setParameter("code", code).uniqueResult();
	}

	public List getCountries() {

		return SessionManager.currentSession()
				.createQuery("from Country as country order by country.name")
				.setCacheable(true).list();
	}
}
