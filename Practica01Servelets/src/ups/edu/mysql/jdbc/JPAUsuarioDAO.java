package ups.edu.mysql.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import ups.edu.dao.UsuarioDAO;
import ups.edu.entidades.Telefono;
import ups.edu.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findById(String id) {
		Usuario user = new Usuario();
		em.getTransaction().begin();
		String consulta = ("SELECT u FROM Usuario u WHERE u.cedula='" + id + "'");
		try {
			user = (Usuario) em.createQuery(consulta).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public Usuario findUser(String correo, String pass) {
		Usuario user = new Usuario();
		em.getTransaction().begin();
		String consulta = ("SELECT u FROM Usuario u WHERE u.correo='" + correo + "'and u.pass='" + pass + "'");
		try {
			user = (Usuario) em.createQuery(consulta).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<Usuario> findByIdOrMail(String context) {
		List<Usuario> users = new ArrayList<>();
		em.getTransaction().begin();
		if (context.equals("all")) {
			users = (List<Usuario>) em.createQuery("FROM Usuario u").getResultList();
		} else {
			String jpql = "FROM Usuario u WHERE u.cedula='" + context + "'OR u.correo='" + context + "'";
			users = (List<Usuario>) em.createQuery(jpql).getResultList();
		}
		return users;
	}

	@Override
	public List<Usuario> find() {
		List<Usuario> usuarios = new ArrayList<>();
		em.getTransaction().begin();
		String consulta = ("SELECT u FROM Usuario u");
		try {
			//usuarios = (List<Usuario>) em.createQuery(consulta).getSingleResult();
			usuarios = (List<Usuario>) em.createQuery(consulta).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return usuarios;
	}

}
