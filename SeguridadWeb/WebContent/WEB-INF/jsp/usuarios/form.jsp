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
            
            <form method="post" action="<c:out value="${pageContext.request.contextPath}"/>/usuarios/UsuarioRegistrarServlet" class="ligthform">
                <fieldset>
                    <legend>Registrar Usuario</legend>
                    
                    <label>Usuario</label>
                    <input type="text" name="usuario" size="20" maxlength="40" required="" placeholder="Ingrese usuario"/><br/>
                    
                    <label>Clave</label>
                    <input type="password" name="clave" size="20" maxlength="40" placeholder="Ingrese clave"/><br/>
                    
                    <label>Nombres</label>
                    <input type="text" name="nombres" size="40" maxlength="100" required="" placeholder="Ingrese nombres"/><br/>
                    
                    <label>Correo</label>
                    <input type="email" name="correo" size="40" maxlength="100" placeholder="Ingrese correo"/><br/>
                    
                    <label>Rol</label>
                    <select name="rol">
                    	<c:forEach items="${roles}" var="rol">
                    		<option value="<c:out value="${rol.id}"/>"><c:out value="${rol.nombre}"/></option>
                    	</c:forEach>
                    </select><br/>
                    
                    <input type="submit" value="Guardar"/>
                </fieldset>
            </form>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
