/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import enums.TipoVehiculo;

/**
 *
 * @author jlmor
 */
public class Vehiculo {
    private String placa,modelo,marca;
    private TipoVehiculo tipo;
    
    
    public Vehiculo(String placa,String modelo,String marca,TipoVehiculo tipo){
        this.placa=placa;
        this.modelo=modelo;
        this.marca=marca;
        this.tipo=tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", tipo=" + tipo + '}';
    }
    
}
