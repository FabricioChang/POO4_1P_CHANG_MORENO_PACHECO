package clases;
import java.util.Scanner;
import enums.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Cliente extends Usuario{
    private String tarjeta_de_credito;
    public ArrayList<Servicio> listaServiciosSolicitados = new ArrayList<>();
    private static String path = "servicios.txt";
    
    public Cliente(String cedula, int edad, String nombre, String apellido, String user, String contrasena, String numero_celular, TipoUsuario tipo_de_usuario, String tarjeta_de_credito){
        super(cedula, edad, nombre, apellido, user, contrasena, numero_celular, tipo_de_usuario);
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public ServicioTaxi Solicitar_taxi(String origen, String destino){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el numero de pasajeros para este viaje: ");
        int pasajeros = sc.nextInt();
        sc.nextLine();
        ServicioTaxi servicio_taxi = new ServicioTaxi(origen, destino, pasajeros);
        System.out.println("Su taxi ha sido reservado.");
        return servicio_taxi;
    }

    public EntregaEncomienda EntregaEncomienda(String origen, String destino){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el numero de productos a enviar: ");
        int numero_productos = sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor ingrese el peso total en kg del envio: ");
        double peso_total = sc.nextDouble();
        sc.nextLine();
        System.out.println("Por favor ingrese el tipo de encomienda a enviar (MEDICINA o DOCUMENTOS): ");
        String tipo = sc.nextLine();
        TipoEncomienda tipo_encomienda = TipoEncomienda.valueOf(tipo);
        EntregaEncomienda entrega_encomienda = new EntregaEncomienda(origen, destino, numero_productos, peso_total, tipo_encomienda);
        System.out.println("Su entrega de encomienda ha sido reservada.");
        return entrega_encomienda;
    }

    public void Pagar_servicio(ServicioTaxi servicio, Cliente cliente){
        Scanner sc = new Scanner(System.in);
        String metodo = null;
        do {
            System.out.println("Ingrese un metodo de pago correcto: \n Efectivo(E) \n Tarjeta de Credito (TC)");
            metodo = sc.nextLine();
        } while (!(metodo.equals("TC") || metodo.equals("E")));
        switch(metodo){
            case "TC":
                double valor = servicio.calcularValorPagar(true);
                Pago pago = new Pago(servicio.getIdentificador(),MetodoPago.valueOf(metodo), cliente, servicio, valor);
                System.out.println("Pago exitoso, su identificador de pago es: " + pago.getnumIdentificadorPago());
                break;
            case "E":
                double valor_e = servicio.calcularValorPagar();
                Pago pago_e = new Pago(servicio.getIdentificador(),MetodoPago.valueOf(metodo), cliente, servicio, valor_e);
                System.out.println("Pago exitoso, su identificador de pago es: " + pago_e.getnumIdentificadorPago());
                break;
        }
    }

    public void Pagar_servicio(EntregaEncomienda servicio, Cliente cliente){
        Scanner sc = new Scanner(System.in);
        String metodo = null;
        do {
            System.out.println("Ingrese un metodo de pago correcto: \n Efectivo(E) \n Tarjeta de Credito (TC)");
            metodo = sc.nextLine();
        } while (!(metodo.equals("TC") || metodo.equals("E")));
        switch(metodo){
            case "TC":
                double valor = servicio.calcularValorPagar(true);
                Pago pago = new Pago(servicio.getIdentificador(),MetodoPago.valueOf(metodo), cliente, servicio, valor);
                System.out.println("Pago exitoso, su identificador de pago es: " + pago.getnumIdentificadorPago());
                break;
            case "E":
                double valor_e = servicio.calcularValorPagar();
                Pago pago_e = new Pago(servicio.getIdentificador(),MetodoPago.valueOf(metodo), cliente, servicio, valor_e);
                System.out.println("Pago exitoso, su identificador de pago es: " + pago_e.getnumIdentificadorPago());
                break;
        }
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
                if (values[2].equals(cedula)){
                    String tipo = values[1];
                    String cantidad = values[8];
                    String fecha = values[6];
                    String hora = values[7];
                    String origen = values[4];
                    String destino = values[5];
                    if(tipo.equals("E")){
                        String tipo_enc = values[9];
                        System.out.println("\n/*****************************/\nTipo: Encomienda\nTipo encomienda: " + tipo_enc + "\nCantidad: " + cantidad + "\nFecha: " + fecha + "\nHora: " + hora + "\nDesde: " + origen + "\nHasta: " + destino);
                    } else if (tipo.equals("T")){
                        System.out.println("\n/*****************************/\nTipo: Viaje\nCantidad: " + cantidad + "\nFecha: " + fecha + "\nHora: " + hora + "\nDesde: " + origen + "\nHasta: " + destino);
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
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