
package clases;

import proyecto.Sistema;
import java.util.ArrayList;
import java.util.Scanner;

import enums.*;
import java.time.LocalDateTime;

public abstract class Servicio{
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected String identificador;

    public Servicio(String origen, String destino) {
        ArrayList<Usuario> listaUsuarios = Sistema.listaUsuarios;
        for (Usuario u : listaUsuarios) {
            if (u.getTipoDeUsuario().equals(TipoUsuario.valueOf("R"))) {
                Conductor r = (Conductor) u;
                if (r.getEstado_conductor().equals(EstadoConductor.D)) {
                    this.conductor = r;
                    r.setEstado_conductor(EstadoConductor.O);
                    break;
                }
            }
        }
        System.out.println("Desea el servicio en este momento? \n 1. Si \n 2. No");
        Scanner entrada = new Scanner(System.in);
        int decision = entrada.nextInt();
        entrada.nextLine();
        if (decision == 1) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            String fechaActual = currentDateTime.toLocalDate().toString();
            String horaActual = currentDateTime.toLocalTime().toString();
            this.identificador = fechaActual + horaActual + conductor.getNombre();
            this.origen = origen;
            this.destino = destino;
            this.fecha = fechaActual;
            this.hora = horaActual;
        } else {

            try {
                System.out.print("Ingrese la fecha del servicio en el formato (Y-M-D): ");
                String fecha_post = entrada.nextLine();
                String[] fechalist = fecha_post.split("-");

                System.out.print("Ingrese la hora del servicio en el formato (H:M:S): ");
                String hora_post = entrada.nextLine();
                String[] horalist = hora_post.split(":");

                if (fechalist.length == 3 && horalist.length == 3) {
                    LocalDateTime futureDateTime = LocalDateTime.of(
                            Integer.parseInt(fechalist[0]),
                            Integer.parseInt(fechalist[1]),
                            Integer.parseInt(fechalist[2]),
                            Integer.parseInt(horalist[0]),
                            Integer.parseInt(horalist[1]),
                            Integer.parseInt(horalist[2]));

                    String fechaPosterior = futureDateTime.toLocalDate().toString();
                    String horaPosterior = futureDateTime.toLocalTime().toString();

                    this.identificador = fechaPosterior + horaPosterior + conductor.getNombre();
                    this.origen = origen;
                    this.destino = destino;
                    this.fecha = fechaPosterior;
                    this.hora = horaPosterior;
                } else {
                    System.out.println("Formato de fecha o hora incorrecto. Asegúrese de ingresar correctamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error.Asegurese de ingresar números válidos.");

            }

        }

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
