
package clases;

import proyecto.Sistema;
import java.util.ArrayList;
import enums.*;
import java.time.LocalDateTime;

public abstract class Servicio{
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected String identificador;
    
    public Servicio(String origen, String destino){
        ArrayList<Usuario> listaUsuarios = Sistema.listaUsuarios;
        for (Usuario u: listaUsuarios){
            if (u.getTipoDeUsuario().equals(TipoUsuario.R)){
                Conductor r = (Conductor) u;
                if (r.getEstado_conductor().equals(EstadoConductor.D)){
                    this.conductor = r;
                }
            }
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        String fechaActual = currentDateTime.toLocalDate().toString();
        String horaActual = currentDateTime.toLocalTime().toString();
        this.identificador = fechaActual + horaActual + conductor.getNombre();
        this.origen = origen;
        this.destino = destino;
        this.fecha = fechaActual;
        this.hora = horaActual;
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
