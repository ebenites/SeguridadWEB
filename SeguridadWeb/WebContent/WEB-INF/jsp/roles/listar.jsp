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
        
        	<h2>Mantenimiento de Roles</h2>
        
	        <c:choose>
	        	<c:when test="${fn:length(roles) == 0}">
	        	
	        		<div class="flash-message">Registros no encontrados</div>
	        		
	        	</c:when>
	        	<c:otherwise>
	        	
	        		<table border="1" class="gridtable">
		                <thead>
		                    <tr>
		                        <th>ID</th>
		                        <th>NOMBRE</th>
		                        <th>&nbsp;</th>
		                        <th>&nbsp;</th>
		                    </tr>
		                </thead>
		                <tbody>
		                
		                	<c:forEach items="${roles}" var="rol">
		                    <tr>
		                        <td><c:out value="${rol.id}"></c:out></td>
		                        <td><c:out value="${rol.nombre}"></c:out></td>
		                        <td><a href="<c:out value="${pageContext.request.contextPath}"/>/roles/RolEditarServlet?id=<c:out value="${rol.id}"></c:out>">Editar</a></td>
		                        <td><a href="javascript:void();" onclick="if(window.confirm('¿Esta seguro?'))window.location='<c:out value="${pageContext.request.contextPath}"/>/roles/RolEliminarServlet?id=<c:out value="${rol.id}"></c:out>'">Eliminar</a></td>
		                    </tr>
		                	</c:forEach>
		                    
		                </tbody>
		            </table>
		            
	        	</c:otherwise>
	        </c:choose>
            
            <br/>
            <a href="<c:out value="${pageContext.request.contextPath}"/>/roles/RolFormServlet" class="button">Registro</a>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
