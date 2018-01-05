package com.whereq.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;

public class HibernateDao<T, PK extends Serializable> extends BaseHibernateDao<T, PK> {

	public HibernateDao() {
		super();
	}

	public HibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}

}
