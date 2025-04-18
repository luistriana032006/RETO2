package modelo.servicios;

import controlador.observador;

public class policia implements servicioEmergencia, observador {
    private int PatrullasDisponibles;
    private int PoliciasDisponibles;

    public policia(int PatrullasDisponibles, int PoliciasDisponibles) {
        this.PatrullasDisponibles = PatrullasDisponibles;
        this.PoliciasDisponibles = PoliciasDisponibles;

    }

    // getters para obtener el contenido.
    public int getPatrullasDisponibles() {
        return PatrullasDisponibles;
    }

    public int getPoliciasDisponibles() {
        return PoliciasDisponibles;
    }

    @Override
    public void atenderEmergencia(String ubicacion, int gravedad) {
        if (PatrullasDisponibles > 0 && PoliciasDisponibles > 0) {
            PatrullasDisponibles--;
            PoliciasDisponibles--;

        }
    }

    @Override
    public void evaluarEstado() {
        System.out.println(" los policias disponibles son "+getPoliciasDisponibles() + " el numero de patrullas disponibles son"+getPatrullasDisponibles());
    }

    @Override
    public int calcularVehiculos(int gravedad) {
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

    @Override
    public int calcularPersonal(int gravedad) {
        switch (gravedad) {
            case 1:
                return 4;
            case 2:
                return 7;
            case 3:
                return 10;

            default:
                System.out.println(
                        "Introdución de un nivel de gravedad erroneo para asignar Personal, personal asigando");
                return 0;
        }
    }

    @Override// sobreescrito de la interfaz observador
    public void notificar(String mensaje) {
      System.out.println(" policia notificados "+mensaje);
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }

}
