package clases;
import enums.TipoEncomienda;

public class EntregaEncomienda extends Servicio {
    private int numProductos;
    private double pesoKg;
    private TipoEncomienda tipoEncomienda;
    
    public EntregaEncomienda(String origen, String destino, int numProductos, double pesoKg, TipoEncomienda tipoEncomienda){
        super(origen, destino);
        this.numProductos = numProductos;
        this.pesoKg = pesoKg;
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public TipoEncomienda getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }
    
    @Override
    public double calcularValorPagar() {
        double costoEncomienda = 1.0; 
        double costoCarrera = 4.0; 
        return numProductos * costoEncomienda + costoCarrera;
    }

    public double calcularValorPagar(boolean tarjetaCredito) {
        double subtotal = calcularValorPagar();
        if (tarjetaCredito) {
            subtotal = subtotal * 1.10f;
        }
        return subtotal;
    }
    
    @Override
    public String toString(){
        return "\n/*****************************/\nTipo: Encomienda\nTipo encomienda: " + tipoEncomienda +
               "\nCantidad: " + numProductos +
               "\n" + super.toString();
    }
}

