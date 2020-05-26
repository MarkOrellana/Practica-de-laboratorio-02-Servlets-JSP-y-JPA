package ups.edu.dao;

import ups.edu.mysql.jdbc.JPADAOFactory;

public abstract class DAOFactory {
	
    protected static DAOFactory factory = new JPADAOFactory();
    
    public static DAOFactory getDAOFactory(){
    	return factory;
    	}
    
    public abstract void createTables();
    
    public abstract UsuarioDAO getUsuarioDAO();
    
    public abstract TelefonoDAO getTelefonoDAO();
}
