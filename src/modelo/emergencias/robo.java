package modelo.emergencias;



public class robo  extends Emergencia {
    
    private String DescripcionSospechoso;

    public robo(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta, String DescripcionSospechoso) {
        super(tipo, ubicacion, nivelDeGravedad, tiempoDerespuesta);
        this.DescripcionSospechoso = DescripcionSospechoso;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void atender() {
       System.out.println(" Atendiendo robo en la ubicación "+getUbicacion());
       System.out.println("con un nivel de gravedad "+getNivelDeGravedad());
        super.atender();
    }

    public String getDescripcionSospechoso() {
        return DescripcionSospechoso;
    }

}
