package clases;

public class ServicioTaxi extends Servicio {
    private int numPasajeros;
    private final static double costoKm = 0.50;
    
    public ServicioTaxi(String origen, String destino, int numPasajeros){
        super(origen, destino);
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    public double generarDistanciaAleatoria(double min, double max) {
        return Math.random() * (max - min + 1) + min;
    }

    @Override
    public double calcularValorPagar() {
        double distanciaKM = generarDistanciaAleatoria(5,45);
        double subtotal = distanciaKM * costoKm;
        return subtotal;
    }
    
    public double calcularValorAPagar(boolean tarjetaCredito) {
        double subtotal = calcularValorPagar();
        
        if (tarjetaCredito) {
            subtotal += subtotal * 0.10;
        }
        
        return subtotal;
    }
    
    @Override
    public String toString() {
    return  "Tipo: Viaje\nCantidad pasajeros: " + numPasajeros +
            "\n" + super.toString();       
}
     
}
