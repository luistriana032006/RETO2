package vista;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelo.emergencias.Emergencia;

public class estadisticas {
    public class Estadisticas {

        // Método 1: Total de emergencias atendidas
        public static int contarTotalEmergencias(List<Emergencia> emergencias) {
            return emergencias.size();
        }

        // Método 2: Total de emergencias por tipo
        public static Map<String, Long> contarPorTipo(List<Emergencia> emergencias) {
            return emergencias.stream()
                    .collect(Collectors.groupingBy(Emergencia::getTipo, Collectors.counting()));
        }

        // Método 3: Gravedad promedio de todas las emergencias
        public static double calcularGravedadPromedio(List<Emergencia> emergencias) {
            return emergencias.stream()
                    .mapToInt(Emergencia::getNivelDeGravedad)
                    .average()
                    .orElse(0.0); // Devuelve 0.0 si no hay emergencias
        }

        // Método 4: Emergencias más graves
        public static List<Emergencia> obtenerEmergenciasGraves(List<Emergencia> emergencias, int umbralGravedad) {
            return emergencias.stream()
                    .filter(e -> e.getNivelDeGravedad() >= umbralGravedad)
                    .collect(Collectors.toList());
        }

        // Método 5: Emergencias por ubicación
        public static Map<String, Long> contarPorUbicacion(List<Emergencia> emergencias) {
            return emergencias.stream()
                    .collect(Collectors.groupingBy(Emergencia::getUbicacion, Collectors.counting()));
        }
    }
}
