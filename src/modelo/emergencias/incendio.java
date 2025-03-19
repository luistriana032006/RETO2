package modelo.emergencias;

public class incendio extends Emergencia {

private int AreaAfectada;

    public incendio(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta, int AreaAfectada) {
        super("incendio", ubicacion, nivelDeGravedad, tiempoDerespuesta);
        this.AreaAfectada = AreaAfectada;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void atender() {
       System.out.println(" atendiendo incendio en la ubicación"+getUbicacion());
       System.out.println(" con una area Afectada de "+getAreaAfectada());
System.out.println(" con un nivel de gravedad "+getNivelDeGravedad());
        super.atender();
    }

    public int getAreaAfectada(){
    return AreaAfectada;
    }
}
