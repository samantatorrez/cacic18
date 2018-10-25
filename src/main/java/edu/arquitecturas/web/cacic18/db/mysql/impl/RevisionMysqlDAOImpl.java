package edu.arquitecturas.web.cacic18.db.mysql.impl;

import edu.arquitecturas.web.cacic18.db.MysqlDao;
import edu.arquitecturas.web.cacic18.db.RevisionDao;

public class RevisionMysqlDAOImpl extends MysqlDao implements RevisionDao{
	private String name = "Usuario";
	@Override
	public String getName() {
		return name;
	}
	
}
