<%@page import="edu.tecsup.seguridad.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="<c:out value="${pageContext.request.contextPath}"/>/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div id="content">
        
<%--         	<c:set var="nombre" value="pepe"></c:set> --%>
<%--         	<c:choose> --%>
<%--         		<c:when test="${nombre=='pepe'}">Eres Pepe</c:when> --%>
<%--         		<c:when test="${nombre=='juan'}">Eres Juan</c:when> --%>
<%--         		<c:otherwise>No te conozco </c:otherwise> --%>
<%--         	</c:choose> --%>
        
        	<h2>Mantenimiento de Usuarios</h2>
        
	        <c:choose>
	        	<c:when test="${fn:length(usuarios) == 0}">
	        	
	        		<div class="flash-message">Registros no encontrados</div>
	        		
	        	</c:when>
	        	<c:otherwise>
	        	
	        		<table border="1" class="gridtable">
		                <thead>
		                    <tr>
		                        <th>ID</th>
		                        <th>USUARIO</th>
		                        <th>NOMBRES</th>
		                        <th>ROL</th>
		                        <th>CORREO</th>
		                        <th>&nbsp;</th>
		                        <th>&nbsp;</th>
		                    </tr>
		                </thead>
		                <tbody>
		                
		                	<c:forEach items="${usuarios}" var="usuario">
		                    <tr>
		                        <td><c:out value="${usuario.id}"></c:out></td>
		                        <td><c:out value="${usuario.usuario}"></c:out></td>
		                        <td><c:out value="${usuario.nombres}"></c:out></td>
		                        <td><c:out value="${usuario.rol.nombre}"></c:out></td>
		                        <td><c:out value="${usuario.correo}"></c:out></td>
		                        <td><a href="<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioEditarServlet?id=<c:out value="${usuario.id}"></c:out>">Editar</a></td>
		                        <td><a href="javascript:void();" onclick="if(window.confirm('¿Esta seguro?'))window.location='<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioEliminarServlet?id=<c:out value="${usuario.id}"></c:out>'">Eliminar</a></td>
		                    </tr>
		                	</c:forEach>
		                    
		                </tbody>
		            </table>
		            
	        	</c:otherwise>
	        </c:choose>
            
            <br/>
            <a href="<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioFormServlet" class="button">Registro</a>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
