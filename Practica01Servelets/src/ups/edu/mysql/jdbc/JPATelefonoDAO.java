package ups.edu.mysql.jdbc;

import ups.edu.dao.TelefonoDAO;
import ups.edu.entidades.Telefono;
import ups.edu.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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
		Telefono telefono = new Telefono();
		em.getTransaction().begin();
		String consulta = ("SELECT t FROM Telefono t WHERE t.id='" + id + "'");
		try {
			//telefono = (Telefono) em.createQuery(consulta).getSingleResult();
			telefono = (Telefono) em.createQuery(consulta).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return telefono;
	}

	@Override
	public List<Telefono> findByUserId(String cedula) {
		  List<Telefono> telefonos = new ArrayList<>();
		  em.getTransaction().begin();
		  String consulta=("SELECT t FROM Telefono t WHERE t.usuario_cedula='"+cedula+"'");
		  //Query query = em.createQuery( "SELECT t " + "FROM Telefono t " + "WHERE t.usuario_cedula='"+cedula+"'");
		  try {
				telefonos = (List<Telefono>) em.createQuery(consulta).getSingleResult();
			  //List<Telefono> list=(List<Telefono>)query.getResultList();
		  } catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
	      return telefonos;
	    }

	@Override
	public List<Telefono> find() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
