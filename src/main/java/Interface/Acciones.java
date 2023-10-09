package Interface;

import java.util.List;

import Modelo.Empleado;
/**
 * @author Raul Merecias Perez
 *  Fecha 06/10/2022
 * @version 1.0
 * 
 * Interface de las Acciones para crear la lista,agregar,actualizar y borrar usuarios
 */
public interface Acciones {
	  public List listar();
	    public boolean add(Empleado persona);    
	    public boolean editar(Empleado persona);
	    public boolean borrar(int id);

}
