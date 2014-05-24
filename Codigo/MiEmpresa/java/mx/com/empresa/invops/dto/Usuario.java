package mx.com.empresa.invops.dto;

import java.util.Date;

public class Usuario {

	private String usuarioId;
	private String password;
	private String estadoId;
	private Date pswdch;
	private Perfil perfil;
	
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}
	public Date getPswdch() {
		return pswdch;
	}
	public void setPswdch(Date pswdch) {
		this.pswdch = pswdch;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
