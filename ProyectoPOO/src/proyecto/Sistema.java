

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
    }
    
    public static void Iniciar_sesion(Usuario usuario, String contrasena){
        
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
        
    }


  }


