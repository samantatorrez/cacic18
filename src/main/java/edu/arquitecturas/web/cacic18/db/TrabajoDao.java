package edu.arquitecturas.web.cacic18.db;

import java.util.List;

import edu.arquitecturas.web.cacic18.entity.Trabajo;

public interface TrabajoDao {
	
	public Integer altaTrabajo(Trabajo trabajo);
	public Trabajo getTrabajo(Integer id);
	public List<Trabajo> getTrabajos();
	public void bajaTrabajo(Integer id);
	public void eliminarDatos();
	
}
