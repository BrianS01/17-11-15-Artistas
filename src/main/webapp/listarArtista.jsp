<!-- 
 *      Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
-->
<%@page import="modelo.Artista"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Users</title>
    </head>
    <body>
        <table border=1>
            <thead>
                <tr>
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Obra</th>
                    <th>Estilo</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Artista> users = (List<Artista>) request.getAttribute("artista");
                    if (users != null)
                    {
                        for (Artista user : users)
                        {
                %>
                <tr>
                    <td><%=user.getCedula()%></td>
                    <td><%=user.getNombre()%></td>
                    <td><%=user.getEdad()%></td>
                    <td><%=user.getObra()%></td>
                    <td><%=user.getEstilo()%></td>
                    <td><a href="ArtistaControlador?action=edit&userId=<%=user.getCedula()%>">Update</a></td>
                    <td><a href="ArtistaControlador?action=delete&userId=<%=user.getCedula()%>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <p><a href="ArtistaControlador?action=insert">Agregar User</a></p>
    </body>
</html>