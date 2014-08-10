package edu.tecsup.seguridad.model;

public class Usuario {

	private Integer id;
	
	private String usuario;
	
	private String clave;
	
	private String nombres;
	
	private String correo;
	
	private Rol rol;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String usuario, String clave, String nombres,
			String correo, Rol rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		this.nombres = nombres;
		this.correo = correo;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", clave="
				+ clave + ", nombres=" + nombres + ", correo=" + correo
				+ ", rol=" + rol + "]";
	}
	
}
