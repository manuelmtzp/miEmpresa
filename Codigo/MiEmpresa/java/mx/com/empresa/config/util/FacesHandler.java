package mx.com.empresa.config.util;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.context.RequestContext;

/**
 * @author Ing. Juan Israel Hernández García
 * 
 */
public class FacesHandler {
	
	public static final String ACTION_SUCCESS = "actionSuccess";

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param context
	 * @param key
	 * @return
	 */
	public static Object getSessionMapValue(FacesContext context, String key) {
		return context.getExternalContext().getSessionMap().get(key);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setSessionMapValue(FacesContext context, String key,
			Object value) {
		context.getExternalContext().getSessionMap().put(key, value);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param context
	 * @param key
	 * @return
	 */
	public static Object removeSessionMapValue(FacesContext context, String key) {
		return context.getExternalContext().getSessionMap().remove(key);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * 
	 * @param context
	 * @param beanName
	 */
	public static void resetManagedBean(FacesContext context, String beanName) {
		context.getExternalContext().getSessionMap().remove(beanName);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param value
	 * @return
	 */
	public static String getJsfEl(String value) {
		return "#{" + value + "}";
	}

	public static void addSuccessMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(final String beanName, final Class<T> clazz) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return (T) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, beanName);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 */
	public static void resetSession(FacesContext fCtx) {
		HttpSession session = (HttpSession) fCtx.getExternalContext()
				.getSession(false);
		session.invalidate();
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param key
	 * @return
	 */
	public static String getRequestParameter(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(key);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param requestParameterName
	 * @param converter
	 * @param component
	 * @return
	 */
	public static Object getObjectFromRequestParameter(
			String requestParameterName, Converter converter,
			UIComponent component) {
		String idUI = FacesHandler.getRequestParameter(requestParameterName);
		return converter.getAsObject(FacesContext.getCurrentInstance(),
				component, idUI);
	}

	/**
	 * @author Ing. Juan Israel Hernández García
	 * @param list
	 * @param attValue
	 * @param attLabel
	 * @return
	 */
	public static SelectItem[] toItems(List<?> list, String attValue,
			String attLabel) {
		SelectItem[] selects = new SelectItem[list.size()];
		for (int i = 0; i < list.size(); i++) {
			selects[i] = toItem(list.get(i), attValue, attLabel);
		}
		return selects;
	}

	public static SelectItem toItem(Object obj, String attValue, String attLabel) {
		try {
			return new SelectItem(PropertyUtils.getProperty(obj, attValue),
					PropertyUtils.getProperty(obj, attLabel).toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getBundleString(String key) {
		try {
			return ResourceBundle.getBundle("ResourceBundle").getString(key);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}


	public static void setSuccessFlag(boolean successFlag) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(ACTION_SUCCESS, successFlag);
	}

	public static void setCallbackParameter(String paramName, Object value) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(paramName, value);
	}

}
