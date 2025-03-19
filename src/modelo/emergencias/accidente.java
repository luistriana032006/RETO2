package modelo.emergencias;

public class accidente extends Emergencia {
// variables de la clase accidente 
private  int numeroHeridos;
private int VehiculosInvolucrados;


    public accidente(String tipo, String ubicacion, int nivelDeGravedad, double tiempoDerespuesta, int numeroHeridos, int VehiculosInvolucrados) {
            super("accidente", ubicacion, nivelDeGravedad, tiempoDerespuesta);
            this.numeroHeridos = numeroHeridos;
            this.VehiculosInvolucrados = VehiculosInvolucrados;
            //TODO Auto-generated constructor stub
        }
    
        @Override
    public void atender() {
      System.out.println(" atendiendo accidente en la siguiente ubicación"+getUbicacion());
      System.out.println(" con un nivel de gravedad "+ getNivelDeGravedad());
        super.atender();
    }

        public int getNumeroHeridos() {
            return numeroHeridos;
        }

        public int getVehiculosInvolucrados() {
            return VehiculosInvolucrados;
        }

}
