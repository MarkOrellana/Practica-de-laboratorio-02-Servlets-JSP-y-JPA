package ups.edu.mysql.jdbc;


import ups.edu.dao.DAOFactory;
import ups.edu.dao.TelefonoDAO;
import ups.edu.dao.UsuarioDAO;
import ups.edu.mysql.jdbc.JPATelefonoDAO;
import ups.edu.mysql.jdbc.JPAUsuarioDAO;


public class JPADAOFactory extends DAOFactory{
	
	public JPADAOFactory() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public void createTables() {
        this.getUsuarioDAO().createTable();
        this.getTelefonoDAO().createTable();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new JPAUsuarioDAO();
    }

    @Override
    public TelefonoDAO getTelefonoDAO() {
        return new JPATelefonoDAO();
    }
    
}
