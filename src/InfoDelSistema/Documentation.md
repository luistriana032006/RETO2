# Documentación del proyecto de gestion de emergencias

## introducción

en el desarrollo del reto 2 suministrado por Dev Senior Code el cual hace referencia a un sistema de gestión de
emergencias se utilizaron los conceptos de POO durante el desarrollo de todo el proyecto.

Con este proyecto se busca fortalecer los fundamentos de java los cuales se expusieron durante todo el modulo 2

## clases utilizadas

## clases del paquete modelo.emergencias

las clases del paquete modelo son: [Emergencia, accidente, incendio, robo]

### clase Emergencia

la clase emergencia se basa en la declaración de los datos de las emergencias y contiene un metodo atender el cual le damos una sobreescritura en las clases hijas a donde se vaya a llamar la clase padre:

```
private String tipo; // TIPO: accidente, robo, incendio.
 private String ubicacion;
 private int nivelDeGravedad;
 private double tiempoDerespuesta;

```

**su contructor y sus getter y un setter para validar si el nivel de gravedad cumple las logicas del programa**

constructor con getter y setter:

```
public Emergencia(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta) {
    this.tipo = tipo;
    this.ubicacion = ubicacion;
    this.nivelDeGravedad = nivelDeGravedad;
    this.tiempoDerespuesta = tiempoDerespuesta;
}

public String getTipo() {
    return tipo;
}


public String getUbicacion() {
    return ubicacion;
}
// asi para todos los datos privados de la clase
```

**clase Incendio.**
la clase Incendio **se basa en la extensión _(extends)_ de la clase padre llamada Emergencia** y se hace una sobrecarga al metodo para poder implementar el atributo especifico de la clase Incendio y se le da cuerpo al metodo atender().

```
public class incendio extends Emergencia {

private int AreaAfectada;

    public incendio(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta, int AreaAfectada) {
        super("incendio", ubicacion, nivelDeGravedad, tiempoDerespuesta);
        this.AreaAfectada = AreaAfectada;
        //TODO Auto-generated constructor stub
    }
```

tenemos su getter para el atributo privado y se lleno el metodo atender para la logica de la clase

**asi en cada clase de Emergencia como robo y accidente**

## paquete servicios.

en el paquete servicios tenemos [ambulancia, bomberos, policia] clases de servicios y una intefaz llamada [servicioEmergencia ]

la interfaz servicioEmergencia contiene los metodos

```
void atenderEmergencia( String ubicacion , int gravedad);
 void evaluarEstado();

 //metodos auxiliares para el calculo de cantidad de personal y vehiculos necesarios segun el nivel de gravedad

 int calcularVehiculos(int gravedad);
    int calcularPersonal(int gravedad);
}
```

**clase ambulancia**
la clase ambulancia implementa _(implements)_ la interfaz servicioEmergencia y implementa la _(interfaz observador)_ la cual permite que los objetos de la clase ambulancia sean parte del patron observador a la cual en esta clase le vamos a dar la logica para la clase ambulancia la cual contiene unos atributos privados los cuales inicializamos en el constructor y sus getters para poderlos utilizar en un futuro

```
 private int AmbulanciasDisponibles;
    private int PersonalDisponible;

    public ambulancia(int AmbulanciasDisponibles, int PersonalDisponible) {
        this.AmbulanciasDisponibles = AmbulanciasDisponibles;
        this.PersonalDisponible = PersonalDisponible;

    }

    // getter para obtener la información

    public int getAmbulanciasDisponibles() {
        return AmbulanciasDisponibles;
    }

    public int getPersonalDisponible() {
        return PersonalDisponible;
    }

    // metodos suministrados por la interfaz
    @Override
    public void atenderEmergencia(String ubicacion, int gravedad) {

        if (AmbulanciasDisponibles > 0 && PersonalDisponible > 0) {
            AmbulanciasDisponibles--;
            PersonalDisponible--;

        } else {
            System.out.println(" recursos no disponibles para atender la emergencia");
        }
        throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
    }

    @Override
    public void evaluarEstado() {
        System.out.println("la cantidad de ambulancias disponibles es  " + getAmbulanciasDisponibles()
                + " la cantidad de personal activo para responder tu solicitud es " + getPersonalDisponible());
    }

// metodos auxiliares para el calculo de cantidad de personal y vehiculos necesarios segun el nivel de gravedad
    @Override
    public int calcularVehiculos(int gravedad) {
        switch (gravedad) {
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 4;

            default:
                System.out.println(
                        " Numero de caso de emergencia erroneo cantidad de recursos asignados para su emergencia es ");
                return 0;

        }
    }

    @Override
    public int calcularPersonal(int gravedad) {
        switch (gravedad) {
            case 1:
                return 3;

            case 2:
                return 6;

            case 3:
                return 12;

            default:
            System.out.println(
                        "Introdución de un nivel de gravedad erroneo para asignar vehiculos, vehiculos asigandos");
                return 0;
        }
    }

    @Override
    public void notificar(String mensaje) {
      System.out.println(" ambulancia notificada "+mensaje);
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }

```

**asi con todas las clases restante [bomberos, policia]**

## recursos

dentro de recursos tenemos la clase baseOperacionles y la clase mapasUrbanos

### clase mapasUrbanos

la clase mapasUrbanos es una herramienta esencial para apoyar la gestion de Emergencias esta clase Proporciona informacion sobre zonas operativas en funcion de la ubicación de la emergencia

```
package recursos;

import java.util.HashMap;
import java.util.Map;

public class mapasUrbanos {
 private Map<String, String> ubicaciones;

    public mapasUrbanos() {
        ubicaciones = new HashMap<>();
        // Ejemplo: Asociar nombres de ubicaciones con regiones operativas
        ubicaciones.put("Centro Comercial", "Zona Norte");
        ubicaciones.put("Edificio Administrativo", "Zona Sur");
    }

    public String obtenerZona(String ubicacion) {
        return ubicaciones.getOrDefault(ubicacion, "Zona desconocida");
    }
}

```

## clase BaseOperaciones.

la clase baseOperaciones organiza y coordina los servicios de emergencia (bomberos, ambulancia, policía) su principal aporte es proporcionar una manera centralizada de evaluar el estado de los recursos.

```
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

```

## paquete utilidades patron strategy

en el paquete utilidades tenemos las clases [estrategiaPorPrioridad, fabricaEmergencias, filtroLambda] y la interfaz [EstrategiaPrioriedad ].

**interfazEstrategiaPrioridad**.
Esta estrategia define el contrato para todos las estrategias que se implementen en le sistema de asignar prioridades.

```
package Utilidades;
import modelo.emergencias.Emergencia;
public interface EstrategiaPrioridad {
    // que funcion hace este metodo.
void asignarPrioridad(Emergencia emergencia);
}

```

**clase estrategiaPorPrioridad**
implementa una estrategia especfica para asignar prioridad a las emergencias según su nivel de gravedad

contiene la imterfaz estrategiaPrioridad y le da cuerpo a su metodo.

```
public class EstrategiaPorPrioridad implements EstrategiaPrioridad {

    @Override // implementado de la interfaz Estrategia Prioridad
    public void asignarPrioridad(Emergencia emergencia) {

      int gravedad = emergencia.getNivelDeGravedad();
      if ( gravedad ==3){
    System.out.println(" alta prioridad para emergencia"+ emergencia.getTipo());
    }

     else if (gravedad ==2 ){
        System.out.println (" prioridad media para emergencia "+ emergencia.getTipo());
    }

    else {
    System.out.println(" prioriedad baja para emergencia "+ emergencia.getTipo());
    }



    }

}
```

### fabricaEmergencias.

en la clase fabricaEmergencias implementamos el patron factory.
esta clase contiene un metodo estatico el cual almacena los casos de las emergencias

```
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
```

### filtros lambda

la clase filtros lambda se encarga de proporcionar metodo estaticos para filtrar emergencias utilizando expresiones lambda y streams de java
**contiene los siguientes metodos**

```
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
```

## paquete controlador.

### interfaz observador.

la interfaz observador define la forma en como deben funcionar todas las clases que deseen ser observadores del sistema.

```
public interface observador {
 void notificar(String mensaje);

}

```

## clase sistemaGestor

Es el núcleo del sistema. Implementa toda la lógica para registrar emergencias, asignar recursos, cambiar estrategias, y gestionar la interacción entre los componentes.

**Patrones de Diseño Implementados:**

**Singleton**: Garantiza que solo exista una instancia del gestor.

**Observer**: Permite notificar a los servicios de emergencia cuando ocurre un evento.

**Strategy**: Facilita el cambio dinámico de estrategias para priorizar emergencias.

**Atributos principales:**
private EstrategiaPorPrioridad estrategia:

**Permite cambiar la estrategia de priorización en tiempo de ejecución.**

private ArrayList<Emergencia> emergencias:

**Lista que almacena todas las emergencias registradas.**

private PriorityQueue<Emergencia> colaPrioridad:

Cola que organiza las emergencias según su gravedad. Las emergencias más graves tienen la mayor prioridad.

**Referencias a servicios:**

private Bomberos bomberos

private ambulancia ambulancia

private policia policia

Estas referencias permiten interactuar con los servicios directamente.

private mapasUrbanos mapasUrbanos:

Ayuda a asociar emergencias con una zona específica.

**Métodos destacados:**
Singleton:

getInstancia()

Retorna la única instancia de la clase sistemaGestor.

Gestión de Emergencias:

registrarEmergencia(Emergencia emergencia)

Agrega una emergencia a la lista y a la cola de prioridad.

Asigna recursos y aplica la estrategia de prioridad si está configurada.

resolverEmergencia()

Saca la emergencia con mayor prioridad de la cola y asigna los recursos correspondientes.

**Asignación de Recursos:**

asignarRecursos(Emergencia emergencia)

Usa los métodos calcularVehiculos y calcularPersonal de cada servicio para determinar cuántos recursos son necesarios.

Reduce los recursos disponibles de cada servicio al atender la emergencia.

**Estado del Sistema:**

mostrarEstadoRecursos()

Llama a evaluarEstado en cada servicio para mostrar los recursos disponibles.

mostrarEstadisticas()

Genera un resumen de las emergencias atendidas hasta el momento.

**Filtros:**

AplicarFiltros()

Utiliza la clase FiltrosLambda para filtrar emergencias por tipo, gravedad, o ubicación.

**Cambiar Estrategia:**

SetEstrategia(EstrategiaPorPrioridad estrategia)

Permite cambiar la estrategia usada para priorizar emergencias.

### clase sujeto.

Implementa el Patrón Observer, permitiendo la comunicación entre el sistema y los servicios de emergencia (como ambulancia, policía, bomberos).

Se encarga de registrar observadores, eliminarlos, y notificar a los observadores cuando ocurre algún evento importante

~~~
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

~~~
## paquete vista

### clase menu:
a clase menu actúa como el punto de entrada del sistema y proporciona un menú interactivo para que los usuarios elijan las acciones que desean realizar

**Métodos Destacados:**
```
main
```
Ejecuta el programa y controla el flujo principal mediante un bucle while que sigue mostrando el menú hasta que el usuario decida salir.

Contiene un switch con todas las opciones disponibles.
```
registrarEmergencia(Scanner scanner, sistemaGestor gestor)
```

Captura los datos necesarios (tipo, ubicación, nivel de gravedad) desde la entrada del usuario.

Usa la clase fabricaEmergencias del paquete Utilidades para crear dinámicamente una emergencia y la registra en el gestor.
```
seleccionarEstrategia(Scanner scanner, sistemaGestor gestor)
```
Permite al usuario cambiar la estrategia de priorización. Por ejemplo:

Priorizar por nivel de gravedad.

Priorizar por tipo de emergencia.

## clase estadistica.
La clase estadisticas sirve como herramienta para generar informes sobre las emergencias atendidas. Se enfoca en procesar información y mostrar datos útiles al usuario.

~~~
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

~~~
