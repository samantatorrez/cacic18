package main.java.edu.arquitecturas.web.cacic18.db.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.edu.arquitecturas.web.cacic18.db.MysqlDao;
import main.java.edu.arquitecturas.web.cacic18.db.RevisionDao;
import main.java.edu.arquitecturas.web.cacic18.entity.Revision;

public class RevisionMysqlDAOImpl extends MysqlDao implements RevisionDao{
	private String name = "Revision";
	
	@Override
	public void altaRevision(Revision revision) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			eManager.persist(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}

	@Override
	public Revision getRevision(Integer id) {
		Revision revision = null;
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			revision = eManager.find(Revision.class, id);
			return revision;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revision;
	}

	@Override
	public List<Revision> getRevisiones() {
		List<Revision> revisiones = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			revisiones = eManager.createQuery(
			         "Select a From Employee a", Revision.class).getResultList();
			return revisiones;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revisiones;
	}

	@Override
	public void bajaRevision(Integer id) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Revision revision = eManager.find(Revision.class, id);
			eManager.remove(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
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
