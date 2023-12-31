package modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Interface.Acciones;
import Modelo.Empleado;
import config.Conn;
/**
 * 
 * En esta clase se implementan los metodos para: agregar usuarios, eliminar, actualizar y listar
 * @author Raul Merecias Perez
 *  @version 1.0
 * 
 **/
public class EmpleadoDAO implements Acciones{
	/**
	 * Instancias publicas que permiten crear la conexion a la base de datos.
	 * 
	 */
	Conn con= new Conn();
	Connection dataBase;
	PreparedStatement query;
	ResultSet hecho;
	Empleado persona=new Empleado();
	/**
	 * Metodo que devuelve una lista de objetos Empleados
	 */
@Override  
	    public List<Empleado> listar() {
	
	  ArrayList<Empleado>list=new ArrayList<>();
	        String sql="{CALL allEmpleados()}";
	    	// TODO Auto-generated method stub

	        try{
	            dataBase=con.getConnection();
	            query=dataBase.prepareStatement(sql);
	            hecho=query.executeQuery();
	            while(hecho.next()){
	                Empleado personas=new Empleado();
	                
	                personas.setHoras(hecho.getInt("HORAS"));
	                personas.setPagoxCarga(hecho.getInt("PAGOXENTREGA"));
	                personas.setMes(hecho.getString("MES"));
	                personas.setId(hecho.getInt("ID"));
	                personas.setHoras(hecho.getInt("HORAS"));
	                personas.setEntregas(hecho.getInt("ENTREGAS"));
	                personas.setSueldo(hecho.getFloat("SUELDO"));
	                personas.setBonos(hecho.getFloat("BONOS"));
	                personas.setIdEmpleado(hecho.getString("idEMPLEADOS"));
	                personas.setNombre(hecho.getString("NOMBRE"));
	                personas.setRol(hecho.getString("PUESTO"));
	                personas.setReten(hecho.getFloat("RETEN"));
	                personas.setVales(hecho.getFloat("VALES"));
	                list.add(personas);
	            }
	            }catch(Exception e){
	                    System.out.println("error");
	                    }
	        
	                return list;
	    }
/**
 *Metodos que agrega un Empleado a la base de datos mediante un procesamiento almacenado 
 */
@Override

public boolean add(Empleado persona) {

	// TODO Auto-generated method stub

	 try {
        dataBase=con.getConnection();
        query=dataBase.prepareCall("{call nuevoRegistro(?, ?, ?)}");
	    
        query.setString(1, persona.getIdEmpleado());
        query.setString(2, persona.getNombre());
        query.setString(3, persona.getRol());
        query.execute();
        query.close();
	 }catch(Exception e) {
         System.err.println("error"+e);

	 }
	return false;
}

/**
 * Metodos para capturar horas por mes, entregas, horas extras y Rol mediante el ID utilizando un procesamiento almacenado
 */
@Override

public boolean editar(Empleado persona) {
	
	// TODO Auto-generated method stub
	 try {
        dataBase=con.getConnection();
        query=dataBase.prepareCall("{call capturaNomina(?, ?, ?, ?, ?)}");
        query.setString(1, persona.getMes());
        query.setInt(2, persona.getEntregas());
        query.setInt(3, persona.getId());
        query.setString(4, persona.getRol());
        query.setInt(5, persona.getHrExtra());
        query.execute();
        query.close();
         
	 }catch(Exception e) {
         System.err.println("error"+e);

	 }
	return false;
}


/**
 * Metodo para eliminar un empleado del sistema mediante el numero de empleado.
 */
@Override


public boolean borrar(int id) {

	// TODO Auto-generated method stub
	String sql="DELETE from rinku_it.empleados where ID="+id;
	try {
		dataBase=con.getConnection();
        query=dataBase.prepareStatement(sql);
        query.executeUpdate(sql);
	}catch(Exception e) {
        System.err.println("error"+e);

	 }
	return false;
}

	

}
