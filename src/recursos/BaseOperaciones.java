package recursos;
import modelo.servicios.servicioEmergencia;
public class BaseOperaciones {
    private servicioEmergencia bomberos;
    private servicioEmergencia ambulancia;
    private servicioEmergencia policia;

    public BaseOperaciones(servicioEmergencia bomberos, servicioEmergencia ambulancia, servicioEmergencia policia) {
        this.bomberos = bomberos;
        this.ambulancia = ambulancia;
        this.policia = policia;
    }

    public void mostrarEstadoServicios() {
        bomberos.evaluarEstado();
        ambulancia.evaluarEstado();
        policia.evaluarEstado();
    }
}
