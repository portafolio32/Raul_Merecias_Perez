package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Empleado;

import java.sql.*;

import config.Conn;
import modeloDAO.EmpleadoDAO;

/**
 * Servlet implementation class Controlador
 */

@WebServlet(description = "Logica de negocio", urlPatterns = { "/Controlador" })
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado persona= new Empleado();
	EmpleadoDAO EmpDAO= new EmpleadoDAO();
	String add="/index.jsp";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso="";
		acceso=add;
		
	String rol=request.getParameter("txtRol");

	String usr=request.getParameter("txtName");

	String id=request.getParameter("txtClave");
	
	persona.setRol(rol);
	persona.setIdEmpleado(id);
	persona.setNombre(usr);
	EmpDAO.add(persona);
	RequestDispatcher vista=request.getRequestDispatcher(acceso);
	vista.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
