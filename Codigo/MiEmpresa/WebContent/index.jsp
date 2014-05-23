<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	session.invalidate();
	session = request.getSession();
	response.sendRedirect(request.getContextPath()+"/security/login.jsf");
%>
