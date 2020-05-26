package ups.edu.mysql.jdbc;

import ups.edu.dao.TelefonoDAO;
import ups.edu.entidades.Telefono;
import ups.edu.entidades.Usuario;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {

	public JPATelefonoDAO() {
		super(Telefono.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public Telefono findById(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);

		Root<Telefono> usuarioRoot = criteriaQuery.from(Telefono.class);

		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("cedula"), id);

		criteriaQuery.select(usuarioRoot).where(predicate);

		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			return new Telefono();
		}
	}

	@Override
	public List<Telefono> findByUserId(String id) {
		Usuario usuario = JPADAOFactory.getDAOFactory().getUsuarioDAO().read(id);

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);

		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);

		Predicate predicado = criteriaBuilder.equal(telefonoRoot.get("usuario"), usuario);

		criteriaQuery.select(telefonoRoot).where(predicado);

		return em.createQuery(criteriaQuery).getResultList();
	}

}
