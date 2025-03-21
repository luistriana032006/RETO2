# Documentación del proyecto de gestion de emergencias

## introducción
en el desarrollo del reto 2 suministrado por Dev Senior Code el cual hace referencia a un sistema de gestión de 
emergencias se utilizaron los conceptos de POO durante el desarrollo de todo el proyecto.

Con este proyecto se busca fortalecer los fundamentos de java los cuales se expusieron durante todo el modulo 2

## clases utilizadas 

## clases del paquete modelo.emergencias

las clases del paquete modelo son: [Emergencia, accidente, incendio, robo]

### clase Emergencia 
la clase emergencia se basa en la declaración de los datos de las emergencias y contiene  un metodo atender el cual le damos una sobreescritura en las clases hijas a donde se vaya a llamar la clase padre:
```
private String tipo; // TIPO: accidente, robo, incendio.
 private String ubicacion; 
 private int nivelDeGravedad;
 private double tiempoDerespuesta;

```
*su contructor y sus getter y un setter para validar si el nivel de gravedad cumple las logicas del programa* 

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
### clase Incendio.
la clase Incendio *se basa en la extensión de la clase padre llamada Emergencia* y se hace una sobrecarga al metodo para poder implementar el atributo especifico de la clase Incendio y se le da cuerpo al metodo atender().

```
public class incendio extends Emergencia {

private int AreaAfectada;

    public incendio(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta, int AreaAfectada) {
        super("incendio", ubicacion, nivelDeGravedad, tiempoDerespuesta);
        this.AreaAfectada = AreaAfectada;
        //TODO Auto-generated constructor stub
    }
```