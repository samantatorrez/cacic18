package main.java.edu.arquitecturas.web.cacic18.service;

import main.java.edu.arquitecturas.web.cacic18.db.DAOFactory;
import main.java.edu.arquitecturas.web.cacic18.db.RevisionDao;
import main.java.edu.arquitecturas.web.cacic18.db.TrabajoDao;
import main.java.edu.arquitecturas.web.cacic18.db.UsuarioDao;

public class CacicService {
	private UsuarioDao user;
	private RevisionDao revision;
	private TrabajoDao trabajo;
	private String db;

	public CacicService(String db) {
		this.user = DAOFactory.getUsuarioDao(db);
		this.revision = DAOFactory.getRevisionDao(db);
		this.trabajo = DAOFactory.getTrabajoDao(db);
		this.db = db;
	}

}
