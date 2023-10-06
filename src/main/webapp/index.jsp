<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BIENVENIDO</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.1/css/all.css'><link rel="stylesheet" href="./style.css">

</head>
<style>
	.panel-control {
  position:absolute;
  opacity:0;
}
.tab-group label {
  display:inline-block;
  padding: 10px 30px;
  border:1px solid #ccc;
  border-bottom:none;
  background-color: #ccc;
  bottom:-1px;
  position:relative;
}
.content-group {
  border:1px solid #ccc;
  padding: 20px;
}
.content{display:none;}
/* .content1{display:block;} */
/* .tab-group .active {
  position:relative;
  background-color: #fff;
} */

#radio1:checked ~ .tab-group [for="radio1"],
#radio2:checked ~ .tab-group [for="radio2"],
#radio3:checked ~ .tab-group [for="radio3"]{background-color: #fff;}

/* #radio2:checked~ .content-group .content1{display:none}
#radio3:checked~ .content-group .content1{display:none} */

#radio1:checked ~ .content-group .content1,
#radio2:checked ~ .content-group .content2,
#radio3:checked ~ .content-group .content3 {display:block}

</style>
<body>
<div class="panel-group">
  <input type="radio" name="panel-radio" id="radio1" class="panel-control" checked>
  <input type="radio" name="panel-radio" id="radio2" class="panel-control">
  <input type="radio" name="panel-radio" id="radio3" class="panel-control">
  <div class="tab-group">
    <label for="radio1" class="active">Nuevo Empleado</label>
    <label for="radio2">Lista de Nomina</label>
    <label for="radio3">Captura de horas</label>
  </div>
  <div class="content-group">
    <div class="content content1">
 <div  class="container p-3 my-3 bg-primary text-white">
        <form  action="Controlador"  class="form-group">
			   <label for="usr">Name:</label>

      <div class="input-group-prepend">
    <div class="input-group-text">
            <input   type="text" name="txtName"  />
        
   </div>   
    </div>
      <label for="usr">No.Empleado:</label>

      <div class="input-group-prepend">
    <div class="input-group-text">
            <input   type="text" name="txtClave" />
            </div>         
             </div>
            <div  class="form-group form-check">
	<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Chofer">Chofer
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Cargador">Cargador
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Auxiliar" >Auxiliar
  </label>
</div>
            <button type="submit"  >Guardar</button>
            <button type="submit"  >Cancelar</button>
            
        </form>
        </div> <! – panel –>,
     </div> <! – contendor 1 –>,
   </div> <! – contenedor grup –>,
   <div class="content content2">
   <%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.Empleado"%>
<%@page import="modeloDAO.EmpleadoDAO"%>
<%@page import="modeloDAO.EmpleadoDAO"%>
<div class="container">
  <h2>NOMINA</h2>
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
                     <a href="http://localhost:8080/RINKU_IT/Eliminar?Accion&id=<%=persona.getId() %>">Eliminar </a>
                 </td>
             </tr>
         </tbody>
         <% } %>
  </table>
</div>
   
   </div>
   <div class="content content3"> <div  class="container p-3 my-3 bg-primary text-white">
        <form  action="Captura"  class="form-group">
        
			   <label for="usr">Name:</label>

      <div class="input-group-prepend">
    <div class="input-group-text">
            <input   type="text" name="txtName"  />
        
   </div>   
    </div>
      <label for="usr">No.Empleado:</label>

      <div class="input-group-prepend">
    <div class="input-group-text">
            <input   type="text" name="txtClave" />
            </div>         
             </div>
       <label for="usr">Cantidad de Entregas:</label>

      <div class="input-group-prepend">
    <div class="input-group-text">
            <input   type="text" name="txtCarga"  />
            </div>         
             </div>
            <div  class="form-group form-check">
	<div class="form-check">
	  <div  class="form-group form-check">
	<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Chofer">Chofer
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Cargador">Cargador
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input"  name="txtRol" value="Auxiliar" >Auxiliar
  </label>
</div>
       
 <form action="Captura">
    <div class="form-group">
      <label for="sel">Select list (select one):</label>
      <select class="form-control" id="sele" name="select">
        <option name="" value="">Clic seleciona mes</option>
                <option name="ene" value="Enero">Enero</option>
                <option name="feb" value="Febrero">Febrero</option>
                <option name="mar" value="Marzo">Marzo</option>
                <option name="abr" value="Abril">Abril</option>
                <option name="ene" value="Enero">Mayo</option>
                <option name="feb" value="Febrero">Junio</option>
                <option name="mar" value="Marzo">Julio</option>
                <option name="abr" value="Abril">Agosto</option>
                <option name="ene" value="Enero">Septiembre</option>
                <option name="feb" value="Febrero">Octubre</option>
                <option name="mar" value="Marzo">Noviembre</option>
                <option name="abr" value="Abril">Diciembre</option>
      </select>
      </select>
</div>
            <button type="submit"  >Guardar</button>
            <button type="submit"  >Cancelar</button>
            
        </form>
        </div> <! – panel –>,</div>
 </div> <! – grupo de paneles –>,
</body>
</html>