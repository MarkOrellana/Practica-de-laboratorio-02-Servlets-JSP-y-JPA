package ups.edu.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String pass;
	private int activo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Telefono> telefonos;

	public Usuario() {

	}

	public Usuario(String cedula, String nombre, String apellido, String correo, String pass, int activo) {

		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.pass = pass;
		this.activo = activo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Usuario other = (Usuario) obj;
		if (!Objects.equals(this.correo, other.correo)) {
			return false;
		}
		if (!Objects.equals(this.pass, other.pass)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", pass=" + pass + ", activo=" + activo + ", telefonos=" + telefonos + "]";
	}

}
