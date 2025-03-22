package Utilidades;

/**patron factory
 * 
 * creacion de objetos sin especificacion directamente
 * de su clase 
 * lo cual permite crear diferentes tipos de emergencias (incendio, accideente, robo)
 * de forma dinamica 
 * 
 */
import modelo.emergencias.*;

public class fabricaEmergencias {

    public static Emergencia crearEmergencia(String tipo, String ubicacion) {
        switch (tipo.toLowerCase()) {
            case "incendio":
                return new incendio(tipo, ubicacion, 0, 0, 0);

            case "accidente":
                return new accidente(tipo, ubicacion, 0, 0, 0, 0);

            case "robo":
                return new robo(tipo, ubicacion, 0, 0, ubicacion);

            default:

                throw new IllegalArgumentException("Tipo de emergencia no reconocido: " + tipo);

        }
    }
}
