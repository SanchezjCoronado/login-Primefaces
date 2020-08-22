/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

/**
 *
 * @author deivy
 */
public class UsuarioD extends Conexion{
    
    public Usuario startSession(String User, String Pass) throws Exception {
        try {
            Usuario usu = null;
            ResultSet rs;
            String sql = "Select Codigo,Nombre,Apellido,DNI,Celular from Usuario where Usuario like ? and Password like ?";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usu = new Usuario();
                usu.setCodigo(rs.getInt("Codigo"));
                usu.setNombre(rs.getString("Nombre"));
                usu.setApellido(rs.getString("Apellido"));
                usu.setDNI(rs.getString("DNI"));
                usu.setCelular(rs.getString("Celular"));
                usu.setTipo(rs.getString("Tipo"));
                usu.setUsuario(User);
                usu.setPassword(Pass);
            }
            return usu;
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
}
