package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Empleado;
import modeloDAO.EmpleadoDAO;

/**
 * @author Raul Merecias Perez
 *  Fecha 06/10/2022
 * @version 1.0
 * 
 * Controlador encargado de mostrar la vista despues de eliminar un usuario del sistema
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado persona= new Empleado();
	EmpleadoDAO EmpDAO= new EmpleadoDAO();
	String add="/index.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
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

	
	int id=Integer.parseInt(request.getParameter("id"));
	persona.setId(id);
	EmpDAO.borrar(id);
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
