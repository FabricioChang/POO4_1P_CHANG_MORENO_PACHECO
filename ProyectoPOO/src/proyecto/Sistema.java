
package proyecto;
import java.util.ArrayList;

import clases.*;
import enums.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    private static String path_usuarios = "usuarios.txt";
    private static String path_vehiculos = "vehiculos.txt";
    public static void main(String[] args) {
        File file_vehiculos = new File(path_vehiculos);
        File file = new File(path_usuarios);
        try {
            Scanner sc = new Scanner(file_vehiculos);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");
                String placa = values[1];
                String modelo = values[2];
                String marca = values[3];
                String tipo = values[4];
                listaVehiculos.add(new Vehiculo(placa, modelo, marca, TipoVehiculo.valueOf(tipo)));
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> lista_vehiculos_usados =new ArrayList<>();
        try (Scanner sc = new Scanner(file);) {
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
                if (TipoUsuario.valueOf(tipo_usuario).equals(TipoUsuario.R)){
                    Random rd = new Random();
                    int azar;
                    do {
                        azar = rd.nextInt(listaVehiculos.size());
                    }while(lista_vehiculos_usados.contains(azar));
                    lista_vehiculos_usados.add(azar);
                    Vehiculo vehiculo = listaVehiculos.get(azar);
                    listaUsuarios.add(new Conductor(cedula, "D", vehiculo, cedula, edad, nombre, apellido, user_txt, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario)));
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
        Scanner entrada = new Scanner(System.in);
        boolean verificado = false;
        Usuario usuario = null;
        String user = null;
        String password = null;
        while (!verificado){
            System.out.print("Ingrese su usuario: ");
            user = entrada.nextLine();
            System.out.println();
            System.out.print("Ingrese su contrasenia: ");
            password = entrada.nextLine();
            verificado = Verificar_usuario(user, password);
        }
        File file = new File(path_usuarios);
        try (Scanner sc = new Scanner(file);) {
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
                        try{
                            File archivoCliente = new File("clientes.txt");
                            boolean yaRegistrado = false;
                                                      
                            if(!archivoCliente.exists()){
                                try (BufferedWriter br = new BufferedWriter(new FileWriter(archivoCliente, true))) {
                               
                                    br.write("cedula,edad,tarjetaCredito\n");
                                
                                }catch (IOException e) {
                                        e.printStackTrace();
                                }
                            }
                            try(Scanner leer = new Scanner(archivoCliente)){
                                while(leer.hasNextLine()){
                                    String lineaCliente = leer.nextLine();
                                    String arrayDatos[] = lineaCliente.split(",");
                                    String tarjetaRegistrada = arrayDatos[2];
                                    String cedulaCliente = arrayDatos[0];
                                
                                    if(cedula.equals(cedulaCliente)){
                                        System.out.println("Ya esta registrado");
                                        yaRegistrado = true;
                                        usuario = new Cliente(cedula, edad, nombre, apellido, user_txt, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario),tarjetaRegistrada);
                                        listaUsuarios.add(usuario);
                                        break;
                                }   
                            }
                            leer.close();
                            if(!yaRegistrado){
                                System.out.println("Por favor ingrese su tarjeta de credito para terminar el registro: ");
                                String tarjeta = entrada.nextLine();
                                
                                try (BufferedWriter br = new BufferedWriter(new FileWriter(archivoCliente, true))) {
                                    
                                    br.write(cedula + "," + edad + "," + tarjeta + "\n");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    usuario = new Cliente(cedula, edad, nombre, apellido, user_txt, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario),tarjeta);
                                    System.out.println("Usuario registrado.");
                                    listaUsuarios.add(usuario);
                                    break;
                            }
                            
                        }catch(FileNotFoundException x){
                            x.printStackTrace();  
                        }      
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
                    else if(TipoUsuario.valueOf(tipo_usuario).equals(TipoUsuario.R)){
                        try{
                            File archivo = new File("conductores.txt");
                            Scanner scanner = new Scanner(archivo);
                            sc.nextLine();
                            while(scanner.hasNextLine()){
                                String line = scanner.nextLine();
                                String datos[] = line.split(",");
                                String numero_licencia = datos[0];
                                String estado = datos[1];
                                String codigoVehiculo = datos[2];
                                if(cedula.equals(numero_licencia)){
                                    try{
                                        File archiv = new File("vehiculos.txt");
                                        Scanner scanne = new Scanner(archiv);
                                        while(scanne.hasNextLine()){
                                            String lineas = scanne.nextLine();
                                            String splitLine[] = lineas.split(",");
                                            String codigoVehiculo1 = splitLine[0];
                                            String placa = splitLine[1];
                                            String modelo = splitLine[2];
                                            String marca = splitLine[3];
                                            String tipo = splitLine[4];
                                            if (codigoVehiculo.equals(codigoVehiculo1)){
                                               usuario = new Conductor(numero_licencia, estado, new Vehiculo(placa, modelo, marca, TipoVehiculo.valueOf(tipo)),cedula, edad, nombre, apellido, user_txt,contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario));
                                               break;
                                            }
                                        }
                                        scanne.close();
                                    }catch(FileNotFoundException o){
                                        o.printStackTrace();
                                    }  
                                break;
                                }  
                            }
                            scanner.close();
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
                    System.out.println("Usuario y contrasenia correctos");
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
            System.out.println("Usuario o contrasenia incorrectos");
        }
        return verificado;
    }
       
      
    public static void Mostar_menu(Usuario usuario){
        Scanner scanner = new Scanner(System.in);
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
                    eleccion = scanner.nextInt();
                    scanner.nextLine();
                    if (eleccion == 1 || eleccion == 2 || eleccion == 3 || eleccion == 4 ){
                        correcto = true;
                    } else{
                        System.out.println("Por favor ingrese una opcion correcta.");
                        System.out.println("1. Solicitar servicio de taxi.");
                        System.out.println("2. Enviar una encomienda.");
                        System.out.println("3. Consultar servicios.");
                        System.out.println("4. Salir del sistema.");
                    }
                } while (!correcto);
                Cliente c = (Cliente) usuario;
                switch (eleccion){
                    case 1:
                        System.out.println("Ingrese su punto de origen: ");
                        String origen = scanner.nextLine();
                        System.out.println("Ingrese su destino: ");
                        String destino = scanner.nextLine();
                        ServicioTaxi servicioTaxi = c.Solicitar_taxi(origen, destino);
                        double valor = servicioTaxi.calcularValorPagar();
                        System.out.println("Su valor a pagar es de: $" + valor);
                        System.out.println("Desea confirmar su viaje?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        int continuar = 0;
                        while (!(continuar == 1 || continuar == 2)){
                            continuar = scanner.nextInt();
                            scanner.nextLine();
                        }
                        if (continuar == 1){
                            c.Pagar_servicio(servicioTaxi, c);
                            listaServicios.add(servicioTaxi);
                            c.listaServiciosSolicitados.add(servicioTaxi);
                        } 
                        break;
                    case 2:
                        System.out.println("Ingrese su punto de origen: ");
                        String origen_2 = scanner.nextLine();
                        System.out.println("Ingrese su destino: ");
                        String destino_2 = scanner.nextLine();
                        EntregaEncomienda servicioEncomienda = c.EntregaEncomienda(origen_2, destino_2);
                        double valorEnc = servicioEncomienda.calcularValorPagar();
                        System.out.println("Su valor a pagar es de: $" + valorEnc);
                        System.out.println("Desea confirmar su encomienda?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        int continuarEnc = 0;
                        while (!(continuarEnc == 1 || continuarEnc == 2)){
                            continuarEnc = scanner.nextInt();
                            scanner.nextLine();
                        }
                        if (continuarEnc == 1){
                            c.Pagar_servicio(servicioEncomienda, c);
                            listaServicios.add(servicioEncomienda);
                            c.listaServiciosSolicitados.add(servicioEncomienda);
                        } 
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
                    eleccion = scanner.nextInt();
                    scanner.nextLine();
                    if (eleccion == 1 || eleccion == 2){
                        correcto = true;
                    } else {
                        System.out.println("Por favor ingrese una opcion correcta.");
                        System.out.println("1. Consultar servicios.");
                        System.out.println("2. Salir del sistema.");
                    }
                } while (!correcto);

                switch (eleccion){
                    case 1:
                        System.out.println("/***************SERVICIO ASIGNADO***************/");
                        System.out.println("/*                                             */");
                        System.out.println("/***********************************************/");
                        System.out.println();
                        Conductor r = (Conductor) usuario;
                        r.Consultar_servicios();
                        break;
                    case 2:
                        repetir = false;
                        break;
                }
            }
        }
        scanner.close();
    }
}


