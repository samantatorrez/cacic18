package main.java.edu.arquitecturas.web.cacic18.db;

import main.java.edu.arquitecturas.web.cacic18.db.mysql.impl.RevisionMysqlDAOImpl;
import main.java.edu.arquitecturas.web.cacic18.db.mysql.impl.TrabajoMysqlDAOImpl;
import main.java.edu.arquitecturas.web.cacic18.db.mysql.impl.UsuarioMysqlDAOImpl;

public class DAOFactory 
{
	
	public static RevisionDao getRevisionDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new RevisionMysqlDAOImpl();
		}
	}
	
	public static UsuarioDao getUsuarioDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new UsuarioMysqlDAOImpl();
		}
	}
	
	public static TrabajoDao getTrabajoDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new TrabajoMysqlDAOImpl();
		}
	}
	
}
