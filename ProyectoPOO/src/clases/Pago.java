/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import enums.MetodoPago;
import java.time.LocalDateTime;

/**
 *
 * @author jlmor
 */
public class Pago {
    private int numIdentificadorPago;
    private String fechaPago;
    private String IdentificadorServicio;
    private MetodoPago formaPago;
    private Cliente cliente;
    private Servicio servicio;
    private double valorPagar;
    private static int counter = 0;
    
    public Pago (String IdentificadorServicio,MetodoPago formaPago,Cliente cliente,Servicio servicio, double valorPagar){
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.numIdentificadorPago= ++counter;
        this.fechaPago= currentDateTime.toLocalDate().toString();
        this.IdentificadorServicio=IdentificadorServicio;
        this.formaPago=formaPago;
        this.cliente = cliente;
        this.servicio=servicio;
        this.valorPagar=valorPagar;
    }
    
    public int getnumIdentificadorPago(){
        return numIdentificadorPago;
    }
    public void setnumIdentificadorPago(int numIdentificadorPago){
        this.numIdentificadorPago=numIdentificadorPago;
    }
    public String getfechaPago(){
        return fechaPago;
    }
    public void setfechaPago(String fechaPago){
        this.fechaPago=fechaPago;
    }
    public String getnumIdentificadorServicio(){
        return IdentificadorServicio;
    }
    public void setnumIdentificadorServicio(String numIdentificadorServicio){
        this.IdentificadorServicio=numIdentificadorServicio;
    }
    public MetodoPago getformaPago(){
        return formaPago;
    }
    public void setformaPago(MetodoPago formaPago){
        this.formaPago=formaPago;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public Servicio getservicio(){
        return servicio;
    }
    public void setservicio(Servicio servicio){
        this.servicio=servicio;
    }
   public double getvalorPagar(){
       return valorPagar;
   }
   public void setvalorPagar(double valorPagar){
       this.valorPagar=valorPagar;
   }
   
   @Override
   public String toString(){
    return("Identificador de pago: " + this.numIdentificadorPago + " - Fecha de pago: " + this.fechaPago + " - Identificador de servicio: " + this.IdentificadorServicio + " - Forma de pago: " + this.formaPago + " - Cliente: " + this.cliente + " - Servicio: " + this.servicio + " - Valor a pagar: " + this.valorPagar);
  }
}

