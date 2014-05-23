package mx.com.empresa.config.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import mx.com.empresa.config.util.FacesHandler;
import mx.com.royalsun.commons.response.Response;

@ManagedBean
@RequestScoped
public class LoginView extends BackingBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594525093573188259L;
	
	private String usuario;
	private String contrasenia;
	
	public String login() {
		
		String navigate = null;
	
		
		return navigate;
	}
	
	public boolean isRenderBackmenu() {
		String viewID = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		return !"/security/login.xhtml".equals(viewID) && !"/pages/home/index.xhtml".equals(viewID);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
