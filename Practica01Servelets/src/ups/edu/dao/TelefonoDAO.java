package ups.edu.dao;

import java.util.List;

import ups.edu.entidades.Telefono;


public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
    public abstract List<Telefono> findByUserId(String cedula);
}
