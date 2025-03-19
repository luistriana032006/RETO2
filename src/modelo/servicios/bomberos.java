package modelo.servicios;

public class bomberos implements servicioEmergencia {
    private int VehiculosDisponibles;
    private int bomberosDisponibles;

    // constructor
    public bomberos(int vehiculosDisponibles, int bomberosDisponibles) {
        this.VehiculosDisponibles = vehiculosDisponibles;
        this.bomberosDisponibles = bomberosDisponibles; // INICIALIZACION DIRECTA
    }

    public int getVehiculosDisponibles() {
        return VehiculosDisponibles;
    }

    public int getBomberosDisponibles() {
        return bomberosDisponibles;
    }

    @Override
    // metodo encargado de disminuir los recursos para poderlos asignar cuando se llamen 
    public void atenderEmergencia(String ubicacion, int gravedad) {
        // si los vehiculos disponibles y los bomberos disponibles asignar 1 a la solicitu y quitar 1 al contandor  
        if (VehiculosDisponibles > 0 && bomberosDisponibles > 0) {
            VehiculosDisponibles--;
            bomberosDisponibles--;
        } else {
            System.out.println(" no hay vehiculos de bomberos disponibles ");
        }

        throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
    }

    @Override
    public void evaluarEstado() {
        // evaluamos el estado de los atributos de la clase mostrando la cantidad de recursos disponibles.
        System.out.println(" Los carros de bomberos disponibles son " + getVehiculosDisponibles() + " los Bomberos disponibles  para responder tu solicitud son"+getBomberosDisponibles());
        throw new UnsupportedOperationException("Unimplemented method 'evaluarEstado'");
    }

    // metodo auxiliar
    @Override
    public int calcularVehiculos(int gravedad) {
        // según el numero puesto en gravedad asignar vehiculos.
        switch (gravedad) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                System.out.println(
                        "Introdución de un nivel de gravedad erroneo para asignar vehiculos, vehiculos asigandos");
                return 0;

        }

    }

    // metodo auxiliar
    @Override
    public int calcularPersonal(int gravedad) {
        // segun el numero puesto en la gravedad assignar las personas
        switch (gravedad) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            default:
            System.out.println(
                        "Introdución de un nivel de gravedad erroneo para asignar Personal, personal asigando");
                return 0;
        }

    }

}
