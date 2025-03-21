package Utilidades;

import java.util.List;
import java.util.stream.Collectors;
import modelo.emergencias.Emergencia;

public class FiltrosLambda {

    // Filtrar emergencias por tipo
    public static List<Emergencia> filtrarPorTipo(List<Emergencia> emergencias, String tipo) {
        return emergencias.stream()
                .filter(e -> e.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    // Filtrar emergencias por gravedad mínima
    public static List<Emergencia> filtrarPorGravedad(List<Emergencia> emergencias, int gravedadMinima) {
        return emergencias.stream()
                .filter(e -> e.getNivelDeGravedad() >= gravedadMinima)
                .collect(Collectors.toList());
    }

    // Filtrar emergencias por ubicación específica
    public static List<Emergencia> filtrarPorUbicacion(List<Emergencia> emergencias, String ubicacion) {
        return emergencias.stream()
                .filter(e -> e.getUbicacion().equalsIgnoreCase(ubicacion))
                .collect(Collectors.toList());
    }
}
