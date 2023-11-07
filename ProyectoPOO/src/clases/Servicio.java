/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author josue:)
 */
public class Servicio {
    private Ruta ruta;
    private String fecha;
    private String hora;
    //private Conductor conductor; Aun no esta creada la clase conductor
    private double valorPagar;
    private int identificador;
    
    public Servicio(Ruta ruta, String fecha, String hora, double valorPagar, int identificador){
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.valorPagar = valorPagar;
        this.identificador = identificador;
    }
    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
    public Ruta getRuta(){
        return ruta;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getFecha(){
        return fecha;
    }
    public void setHora(String hora){
        this.hora = hora;
    }
    public String getHora(){
        return hora;
    }
    //public void setConductor(Conductor conductor){
    //    this.conductor = conductor;
    //}
    //public Conductor getConductor(){
    //    return conductor;
    //}
    public void setValorPagar(double valorPagar){
        this.valorPagar = valorPagar;
    }
    public double getValorPagar(){
        return valorPagar;
    }
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }
    public int getIdentificador(){
        return identificador;
    }
    @Override
    public String toString(){
        return("Identificador: " + this.identificador + 
                " - Ruta: " + this.ruta + " - Fecha: " + this.fecha + " - Hora: " + this.hora + 
                " - Valor a Pagar: " + this.valorPagar);
    }
}
