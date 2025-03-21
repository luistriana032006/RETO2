package controlador;

import java.util.ArrayList;
import java.util.List;

import Utilidades.EstrategiaPorPrioridad;
import modelo.emergencias.*;
import modelo.servicios.*;
import recursos.mapasUrbanos;
import Utilidades.*;

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
public class sistemaGestor extends sujeto {
    // estrategy
    private EstrategiaPorPrioridad estrategia;
    // singleton.
    private static sistemaGestor instancia;
    // INICIALIZAR DE LOS MAPAS URBANOS.
    private mapasUrbanos mapasUrbanos;

    private sistemaGestor() // constructor privado para el singleton
    {
        // por que con this y no con Bomberos bomberos = new Bomberos();
        this.emergencias = new ArrayList<>();
        this.bomberos = new Bomberos(3, 6);
        this.ambulancia = new ambulancia(4, 12);
        this.policia = new policia(3, 10);
        this.mapasUrbanos = new mapasUrbanos();
    }

    // atributos especificos.
    private ArrayList<Emergencia> emergencias;
    private Bomberos bomberos;
    private ambulancia ambulancia;
    private policia policia;

    // filtrosLambda
    // por que usamos this en este contexto ?? 3
    public void AplicarFiltros() {
        List<Emergencia> incendios = FiltrosLambda.filtrarPorTipo(this.getEmergencias(), "Incendio");
        List<Emergencia> emergenciasGraves = FiltrosLambda.filtrarPorGravedad(this.getEmergencias(), 3);
        List<Emergencia> enCentroComercial = FiltrosLambda.filtrarPorUbicacion(this.getEmergencias(),
                "Centro Comercial");
        System.out.println("Incendios: " + incendios.size());
        System.out.println("Emergencias graves: " + emergenciasGraves.size());
        System.out.println("Emergencias en el Centro Comercial: " + enCentroComercial.size());
    }

    // obtener singleton
    public static sistemaGestor getInstancia() {

        if (instancia == null) {
            return instancia = new sistemaGestor();
        }
        return instancia;
    }

    // asignar recursos
    public void asignarRecursos(Emergencia emergencia) {
        int gravedad = emergencia.getNivelDeGravedad();
        String ubicacion = emergencia.getUbicacion();

        System.out.println(" asignando recursos para la emergencia");
        bomberos.atenderEmergencia(ubicacion, gravedad);
        policia.atenderEmergencia(ubicacion, gravedad);
        ambulancia.atenderEmergencia(ubicacion, gravedad);

    }
    // METODO PARA ASIGNAR RECURSOS A UNA EMERGENCIA.

    public void registrarEmergencia(Emergencia emergencia) {
        emergencias.add(emergencia);
        System.out.println(" Emergencia resgistrada: " + emergencia.getTipo());
        // if for the strategy of emergencia. class
        String zona = mapasUrbanos.obtenerZona(emergencia.getUbicacion());
        System.out.println(" la emergencia esta siendo asignada en la zona "+ zona);
        if (estrategia != null) {
            estrategia.asignarPrioridad(emergencia);
        }

        asignarRecursos(emergencia);
        System.out.println(" la emergencia esta siendo atendido. Por favor, espere...");
    }

    // METODO PARA MOSTRAR EL ESTADO DE LOS RECURSOS

    public void mostrarEstadoRecursos() {

        System.out.println(" estado actual de los recursos");

        bomberos.evaluarEstado();
        ambulancia.evaluarEstado();
        policia.evaluarEstado();

    }

    // metodo para calcular estadisticas

    public void mostrarEstadisticas() {
        System.out.println("\n estadisticas del dia ");
        System.out.println(" total de emergencias atendidas " + emergencias.size());
    }

    // metodo para cambiar la estrategia.
    public void SetEstrategia(EstrategiaPorPrioridad estrategia) {
        this.estrategia = estrategia;
    }

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

}
