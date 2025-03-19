package modelo.servicios;

public class ambulancia implements servicioEmergencia {

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

}
