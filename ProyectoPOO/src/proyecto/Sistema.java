
package proyecto;
import java.util.ArrayList;

import clases.*;
import enums.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        try {

            Scanner sc = new Scanner(file);
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
                    listaUsuarios.add(new Conductor("`1234567890", "D", new Vehiculo("GHI-1297", "Picanto", "Kia", TipoVehiculo.A), cedula, edad, nombre, apellido, user, contrasena, celular, TipoUsuario.valueOf(tipo_usuario)));
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
        Iniciar_sesion();
        
    }
        
        
    public static void Iniciar_sesion(){
        Scanner entrada= new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String user = entrada.nextLine();
         System.out.println();
        System.out.print("Ingrese su contraseña: ");
        String password = entrada.nextLine();
        entrada.close();
    }
   
    public static boolean Verificar_usuario(String usuario, String contrasena) {
        boolean verificado = false;
        for (Usuario u : listaUsuarios) {
            if (u.getUser().equals(usuario) && u.getContrasena().equals(contrasena)) {
                verificado = true;
            }
        }
        if(verificado){
            System.out.println("Usuario y contraseña correctos");
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
        return verificado;
    }
       
      
    public static void Mostar_menu(Usuario usuario){
        System.out.println("/*****************MENU*******************/");
        System.out.println("/*                                      */");
        System.out.println("/****************************************/");
        
        
        
    }


  }


