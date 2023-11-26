package clases;
import enums.TipoEncomienda;

public class EntregaEncomienda extends Servicio {
    private int numProductos;
    private double pesoKg;
    private TipoEncomienda tipoEncomienda;
    
    public EntregaEncomienda(String identificador, Conductor conductor, String origen, String destino, String fecha, String hora, int numProductos, double pesoKg, TipoEncomienda tipoEncomienda){
        super(identificador, conductor, origen, destino, fecha, hora);
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
    
    @Override
    public String toString(){
        return "Tipo: Encomienda" +
               "\nTipo encomienda: " + tipoEncomienda +
               "\nCantidad: " + numProductos +
               "\n" + super.toString();

    }
}

