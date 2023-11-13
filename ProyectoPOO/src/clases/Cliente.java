package clases;
import java.utils.Scanner;

public class Cliente extends Usuario{
    private String tarjeta_de_credito;
    Scanner sc = new Scanner(System.in);

    public ServicioTaxi Solicitar_taxi(String origen, String destino){
        System.out.println("Por favor ingrese el número de pasajeros para este viaje: ")
        int pasajeros = sc.nextInt();
        sc.nextLine();
        ServicioTaxi servicio_taxi = Servicio_taxi(String origen, String destino, int numero_pasajeros);
        System.out.println("Su taxi ha sido reservado.");
        return servicio_taxi;
    }

    public EntregaEncomienda EntregaEncomienda(String origen, String destino){
        System.out.println("Por favor ingrese el número de productos a enviar: ")
        int numero_productos = sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor ingrese el peso total del envio: ")
        double peso_total = sc.nextDouble();
        sc.nextLine();
        System.out.println("Por favor ingrese el tipo de encomienda a enviar (MEDICINA o DOCUMENTOS): ")
        String tipo = sc.nextLine();
        TipoEncomienda tipo_encomienda = TipoEncomienda.valueOf(tipo)
        EntregaEncomienda entrega_encomienda = Entrega_encomienda(String origen, String destino, int numero_de_productos, double peso_total, TipoEncomienda tipo_encomienda);
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