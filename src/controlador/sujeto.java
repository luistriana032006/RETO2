package controlador;

import java.util.ArrayList;
import java.util.List;

/**
 * la clase sujeto se encarga de egistrar, eliminar y notificar a los
 * observadores.
 * la cual implementa los metodos
 */
public class sujeto {

    private List<observador> observadores = new ArrayList<>();

    // Método para agregar un observador
    public void agregarObservador(observador observador) {
        observadores.add(observador);

    }

    // Método para eliminar un observador
    public void eliminarObservador(observador observador) {
        observadores.remove(observador);
    }

    // Método para notificar a todos los observadores
    public void notificarObservadores(String mensaje) {
        for (observador observador : observadores) {
            observador.notificar(mensaje);
        }
    }

   
}
