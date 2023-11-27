
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

    public static void main(String[] args) {
        File file = new File("usuarios.txt");
        File file_vehiculos = new File("vehiculos.txt");
                try {
            Scanner sc = new Scanner(file_vehiculos);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
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
        try {
            Scanner sc = new Scanner(file);
            Random random = new Random();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
                String[] values = linea.split(",");
                String cedula = values[0];
                int edad = Integer.parseInt(values[1]);
                String nombre = values[2];
                String apellido = values[3];
                String user = values[4];
                String contrasena = values[5];
                String celular = values[6];
                String tipo_usuario = values[7];
                if (tipo_usuario.equals("R")){
                    int indice_azar = random.nextInt(listaUsuarios.size());
                    listaUsuarios.add(new Conductor("`1234567890", "D", listaVehiculos.get(indice_azar), cedula, edad, nombre, apellido, user, contrasena, celular, TipoUsuario.valueOf(tipo_usuario)));
                }
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
        while (!verificado){
            System.out.print("Ingrese su usuario: ");
            String user = entrada.nextLine();
            System.out.println();
            System.out.print("Ingrese su contraseña: ");
            String password = entrada.nextLine();
            verificado = Verificar_usuario(user, password);
        }
        entrada.close();
        File file = new File("usuarios.txt");
        sc.nextLine();
        try {
            Scanner sc = new Scanner(file);
            Scanner sca = new Scanner(System.in);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
                String[] values = linea.split(",");
                String cedula = values[0];
                int edad = Integer.parseInt(values[1]);
                String nombre = values[2];
                String apellido = values[3];
                String user = values[4];
                String contrasena_user = values[5];
                String celular = values[6];
                String tipo_usuario = values[7];
                if (TipoUsuario.valueOf(tipo_usuario).equals(TipoUsuario.C)){
                    System.out.println("Por favor ingrese su tarjeta de credito para terminar el registro: ");
                    String tarjeta = sca.nextLine();
                    Usuario usuario = new Cliente(cedula, edad, nombre, apellido, user, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario),tarjeta);
                    listaUsuarios.add(cliente);   
                } else {
                    System.out.println("Por favor ingrese su numero licencia: ");
                    String licencia = sca.nextLine();
                    System.out.println("Por favor seleccione su vehiculo: ");
                    int counter = 1;
                    for (Vehiculo v: listaVehiculos){
                        System.out.println(counter +". " +v);
                        counter++;
                    }
                    String num_veh = sca.nextInt();
                    Vehiculo vehiculo = listaVehiculos[num_veh-1];
                    Usuario usuario = new Conductor(licencia, "D", vehiculo, cedula, edad, nombre, apellido, user, contrasena_user, celular, tipo_usuario);
                    listaUsuarios.add(usuario);
                }
                             
            }
            sc.close();
            sca.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static boolean Verificar_usuario(String usuario, String contrasena) {
        boolean verificado = false;
        File file = new File("usuarios.txt");
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
        int eleccion = 0;
        boolean repetir = true;
        while (repetir){
            if (usuario.getTipoDeUsuario.equals(TipoUsuario.C)){
                System.out.println("1. Solicitar servicio de taxi.");
                System.out.println("2. Enviar una encomienda.");
                System.out.println("3. Consultar servicio.");
                System.out.println("4. Salir del sistema.");
                do{
                    eleccion = sc.nextInt();
                    sc.nextline();
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
                if (eleccion == 1 || eleccion ==2){
                    System.out.println("Ingrese su punto de origen: ");
                    String origen = sc.nextLine();
                    System.out.println("Ingrese su destino: ");
                    String destino = sc.nextLine();
                }
                switch (eleccion){
                    case 1:
                        listaServicios.add(c.Solicitar_taxi(origen, destino));
                        break;
                    case 2:
                        listaServicios.add(c.EntregaEncomienda(origen, destino);
                        break;
                    case 3:
                        c.Consultar_servicios();
                        break;
                    case 4:
                        repetir = false;
                        break;
                }
            } else if (usuario.getTipoDeUsuario.equals(TipoUsuario.R)){
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
                        r.Consultar_servicios(r);
                        break;
                    case 2:
                        repetir = false;
                        break;
                }
            }
        }
    }
  }


