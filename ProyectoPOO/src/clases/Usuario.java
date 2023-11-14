/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import enums.TipoUsuario;

/**
 *
 * @author CltControl
 */
public class Usuario {
  private int cedula;
  private int edad;
  private String nombre;
  private String apellido;
  private String user;
  private String contrasena;
  private int numero_celular;
  private TipoUsuario tipo_de_usuario;

  public Usuario(int cedula, int edad, String nombre, String apellido, String user, String contrasena, int numero_celular, TipoUsuario tipo_de_usuario){
    this.cedula = cedula;
    this.edad = edad;
    this.nombre = nombre;
    this.apellido = apellido;
    this.user = user;
    this.contrasena = contrasena;
    this.numero_celular = numero_celular;
    this.tipo_de_usuario = tipo_de_usuario;
  }

  public void Consultar_servicios(){
    
  }

  public int getCedula(){
    return cedula;
  }

  public void setCedula(int cedula){
    this.cedula = cedula;
  }
  
  public int getEdad(){
    return edad;
  }

  public void setEdad(int edad){
    this.edad = edad;
  }
  
  public int getNumeroCelular(){
    return numero_celular;
  }

  public void setNumeroCelular(int numero_celular){
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
    return tipo_de_usuario;
  }

  public void setTipoDeUsuario(TipoUsuario tipo_de_usuario){
    this.tipo_de_usuario = tipo_de_usuario;
  }

  public String toString(){
    return("Nombre: " + this.nombre + " - Apellido: " + this.apellido + " - Usuario: " + this.user + " - Edad: " + this.edad + " - Cédula: " + this.cedula + " - Número celular: " + this.numero_celular + " - Tipo de Usuario: " + this.tipo_de_usuario);
  }
}
