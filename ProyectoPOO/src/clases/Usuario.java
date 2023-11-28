/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import enums.TipoUsuario;


/**
 *
 * @author Fchang
 */
public abstract class Usuario {
  protected String cedula;
  protected int edad;
  protected String nombre;
  protected String apellido;
  protected String user;
  protected String contrasena;
  protected String numero_celular;
  protected TipoUsuario tipoDeUsuario;

  public Usuario(String cedula, int edad, String nombre, String apellido, String user, String contrasena, String numero_celular, TipoUsuario tipoDeUsuario){
    this.cedula = cedula;
    this.edad = edad;
    this.nombre = nombre;
    this.apellido = apellido;
    this.user = user;
    this.contrasena = contrasena;
    this.numero_celular = numero_celular;
    this.tipoDeUsuario = tipoDeUsuario;
  }

  public abstract void Consultar_servicios();

  public String getCedula(){
    return cedula;
  }

  public void setCedula(String cedula){
    this.cedula = cedula;
  }
  
  public int getEdad(){
    return edad;
  }

  public void setEdad(int edad){
    this.edad = edad;
  }
  
  public String getNumeroCelular(){
    return numero_celular;
  }

  public void setNumeroCelular(String numero_celular){
    this.numero_celular = numero_celular;
  }
  
  public String getNombre(){
    return nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  
  public String getApellido(){
    return apellido;
  }

  public void setApellido(String apellido){
    this.apellido = apellido;
  }
  
  public String getUser(){
    return user;
  }

  public void setUser(String user){
    this.user = user;
  }
  
  public String getContrasena(){
    return contrasena;
  }

  public void setContraseña(String contrasena){
    this.contrasena = contrasena;
  }
  
  public TipoUsuario getTipoDeUsuario(){
    return tipoDeUsuario;
  }

  public void setTipoDeUsuario(TipoUsuario tipoDeUsuario){
    this.tipoDeUsuario = tipoDeUsuario;
  }
  
  @Override
  public String toString(){
    return("Nombre: " + this.nombre + " - Apellido: " + this.apellido + " - Usuario: " + this.user + " - Edad: " + this.edad + " - Cédula: " + this.cedula + " - Número celular: " + this.numero_celular + " - Tipo de Usuario: " + this.tipoDeUsuario);
  }
}
