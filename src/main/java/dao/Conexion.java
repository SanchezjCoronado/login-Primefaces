/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deivy
 */
public class Conexion {
    private Connection cn;

    public Connection conectar() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://server-deivy.database.windows.net:1433;database=deivy-db;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
                    + "user=deivy;password=Jampool123");
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return cn;
    }
    
    public void cerrar() throws SQLException{
        if(cn != null){
            cn.close();
        }
    }
    
    public static void main(String[] args) throws Exception {
        Conexion cnx = new Conexion();
        cnx.conectar();
        if (cnx != null) {
            System.out.println("Conectado");
        }else{
            System.out.println("Cerrado");
        }
    }
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    
}
