package Interface;

import java.util.List;

import Modelo.Empleado;

public interface Acciones {
	  public List listar();
	    public Empleado lista(int id);
	    public boolean add(Empleado persona);    
	    public boolean editar(Empleado persona);
	    public boolean borrar(int id);

}
