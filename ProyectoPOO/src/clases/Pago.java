/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import enums.MetodoPago;
import clases.Cliente;
import clases.Servicio;
/**
 *
 * @author jlmor
 */
public class Pago {
    private int numIdentificadorPago;
    private String fechaPago;
    private String numIdentificadorServicio;
    private MetodoPago formaPago;
    private Cliente cliente;
    private Servicio servicio;
    private double valorPagar;
    
    public Pago (int numIdentificadorPago, String fechaPago, String numIdentificadorServicio,MetodoPago formaPago,Cliente cliente,Servicio servicio, double valorPagar){
        this.numIdentificadorPago=numIdentificadorPago;
        this.fechaPago=fechaPago;
        this.numIdentificadorServicio=numIdentificadorServicio;
        this.formaPago=formaPago;
        //this.cliente = cliente;
        //this.servicio=servicio;
        this.valorPagar=valorPagar;
    }
    
    public void Pago(String numIdentificadorPago,String fechaPago,String numIdentificadorServicio,MetodoPago formaPago,String cedulaCliente,double valorPagar){
        
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
        return numIdentificadorServicio;
    }
    public void setnumIdentificadorServicio(String numIdentificadorServicio){
        this.numIdentificadorServicio=numIdentificadorServicio;
    }
    public MetodoPago getformaPago(){
        return formaPago;
    }
    public void setformaPago(MetodoPago formaPago){
        this.formaPago=formaPago;
    }
    public Cliente getcliente(){
        return cliente;
    }
    public void setcliente(Cliente cliente){
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
   public String toString(){
    return("Identificador de pago: " + this.numIdentificadorPago + " - Fecha de pago: " + this.fechaPago + " - Identificador de servicio: " + this.numIdentificadorServicio + " - Forma de pago: " + this.formaPago + " - Cliente: " + this.cliente + " - Servicio: " + this.servicio + " - Valor a pagar: " + this.valorPagar);
  }
}

