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
	public void eliminarDatos() {
		EntityManager eManager=null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			Query query = eManager.createNativeQuery("DELETE FROM " + getName());
			query.executeUpdate();
			eManager.getTransaction().commit();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	public abstract String getName();
}
