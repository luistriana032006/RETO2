package modelo.emergencias;

public class Emergencia {
 private String tipo; // TIPO: accidente, robo, incendio.
 private String ubicacion; 
 private int nivelDeGravedad;
 private double tiempoDerespuesta;

 
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


public int getNivelDeGravedad() {
    return nivelDeGravedad;
}


public double getTiempoDerespuesta() {
    return tiempoDerespuesta;
}







 public void setNivelDeGravedad(int nivelDeGravedad) {
    if (nivelDeGravedad <=3 && nivelDeGravedad >=1) {
        this.nivelDeGravedad = nivelDeGravedad;
   
    }
    else {System.out.println(" nivel de gravedad no valido");}
}


public void atender(){}
}
