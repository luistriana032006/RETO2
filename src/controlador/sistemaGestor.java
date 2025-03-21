

/**
 * esta clase se encargara de crear el patron singleton
 * Esta clase será un Singleton, lo que significa que solo existirá una
 * instancia en todo el programa. Aquí están los pasos para implementarla:
 * 
 * 1. Atributos del sistema
 * Incluye:
 * 
 * Una lista para registrar las emergencias.
 * 
 * Instancias de los servicios de emergencia (Bomberos, Ambulancia y Policía).
 * 
 * 2. Constructor privado
 * El constructor debe ser privado (para implementar el patrón Singleton) y debe
 * inicializar los servicios y cualquier dato necesario.
 * 
 * 3. Métodos principales
 * registrarEmergencia: Para agregar emergencias al sistema.
 * 
 * asignarRecursos: Para coordinar la asignación de recursos según la gravedad
 * de la emergencia.
 * 
 * mostrarEstadoRecursos: Para verificar los recursos actuales de los servicios.
 * 
 * 
 */

   package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import Utilidades.EstrategiaPorPrioridad;
import modelo.emergencias.*;
import modelo.servicios.*;
import recursos.mapasUrbanos;


// Clase sistemaGestor que implementa múltiples patrones de diseño
public class sistemaGestor extends sujeto {

    // === PATRÓN SINGLETON ===
    private static sistemaGestor instancia;

    private sistemaGestor() { 
        this.emergencias = new ArrayList<>();
        this.bomberos = new Bomberos(3, 6);
        this.ambulancia = new ambulancia(4, 12);
        this.policia = new policia(3, 10);
        this.mapasUrbanos = new mapasUrbanos();
    }

    public static sistemaGestor getInstancia() {
        if (instancia == null) {
            instancia = new sistemaGestor();
        }
        return instancia;
    }

    

    // === PATRÓN STRATEGY ===
    private EstrategiaPorPrioridad estrategia;

    public void SetEstrategia(EstrategiaPorPrioridad estrategia) {
        this.estrategia = estrategia;
    }

    // === ATRIBUTOS DEL SISTEMA ===
    private ArrayList<Emergencia> emergencias;
    private Bomberos bomberos;
    private ambulancia ambulancia;
    private policia policia;
    private mapasUrbanos mapasUrbanos;
    private PriorityQueue<Emergencia> colaPrioridad = new PriorityQueue<>(
        (e1, e2) -> Integer.compare(e2.getNivelDeGravedad(), e1.getNivelDeGravedad())
    );

    // === GESTIÓN DE EMERGENCIAS ===
    public void registrarEmergencia(Emergencia emergencia) {
        emergencias.add(emergencia);
        colaPrioridad.add(emergencia); // Agregar a la cola de prioridad

        System.out.println("Emergencia registrada: " + emergencia.getTipo());
        String zona = mapasUrbanos.obtenerZona(emergencia.getUbicacion());
        System.out.println("La emergencia está localizada en la zona: " + zona);

        if (estrategia != null) {
            estrategia.asignarPrioridad(emergencia);
        }

        System.out.println("La emergencia se ha añadido al sistema de priorización.");
    }

    public void asignarRecursos(Emergencia emergencia) {
        int gravedad = emergencia.getNivelDeGravedad();
        String ubicacion = emergencia.getUbicacion();
        String zona = mapasUrbanos.obtenerZona(ubicacion);

        System.out.println("Asignando recursos para la emergencia en la zona: " + zona);

        // Uso de los métodos calcularVehiculos y calcularPersonal en cada servicio
        int vehiculosBomberos = bomberos.calcularVehiculos(gravedad);
        int personalBomberos = bomberos.calcularPersonal(gravedad);
        bomberos.atenderEmergencia(ubicacion, gravedad);

        int vehiculosAmbulancia = ambulancia.calcularVehiculos(gravedad);
        int personalAmbulancia = ambulancia.calcularPersonal(gravedad);
        ambulancia.atenderEmergencia(ubicacion, gravedad);

        int vehiculosPolicia = policia.calcularVehiculos(gravedad);
        int personalPolicia = policia.calcularPersonal(gravedad);
        policia.atenderEmergencia(ubicacion, gravedad);

        System.out.println("Recursos asignados:");
        System.out.println("- Bomberos: " + vehiculosBomberos + " vehículos, " + personalBomberos + " personal.");
        System.out.println("- Ambulancias: " + vehiculosAmbulancia + " vehículos, " + personalAmbulancia + " paramédicos.");
        System.out.println("- Policía: " + vehiculosPolicia + " vehículos, " + personalPolicia + " agentes.");
    }

    public void resolverEmergencia() {
        if (!colaPrioridad.isEmpty()) {
            Emergencia emergencia = colaPrioridad.poll(); // Sacar la emergencia más prioritaria
            System.out.println("Resolviendo emergencia: " + emergencia.getTipo() +
                               " en la ubicación: " + emergencia.getUbicacion());
            asignarRecursos(emergencia);
        } else {
            System.out.println("No hay emergencias en espera.");
        }
    }

    // === ESTADO DEL SISTEMA ===
    public void mostrarEstadoRecursos() {
        System.out.println("Estado actual de los recursos:");
        bomberos.evaluarEstado();
        ambulancia.evaluarEstado();
        policia.evaluarEstado();
    }

    public void mostrarEstadisticas() {
        System.out.println("\nEstadísticas del día:");
        System.out.println("Total de emergencias atendidas: " + emergencias.size());
    }

    public void mostrarEmergenciasPendientes() {
        if (!colaPrioridad.isEmpty()) {
            System.out.println("Emergencias pendientes (ordenadas por prioridad):");
            colaPrioridad.forEach(e -> System.out.println("- Tipo: " + e.getTipo() +
                                                          ", Gravedad: " + e.getNivelDeGravedad() +
                                                          ", Ubicación: " + e.getUbicacion()));
        } else {
            System.out.println("No hay emergencias pendientes.");
        }
    }

    // === MÉTODOS AUXILIARES ===
    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    public mapasUrbanos getMapasUrbanos() {
        return mapasUrbanos;
    }
}

