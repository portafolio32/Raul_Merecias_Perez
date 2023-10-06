<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.Empleado"%>
<%@page import="modeloDAO.EmpleadoDAO"%>
<%@page import="modeloDAO.EmpleadoDAO"%>
<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>idEmpleado</th>
        <th>Nombre</th>
        <th>Puesto</th>
         <th>MES</th>
        <th>SUELDO</th>
        <th>HORAS</th>
         <th>ENTREGAS</th>
        <th>BONOS</th>
        <th>RETEN</th>
        <th>VALES</th>
                <th>Accion</th>
        
      </tr>
    </thead>
       <%
                 EmpleadoDAO dao=new EmpleadoDAO();
                 List<Empleado> list=dao.listar();
                 Iterator<Empleado>iter=list.iterator();
                 Empleado persona=null;
                 while(iter.hasNext()){
                 persona=iter.next();
                    
             
             %>
         <tbody>
             <tr>
                       <td><%=persona.getIdEmpleado() %></td>
                        <td><%=persona.getNombre() %></td>
                        <td><%=persona.getRol() %></td>
                          <td><%=persona.getMes() %></td>
                        <td><%=persona.getSueldo() %></td>
                       <td><%=persona.getHoras() %></td>
                          <td><%=persona.getEntregas() %></td>
                        <td><%=persona.getBonos() %></td>
                        <td><%=persona.getVales() %></td>
                        <td><%=persona.getReten() %></td>
                        
                 <td>
                     <a href="http://localhost:8080/RINKU_IT/view/registro.html">Agregar </a>
                     <a>Eliminar </a>
                 </td>
             </tr>
         </tbody>
         <% } %>
  </table>
</div>

</body>
</html>