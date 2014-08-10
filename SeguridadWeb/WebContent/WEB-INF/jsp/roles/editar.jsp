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
            
            <form method="post" action="<c:out value="${pageContext.request.contextPath}"/>/roles/RolActualizarServlet" class="ligthform">
                <fieldset>
                    <legend>Editar Rol</legend>
                    
                    <label>Nombre</label>
                    <input type="text" name="nombre" size="40" maxlength="100" required="required" placeholder="Ingrese nombre" value="<c:out value="${rol.nombre}"/>"/><br/>
                    
                    <input type="hidden" name="id" value="<c:out value="${rol.id}"/>">
                    
                    <input type="submit" value="Actualizar"/>
                </fieldset>
            </form>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
