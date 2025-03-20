package controlador;

import java.util.ArrayList;

import Utilidades.EstrategiaPorPrioridad;
import modelo.emergencias.*;
import modelo.servicios.*;

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

    // atributos especificos.
    private ArrayList<Emergencia> emergencias;
    private bomberos bomberos;
    private ambulancia ambulancia;
    private policia policia;

    private sistemaGestor() // constructor privado para el singleton
    {
this.emergencias = new ArrayList<>();
        bomberos bomberos = new bomberos(3, 6);
        ambulancia ambulancia = new ambulancia(4, 12);
        policia policia = new policia(3, 10);
    }
// obtener singleton
    public static sistemaGestor getinstancia() {

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

       if (estrategia != null){
     estrategia.asignarPrioridad(emergencia);
    }

        asignarRecursos(emergencia);
    }

    // METODO PARA MOSTRAR EL ESTADO DE LOS RECURSOS

    public void mostrarEstadoRecursos() {
        System.out.println(" \n estado actual de los recursos");

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
 public void SetEstrategia (EstrategiaPorPrioridad estrategia){
this.estrategia = estrategia;
}
}
