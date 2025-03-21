package Utilidades;

import modelo.emergencias.Emergencia;

public class EstrategiaPorPrioridad implements EstrategiaPrioridad {

    @Override // implementado de la extension Estrategia Prioridad
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
