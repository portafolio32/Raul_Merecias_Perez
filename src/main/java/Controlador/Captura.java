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
 * Servlet implementation class Captura
 */
@WebServlet("/Captura")
public class Captura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado persona= new Empleado();
	EmpleadoDAO EmpDAO= new EmpleadoDAO();
	String add="/index.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Captura() {
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
	
   int carga=Integer.parseInt(request.getParameter("txtCarga"));
   int id=Integer.parseInt(request.getParameter("txtClave"));
	String mes=request.getParameter("select");
    
	persona.setEntregas(carga);
	persona.setId(id);
	persona.setMes(mes);
	EmpDAO.editar(persona);
	RequestDispatcher vista=request.getRequestDispatcher(acceso);
	vista.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}