package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Raul Merecias Perez
 *  Fecha 06/10/2022
 * @version 1.0
 * 
 * Clase encargada de Crear la conexion a la base de datos
 */

public class Conn {
	
    private Connection conn;
    private Statement sentencia;
    private static Conn instancia;
    
    public Conn(){
        try{
        	 Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rinku_it?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","AL3030pc");
  
        	if(conn!=null){
                System.out.println("conexion");
 }
}catch(Exception e){
 System.err.println("Erroor");
}
}
    public Connection getConnection(){
        return conn;
    }
}

