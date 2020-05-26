package ups.edu.mysql.jdbc;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ups.edu.dao.UsuarioDAO;
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
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);

		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("cedula"), id);

		criteriaQuery.select(usuarioRoot).where(predicate);

		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			return new Usuario();
		}
	}

	@Override
	public Usuario findUser(String correo, String pass) {
		Usuario user = new Usuario();
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
	public List<Usuario> findByIdOrMail(String correo) {
		Usuario usuario = JPADAOFactory.getDAOFactory().getUsuarioDAO().finUsuarioByMail(correo);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Usuario> creCriteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> telefonoRoot = creCriteriaQuery.from(Usuario.class);
		
		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("usuario"),usuario);
		
		creCriteriaQuery.select(telefonoRoot).where(predicate);
		
		return em.createQuery(creCriteriaQuery).getResultList();
	}

	@Override
	public Usuario finUsuarioByMail(String correo) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		
		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("correo"), correo);
		
		criteriaQuery.select(usuarioRoot).where(predicate);
		
		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		}catch(NoResultException e) {
			return new Usuario();
		}
		
	}

}
