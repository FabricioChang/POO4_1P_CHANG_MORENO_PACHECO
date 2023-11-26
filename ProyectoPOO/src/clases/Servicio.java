
package clases;

import java.util.Random;

public abstract class Servicio {
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected String identificador;
    
    public Servicio(String identificador, Conductor conductor, String origen, String destino, String fecha, String hora){
        this.identificador = identificador;
        this.conductor = conductor;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
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
        this.destino = destino;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public abstract double calcularValorPagar();
 
    
    @Override
    public String toString() {
    return  "Fecha: " + fecha +
            "\nHora: " + hora +
            "\nDesde: " + origen + 
            "\nHasta: " + destino;       
            
}
}
