/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioD;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Usuario;

/**
 *
 * @author deivy
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable{
    
    private UsuarioD dao;
    private Usuario usuario;
    
    //variables de logeo
    private String user;
    private String pass;
    private String block;
    
    public Login(){
        dao = new UsuarioD();
        usuario = new Usuario();
    }
    
    public void ingresar() throws Exception{
        try {
            usuario = dao.startSession(user, pass);
            if (usuario != null) {
                switch(usuario.getTipo()){
                    case "a":
                        setUsuario(usuario);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard/dashboard.xhtml");
                        break;
                    case "b":
                        setUsuario(usuario);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/index.html");
                        break;
                }
            }else{
                setPass(null);
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario/Contraseña incorrecto"));
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            throw e;
        }
    }

    public UsuarioD getDao() {
        return dao;
    }

    public void setDao(UsuarioD dao) {
        this.dao = dao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
}
