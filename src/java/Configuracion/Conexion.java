
package Configuracion;

import java.sql.*;

public class Conexion {
    
    Connection con;
      
    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionmatriculas","root","");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base en: "+e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}

