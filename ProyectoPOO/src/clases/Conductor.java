package clases;
import enums.EstadoConductor;
import enums.TipoUsuario;

public class Conductor extends Usuario{
    private String numero_licencia;
    private EstadoConductor estado_conductor;
    private Vehiculo vehiculo;

    public Conductor(String numero_licencia, String estado_conductor, Vehiculo vehiculo, String cedula, int edad, String nombre, String apellido, String user, String contrasena, String numero_celular, TipoUsuario tipo_de_usuario) {
        super(cedula, edad, nombre, apellido, user, contrasena, numero_celular, tipo_de_usuario);
        this.numero_licencia = numero_licencia;
        this.estado_conductor = EstadoConductor.valueOf(estado_conductor);
        this.vehiculo = vehiculo;
    }
    
    
    public void setNumero_licencia(String numero_licencia){
        this.numero_licencia = numero_licencia;
    }

    public String getNumero_licencia(){
        return numero_licencia;
    }

    public void setEstado_conductor(EstadoConductor estado_conductor){
        this.estado_conductor = estado_conductor;
    }

    public EstadoConductor getEstado_conductor(){
        return estado_conductor;
    }

    public void setVehiculo(Vehiculo vehiculo){
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