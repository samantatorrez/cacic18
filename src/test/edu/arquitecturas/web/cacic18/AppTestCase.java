package edu.arquitecturas.web.cacic18;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.arquitecturas.web.cacic18.db.DAOFactory;
import edu.arquitecturas.web.cacic18.db.RevisionDao;
import edu.arquitecturas.web.cacic18.db.TrabajoDao;
import edu.arquitecturas.web.cacic18.db.UsuarioDao;
import edu.arquitecturas.web.cacic18.entity.Revision;
import edu.arquitecturas.web.cacic18.entity.Trabajo;
import edu.arquitecturas.web.cacic18.entity.Usuario;
import junit.framework.TestCase;

public class AppTestCase extends TestCase {
	private UsuarioDao usuarioDao;
	private TrabajoDao trabajoDao;
	private RevisionDao revisionDao;
	private static final String DB="MYSQL";

	@Before
	public void setUp() {
		usuarioDao = DAOFactory.getUsuarioDao(DB);
		trabajoDao = DAOFactory.getTrabajoDao(DB);
		revisionDao = DAOFactory.getRevisionDao(DB);
	}

	@Test
	public void testCrearUsuarios() {
		int cantidadUsuarios = 10;
		Usuario usuario;
		for (int i = 0; i < cantidadUsuarios; i++) {
			usuario = new Usuario();
			usuarioDao.altaUsuario(usuario);
		}
		List<Usuario> usuarios = usuarioDao.getUsuarios();
		assertEquals(cantidadUsuarios, usuarios.size());
	}

	@Test
	public void testCrearTrabajos() {
		int cantidadTrabajos = 10;
		Trabajo trabajo;
		Usuario usuario= new Usuario();
		Integer id=usuarioDao.altaUsuario(usuario);
		usuario.setIdUsuario(id);
		
		for (int i = 0; i < cantidadTrabajos; i++) {
			trabajo = new Trabajo(usuario);
			trabajoDao.altaTrabajo(trabajo);
		}
		List<Trabajo> trabajos = trabajoDao.getTrabajos();
		assertEquals(cantidadTrabajos, trabajos.size());
	}
	
	@After
	public void tearDown() {
		revisionDao.eliminarDatos();
		trabajoDao.eliminarDatos();
		usuarioDao.eliminarDatos();
	}
}
