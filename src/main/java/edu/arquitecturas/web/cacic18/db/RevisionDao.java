package edu.arquitecturas.web.cacic18.db;

import java.util.List;

import edu.arquitecturas.web.cacic18.entity.Revision;

public interface RevisionDao {
	
	public void altaRevision();
	public Revision getRevision(Integer id);
	public List<Revision> getRevisiones();
	public void bajaRevision(Integer id);
	public void eliminarDatos();

}
