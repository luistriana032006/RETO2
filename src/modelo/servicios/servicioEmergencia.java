package modelo.servicios;

public interface servicioEmergencia {
 void atenderEmergencia( String ubicacion , int gravedad);
 void evaluarEstado();

 //metodos auxiliares para el calculo de cantidad de personal y vehiculos necesarios segun el nivel de gravedad 

 int calcularVehiculos(int gravedad); 
    int calcularPersonal(int gravedad); 
}
