package com.whereq.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseHibernateDao<T, PK extends Serializable> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;

	protected Class<T> entityClass;

	public BaseHibernateDao() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

	public BaseHibernateDao(final SessionFactory sessionFactory,
			final Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return SessionManager.currentSession();
	}

	/**
	 * To export a method for client to begin Hibernate transaction
	 * 
	 * Note! The transaction should be handled by Spring in the real world!
	 */
	public void beginTransaction() {
		getSession().beginTransaction();
	}

	/**
	 * To export a method for client to commit Hibernate transaction
	 * 
	 * Note! The transaction should be handled by Spring in the real world!
	 */
	public void commit() {
		getSession().getTransaction().commit();
	}

	public void save(final T entity) {
		getSession().saveOrUpdate(entity);
		logger.debug("save entity: {}", entity);
	}

	public void delete(final T entity) {

		getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	public void delete(final PK id) {

		delete(get(id));
		logger.debug("delete entity {},id is {}", entityClass.getSimpleName(),
				id);
	}

	public T get(final PK id) {

		return (T) getSession().load(entityClass, id);
	}

}
