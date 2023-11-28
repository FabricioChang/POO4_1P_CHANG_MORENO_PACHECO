package clases;
import java.util.Scanner;
import enums.*;
import java.util.ArrayList;

public class Cliente extends Usuario{
    private String tarjeta_de_credito;
    private ArrayList<Servicio> listaServiciosSolicitados = new ArrayList<>();
    
    public Cliente(String cedula, int edad, String nombre, String apellido, String user, String contrasena, String numero_celular, TipoUsuario tipo_de_usuario, String tarjeta_de_credito){
        super(cedula, edad, nombre, apellido, user, contrasena, numero_celular, tipo_de_usuario);
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public ServicioTaxi Solicitar_taxi(String origen, String destino){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el número de pasajeros para este viaje: ");
        int pasajeros = sc.nextInt();
        sc.nextLine();
        ServicioTaxi servicio_taxi = new ServicioTaxi(origen, destino, pasajeros);
        listaServiciosSolicitados.add(servicio_taxi);
        System.out.println("Su taxi ha sido reservado.");
        sc.close();
        return servicio_taxi;
    }

    public EntregaEncomienda EntregaEncomienda(String origen, String destino){
        Scanner sc = new Scanner(System.in);
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
        listaServiciosSolicitados.add(entrega_encomienda);
        System.out.println("Su entrega de encomienda ha sido reservada.");
        sc.close();
        return entrega_encomienda;
    }

    public void Pagar_servicio(Servicio servicio, Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su metodo de pago: \n Efectivo(E) \n Tarjeta de Credito (TC)");
        String metodo = sc.nextLine();
        Pago pago = new Pago(servicio.getIdentificador(),MetodoPago.valueOf(metodo), cliente, servicio, servicio.calcularValorPagar());
        System.out.println("Pago exitoso, su identificador de pago es: " + pago.getnumIdentificadorPago());
        sc.close();
    }

    @Override
    public void Consultar_servicios(){
        for (Servicio s: listaServiciosSolicitados){
            System.out.println(s);
        }
    }

    public void setTarjeta_de_credito(String tarjeta_de_credito){
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public String getTarjeta_de_credito(){
        return tarjeta_de_credito;
    }

    public void setListaServiciosSolicitados(ArrayList<Servicio> lista){
        this.listaServiciosSolicitados = lista;
    }

    public ArrayList<Servicio> getListaServiciosSolicitados(){
        return listaServiciosSolicitados;
    }

    @Override
    public String toString(){
        return super.toString() + " - Tarjeta de credito: " + tarjeta_de_credito;
    }
    
}