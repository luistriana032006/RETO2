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
