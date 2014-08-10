<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
	<div id="header">
	    <img src="<%=request.getContextPath()%>/logo.png" height="60"/>
	    <c:if test="${usuario!=null}">
	    	<div class="welcome">Bienvenido: <c:out value="${usuario.nombres}"/></div>
	    </c:if>
	</div>
	<c:if test="${usuario!=null}">
	<div id="menu">
	    <ul>
	        <li><a href="<c:out value="${pageContext.request.contextPath}"/>/HomeServlet">Inicio</a></li>
	        <li><a href="<c:out value="${pageContext.request.contextPath}"/>/roles/RolListarServlet">Roles</a></li>
	        <li><a href="<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioListarServlet">Usuarios</a></li>
	        <c:if test="${usuario!=null}">
	        	<li><a href="<c:out value="${pageContext.request.contextPath}"/>/seguridad/LogoutServlet">Salir</a></li>
	        </c:if>
	    </ul>
	</div>
	</c:if>