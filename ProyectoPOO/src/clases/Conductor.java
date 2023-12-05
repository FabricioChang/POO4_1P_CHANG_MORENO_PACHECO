package clases;
import enums.EstadoConductor;
import enums.TipoUsuario;
import proyecto.Sistema;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Conductor extends Usuario{
    private String numero_licencia;
    private EstadoConductor estado_conductor;
    private Vehiculo vehiculo;
    private static String path = "servicios.txt";

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
    public void Consultar_servicios(){
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] values = line.split(",");
                if (values[0].equals(user)){
                    String tipo = values[1];
                    String cantidad = values[8];
                    String fecha = values[6];
                    String hora = values[7];
                    String origen = values[4];
                    String destino = values[5];
                    if(tipo.equals("E")){
                        String tipo_enc = values[9];
                        System.out.println("\n/*****************************/\nTipo: Entrega Encomienda\nTipo encomienda: " + tipo_enc + "\nCantidad: " + cantidad + "\nFecha: " + fecha + "\nHora: " + hora + "\nDesde: " + origen + "\nHasta: " + destino);
                    } else if (tipo.equals("T")){
                        System.out.println("\n/*****************************/\nTipo: Servicio Taxi\nCantidad: " + cantidad + "\nFecha: " + fecha + "\nHora: " + hora + "\nDesde: " + origen + "\nHasta: " + destino);
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return super.toString() + " - Numero de licencia: " + numero_licencia + " - Estado del conductor: "+ estado_conductor + " - Vehiculo: " + vehiculo;
    }
}