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
            
            <div class="login-div">
            <form method="post" action="<c:out value="${pageContext.request.contextPath}"/>/seguridad/LoginServlet" class="ligthform">
            	<fieldset>
                    <legend>Ingreso al Sistema</legend>
                    
                    <input type="text" name="usuario" size="20" maxlength="40" required="required" placeholder="Ingrese usuario" autocomplete="off"/>
                    
                    <input type="password" name="clave" size="20" maxlength="40" placeholder="Ingrese clave"/>
                    
                    <input type="submit" value="Ingresar"/>
                </fieldset>
            </form>
            </div>
            
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
