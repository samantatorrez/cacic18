package edu.arquitecturas.web.cacic18.db.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;

import edu.arquitecturas.web.cacic18.db.MysqlDao;
import edu.arquitecturas.web.cacic18.db.RevisionDao;
import edu.arquitecturas.web.cacic18.entity.Revision;
import edu.arquitecturas.web.cacic18.entity.Trabajo;

public class RevisionMysqlDAOImpl extends MysqlDao implements RevisionDao{
	private String name = "Revision";
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void eliminarDatos() {
		List<Revision> revisiones = null;
		EntityManager eManager= null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			revisiones  = eManager.createQuery(
			         "Select a From "+getName()+" a", Revision.class).getResultList();
			for(Revision r: revisiones) {
				eManager.remove(r);
			}
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
}
