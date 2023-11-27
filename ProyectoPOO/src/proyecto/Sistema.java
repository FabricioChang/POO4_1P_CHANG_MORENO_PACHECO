
package proyecto;
import java.util.ArrayList;

import clases.*;
import enums.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author CltControl
 */
public class Sistema {
   
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Servicio> listaServicios = new ArrayList<>();
    public static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static String path_usuarios = "ProyectoPOO/usuarios.txt";
    private static String path_vehiculos = "ProyectoPOO/vehiculos.txt";
    public static void main(String[] args) {
        File file_vehiculos = new File(path_vehiculos);
        try {
            Scanner sc = new Scanner(file_vehiculos);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");
                String placa = values[0];
                String modelo = values[1];
                String marca = values[2];
                String tipo = values[3];
                listaVehiculos.add(new Vehiculo(placa, modelo, marca, TipoVehiculo.valueOf(tipo)));
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA           ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        Usuario usuario = Iniciar_sesion();
        Mostar_menu(usuario);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   ADIOS                    ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
    }
        
        
    public static Usuario Iniciar_sesion(){
        Scanner entrada= new Scanner(System.in);
        boolean verificado = false;
        Usuario usuario = null;
        String user = null;
        String password = null;
        while (!verificado){
            System.out.print("Ingrese su usuario: ");
            user = entrada.nextLine();
            System.out.println();
            System.out.print("Ingrese su contraseña: ");
            password = entrada.nextLine();
            verificado = Verificar_usuario(user, password);
        }
        File file = new File(path_usuarios);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] values = linea.split(",");
                String cedula = values[0];
                int edad = Integer.parseInt(values[1]);
                String nombre = values[2];
                String apellido = values[3];
                String user_txt = values[4];
                String contrasena_user = values[5];
                String celular = values[6];
                String tipo_usuario = values[7];
                if (user.equals(user_txt)){
                    if (TipoUsuario.valueOf(tipo_usuario).equals(TipoUsuario.C)){
                        System.out.println("Por favor ingrese su tarjeta de credito para terminar el registro: ");
                        String tarjeta = entrada.nextLine();
                        usuario = new Cliente(cedula, edad, nombre, apellido, user, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario),tarjeta);
                        System.out.println("Usuario registrado.");
                        listaUsuarios.add(usuario);
                    } else {
                        System.out.println("Por favor ingrese su numero licencia: ");
                        String licencia = entrada.nextLine();
                        System.out.println("Por favor seleccione su vehiculo: ");
                        int counter = 1;
                        for (Vehiculo v: listaVehiculos){
                            System.out.println(counter +". " +v);
                            counter++;
                        }
                        int num_veh = entrada.nextInt();
                        Vehiculo vehiculo = listaVehiculos.get(num_veh -1);
                        usuario = new Conductor(licencia, "D", vehiculo, cedula, edad, nombre, apellido, user, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario));
                        System.out.println("Usuario registrado.");
                        listaUsuarios.add(usuario);
                    }
                    break;
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        entrada.close();
        return usuario;
    }

    public static boolean Verificar_usuario(String usuario, String contrasena) {
        boolean verificado = false;
        File file = new File(path_usuarios);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] values = linea.split(",");
                String user = values[4];
                String contrasena_user = values[5];
                if (user.equals(usuario) && contrasena_user.equals(contrasena)) {
                    System.out.println("Usuario y contraseña correctos");
                    verificado = true;
                    break;
                }
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!verificado){
            System.out.println("Usuario o contraseña incorrectos");
        }
        return verificado;
    }
       
      
    public static void Mostar_menu(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        System.out.println("/*****************MENU*******************/");
        System.out.println("/*                                      */");
        System.out.println("/****************************************/");
        System.out.println("Ingrese la opcion que desea realizar.");
        boolean correcto = false;
        int eleccion;
        boolean repetir = true;
        while (repetir){
            if (usuario.getTipoDeUsuario().equals(TipoUsuario.C)){
                System.out.println("1. Solicitar servicio de taxi.");
                System.out.println("2. Enviar una encomienda.");
                System.out.println("3. Consultar servicio.");
                System.out.println("4. Salir del sistema.");
                do {
                    eleccion = sc.nextInt();
                    sc.nextLine();
                    if (eleccion == 1 || eleccion == 2 || eleccion == 3 || eleccion == 4){
                        correcto = true;
                    } else{
                        System.out.println("Por favor ingrese una opcion correcta.");
                        System.out.println("1. Solicitar servicio de taxi.");
                        System.out.println("2. Enviar una encomienda.");
                        System.out.println("3. Consultar servicios.");
                    }
                } while (!correcto);
                Cliente c = (Cliente) usuario;
                switch (eleccion){
                    case 1:
                        System.out.println("Ingrese su punto de origen: ");
                        String origen = sc.nextLine();
                        System.out.println("Ingrese su destino: ");
                        String destino = sc.nextLine();
                        listaServicios.add(c.Solicitar_taxi(origen, destino));
                        break;
                    case 2:
                        System.out.println("Ingrese su punto de origen: ");
                        String origen_2 = sc.nextLine();
                        System.out.println("Ingrese su destino: ");
                        String destino_2 = sc.nextLine();
                        listaServicios.add(c.EntregaEncomienda(origen_2, destino_2));
                        break;
                    case 3:
                        c.Consultar_servicios();
                        break;
                    case 4:
                        repetir = false;
                        break;
                }
            } else if (usuario.getTipoDeUsuario().equals(TipoUsuario.R)){
                System.out.println("1. Consultar servicios.");
                System.out.println("2. Salir del sistema.");
                do {
                    eleccion = sc.nextInt();
                    if (eleccion == 1 || eleccion ==2){
                        correcto = true;
                    } else {
                        System.out.println("Por favor ingrese una opcion correcta.");
                        System.out.println("1. Consultar servicios.");
                        System.out.println("2. Salir del sistema.");
                    }
                } while (!correcto);
                switch (eleccion){
                    case 1:
                        Conductor r = (Conductor) usuario;
                        r.Consultar_servicios();
                        break;
                    case 2:
                        repetir = false;
                        break;
                }
            }
        }
        sc.close();
    }
  }


