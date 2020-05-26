package ups.edu.dao;

import java.util.List;

import ups.edu.entidades.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario, String> {
    public abstract Usuario findUser(String correo, String pass);
    public abstract List<Usuario> findByIdOrMail(String context);
	public abstract Usuario finUsuarioByMail(String correo);
}
