package modeloDAO;

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

public class EmpleadoDAO implements Acciones{
	Conn con= new Conn();
	Connection dataBase;
	PreparedStatement query;
	ResultSet hecho;
	Empleado persona=new Empleado();
@Override  
	    public List<Empleado> listar() {
	        ArrayList<Empleado>list=new ArrayList<>();
	        String sql="select * from rinku_it.empleados";
	        try{
	            dataBase=con.getConnection();
	            query=dataBase.prepareStatement(sql);
	            hecho=query.executeQuery();
	            while(hecho.next()){
	                Empleado personas=new Empleado();
	                
	                personas.setMes(hecho.getString("MES"));
	                personas.setId(hecho.getInt("ID"));
	                personas.setHoras(hecho.getInt("HORAS"));
	                personas.setEntregas(hecho.getInt("ENTREGAS"));
	                personas.setSueldo(hecho.getFloat("SUELDO"));
	                personas.setBonos(hecho.getFloat("BONOS"));
	                personas.setIdEmpleado(hecho.getString("idEMPLEADOS"));
	                personas.setNombre(hecho.getString("NOMBRE"));
	                personas.setRol(hecho.getString("PUESTO"));
	                list.add(personas);
	            }
	            }catch(Exception e){
	                    System.out.println("error");
	                    }
	        
	                return list;
	    }
@Override
public Empleado lista(int id) {
	// TODO Auto-generated method stub
	
	return null;
}
@Override
public boolean add(Empleado persona) {
	

    String sql="INSERT INTO rinku_it.empleados(idEMPLEADOS,NOMBRE,PUESTO)values('"+persona.getIdEmpleado()+"','"+persona.getNombre()+"','"+persona.getRol()+"')";

	 try {
        dataBase=con.getConnection();
        query=dataBase.prepareStatement(sql);
        query.executeUpdate(sql);
         
	 }catch(Exception e) {
         System.err.println("error"+e);

	 }
	return false;
}
@Override
public boolean editar(Empleado persona) {
	// TODO Auto-generated method stub
	Double sueldo=5760.00;
	int   carga=persona.getEntregas();
	float bonoA=carga*10;
	float bonoB=carga*5;
	Double sueldoT=bonoA+sueldo;
	Double ISR=00.09;
	 String sql="UPDATE rinku_it.empleados SET MES='"+persona.getMes()+"',SUELDO='"+sueldo+"',HORAS='"+192+"',ENTREGAS='"+persona.getEntregas()+"',BONOS='"+bonoA+"' WHERE ID="+persona.getId();

	 try {
        dataBase=con.getConnection();
        query=dataBase.prepareStatement(sql);
        query.executeUpdate(sql);
         
	 }catch(Exception e) {
         System.err.println("error"+e);

	 }
	return false;
}
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
