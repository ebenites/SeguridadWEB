<%@page import="edu.tecsup.seguridad.model.Usuario"%>
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
            
            <form method="post" action="<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioActualizarServlet" class="ligthform">
                <fieldset>
                    <legend>Editar Usuario</legend>
                    
                    <label>Usuario</label>
                    <input type="text" name="usuario" size="20" maxlength="40" required="" placeholder="Ingrese usuario" value="<c:out value="${usuario.usuario}"/>"/><br/>
                    
                    <label>Clave</label>
                    <input type="password" name="clave" size="20" maxlength="40" placeholder="Ingrese clave" value=""/><br/>
                    
                    <label>Nombres</label>
                    <input type="text" name="nombres" size="40" maxlength="100" required="" placeholder="Ingrese nombres" value="<c:out value="${usuario.nombres}"/>"/><br/>
                    
                    <label>Correo</label>
                    <input type="email" name="correo" size="40" maxlength="100" placeholder="Ingrese correo"  value="<c:out value="${usuario.correo}"/>"/><br/>
                    
                    <label>Rol</label>
                    <select name="rol">
                    	<c:forEach items="${roles}" var="rol">
                    		<option value="<c:out value="${rol.id}"/>"
	                    		<c:if test="${usuario.rol.id == rol.id}">
		                    		selected="selected"
		                    	</c:if>
                    		><c:out value="${rol.nombre}"/></option>
                    	</c:forEach>
                    	
                    </select><br/>
                    
                    <input type="hidden" name="id" value="<c:out value="${usuario.id}"/>">
                    
                    <input type="submit" value="Actualizar"/>
                </fieldset>
            </form>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
