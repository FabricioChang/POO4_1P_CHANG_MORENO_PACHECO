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
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private Conductor conductor;
    private double valorPagar;
    private int identificador;
    
    public Servicio(Ruta ruta, String fecha, String hora, double valorPagar, int identificador){
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.valorPagar = valorPagar;
        this.identificador = identificador;
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

    public void setConductor(Conductor conductor){
        this.conductor = conductor;
    }

    public Conductor getConductor(){
        return conductor;
    }

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
                " - Origen: " + this.origen + " - Destino: " + this.destino + " - Fecha: " + this.fecha + " - Hora: " + this.hora + 
                " - Valor a Pagar: " + this.valorPagar);
    }
}
