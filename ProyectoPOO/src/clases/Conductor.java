package clases;

public class Conductor extends Usuario{
    private String numero_licencia;
    private EstadoConductor estado_conductor;
    private Vehiculo vehiculo;

    public void setNumero_licencia(String numero_licencia){
        this.numero_licencia = numero_licencia;
    }

    public String getNumero_licencia(){
        return numero_licencia;
    }

    public void setEstado_conductor(String estado_conductor){
        this.estado_conductor = estado_conductor;
    }

    public EstadoConductor getEstado_conductor(){
        return estado_conductor;
    }

    public void setVehiculo(String vehiculo){
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    @Override
    public String toString(){
        return super.toString() + " - Numero de licencia: " + numero_licencia + " - Estado del conductor: "+ estado_conductor + " - Vehiculo: " + vehiculo;
    }
}