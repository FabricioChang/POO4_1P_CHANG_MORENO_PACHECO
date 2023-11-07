/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author jlmor
 */
public class Ruta {
    private String origen;
    private String destino;
    

public Ruta(String origen, String destino){
    this.origen=origen;
    this.destino=destino;
    }

public String getOrigen(){
    return origen;
    }

public void setOrigen(String origen){
    this.origen = origen;
}

public String getDestino(){
    return destino;
}
public void setDestino(String destino){
    this.destino=destino;
}

public void ruta(String origen,String destino){
    
}

@Override
public String toString(){
    return("Origen: " + this.origen + " - Destino: " + this.destino );
  }
}