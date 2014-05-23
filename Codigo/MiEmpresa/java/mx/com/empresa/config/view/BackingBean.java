package mx.com.empresa.config.view;

import java.io.Serializable;
import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import mx.com.empresa.config.util.FacesHandler;
import mx.com.royalsun.security.vo.SessionAccount;

import org.primefaces.context.RequestContext;

/**
 * @author DJIHERNA
 */
public class BackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1488400272867904052L;

	protected void addInfoMessage(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(summary, detail));
	}
	

	protected void addErrorMessage(String idUi, String message) {
		FacesContext contextFaces = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		contextFaces.addMessage(idUi, msg);
	}

	protected void cleanFacesMessage() {
		try {
			FacesContext contextFaces = FacesContext.getCurrentInstance();
			Iterator<FacesMessage> msgIterator = contextFaces.getMessages();
			while (msgIterator.hasNext()) {
				msgIterator.remove();
			}
		} catch (java.util.NoSuchElementException nsee) {
			System.out.println(nsee);
		}
	}

	public void closeDialog(String widgetVarDialog, boolean flagErrorMsg) {
		if (!flagErrorMsg) {
			RequestContext contextRequest = RequestContext.getCurrentInstance();
			contextRequest.execute(widgetVarDialog + ".hide()");
		}
	}

	public void openDialog(String widgetVarDialog, boolean success) {
		if (success) {
			RequestContext contextRequest = RequestContext.getCurrentInstance();
			contextRequest.execute(widgetVarDialog + ".show()");
		}
	}

	public void refreshComponent(String componentUpdate) {
		RequestContext contextRequest = RequestContext.getCurrentInstance();
		contextRequest.update(componentUpdate);
	}

	public SessionAccount getSessionAccount() {
		return (SessionAccount) FacesHandler.getSessionMapValue(
				FacesContext.getCurrentInstance(), "sessionAccount");
	}

	public static Object getExpressionValue(String expression) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		ValueExpression ve = factory.createValueExpression(ctx, expression, Object.class);
		if (ve != null)
			return ve.getValue(ctx);
		else
			return null;
	}
	
	public static ValueExpression getExpression(String expression) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		return factory.createValueExpression(ctx, expression, Object.class);
	}
	
	public static MethodExpression getMethodExpression(String expression,
			Class<?> type, Class<?>... types) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		return factory.createMethodExpression(ctx, expression, type, types);
	}

	public static ValueExpression getExpression(String expression, Class<?> type) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		return factory.createValueExpression(ctx, expression, type);
	}
	
	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param component
	 */
	protected void update(String component) {
		RequestContext.getCurrentInstance().update( component );
	}
	
	
	
}
