package clases;
import java.util.Scanner;
import enums.*;

public class Cliente extends Usuario{
    private String tarjeta_de_credito;
    Scanner sc = new Scanner(System.in);
    
    public Cliente(String cedula, int edad, String nombre, String apellido, String user, String contrasena, String numero_celular, TipoUsuario tipo_de_usuario, String tarjeta_de_credito){
        super(cedula, edad, nombre, apellido, user, contrasena, numero_celular, tipo_de_usuario);
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public ServicioTaxi Solicitar_taxi(String origen, String destino){
        System.out.println("Por favor ingrese el número de pasajeros para este viaje: ");
        int pasajeros = sc.nextInt();
        sc.nextLine();
        ServicioTaxi servicio_taxi = new ServicioTaxi(origen, destino, pasajeros);
        System.out.println("Su taxi ha sido reservado.");
        return servicio_taxi;
    }

    public EntregaEncomienda EntregaEncomienda(String origen, String destino){
        System.out.println("Por favor ingrese el número de productos a enviar: ");
        int numero_productos = sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor ingrese el peso total del envio: ");
        double peso_total = sc.nextDouble();
        sc.nextLine();
        System.out.println("Por favor ingrese el tipo de encomienda a enviar (MEDICINA o DOCUMENTOS): ");
        String tipo = sc.nextLine();
        TipoEncomienda tipo_encomienda = TipoEncomienda.valueOf(tipo);
        EntregaEncomienda entrega_encomienda = new EntregaEncomienda(origen, destino, numero_productos, peso_total, tipo_encomienda);
        System.out.println("Su entrega de encomienda ha sido reservada.");
        return entrega_encomienda;
    }

    public void Pagar_servicio(){
        
    }

    public void setTarjeta_de_credito(String tarjeta_de_credito){
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public String getTarjeta_de_credito(){
        return tarjeta_de_credito;
    }

    @Override
    public String toString(){
        return super.toString() + " - Tarjeta de credito: " + tarjeta_de_credito;
    }
}