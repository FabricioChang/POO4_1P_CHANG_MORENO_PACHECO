
package proyecto;
import enums.MetodoPago;
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
                    if (!listaUsuarios.isEmpty()) {
                    int indice_azar = random.nextInt(listaUsuarios.size());
                    listaUsuarios.add(new Conductor("`1234567890", "D", listaVehiculos.get(indice_azar), cedula, edad, nombre, apellido, user, contrasena, celular, TipoUsuario.valueOf(tipo_usuario)));
                    }
                    else{
                       //System.out.println(listaUsuarios);
                    }
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
        String[] User_Password = Iniciar_sesion();
        Verificar_usuario(User_Password[0], User_Password[1]);
        Mostar_menu(Usuario usuario);

    }
        
        
    public static String[] Iniciar_sesion(){
        
        Scanner entrada= new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String user = entrada.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String password = entrada.nextLine();
        
        return new String[]{user,password};
        
        
    }
    public static boolean Verificar_usuario(String usuario, String contrasena) {
        boolean verificado = false;
        File file = new File("usuarios.txt");
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
                if (user.equals(usuario) && contrasena_user.equals(contrasena)) {
                    System.out.println("Usuario y contraseña correctos, por favor ingrese su tarjeta de credito para terminar el registro: ");
                    String tarjeta = sca.nextLine();
                    verificado = true;
                    listaUsuarios.add(new Cliente(cedula, edad, nombre, apellido, user, contrasena_user, celular, TipoUsuario.valueOf(tipo_usuario),tarjeta));
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
        System.out.println("/*****************MENU*******************/");
        System.out.println("/*                                      */");
        System.out.println("/****************************************/");
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar comida a domicilio");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar servicios");
        
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Scanner ingreso1= new Scanner(System.in);
                System.out.print("Ingrese su origen");
                String origen = ingreso1.nextLine();
                System.out.println();
                System.out.print("Ingrese su destino");
                String destino = ingreso1.nextLine();
                System.out.println();
                System.out.print("Ingrese el numero de pasajeros");
                int numPasajeros= ingreso1.nextInt();
                ingreso1.nextLine();
                ServicioTaxi taxi= new ServicioTaxi(origen,destino,numPasajeros);
                System.out.print("Ingrese metodo de pago: (E/TC)");
                String metodo = ingreso1.nextLine();
                
                if  (metodo.equalsIgnoreCase("E")){
                    MetodoPago mpago= MetodoPago.E;
                    taxi.calcularValorPagar();
                }
                else if (metodo.equalsIgnoreCase("TC")){
                    MetodoPago mpago=MetodoPago.TC;
                    taxi.calcularValorAPagar(true);
                }
//                else{
//                    System.out.print("Metodo no valido");
//                    System.out.print("Ingrese metodo de pago: (E/TC)");
//                    String metodo = ingreso1.nextLine();
//                }
                System.out.print("¿Desea confirmar su viaje?");
                String confirmacion= ingreso1.nextLine();
                if (confirmacion.equalsIgnoreCase("Si")||confirmacion.equalsIgnoreCase("sí")){
                    taxi.toString();
                }
                else{
                    ingreso1.close();
                    break;
                }
                ingreso1.close();
                break;
            case 2:
                System.out.println("Has ingresado el número 2.");
                break;
            case 3:
                System.out.println("Has ingresado el número 3.");
                break;
            case 4:
                System.out.println("Has ingresado el número 4.");
                break;      
            default:
                System.out.println("Número no válido. Ingrese un número del 1 al 4.");
        }

        scanner.close();
    }
    
    }




