package edu.arquitecturas.web.cacic18.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public abstract class MysqlDao {
	private static final String DATABASE="cacic-mysql";
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE);
		return emf.createEntityManager();
	}
	public abstract String getName();
}
