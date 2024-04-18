import java.util.HashMap;
import java.util.Map;

public class Ciudad {
    private String nombre;
    private Map<Ciudad, Integer> conexiones;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.conexiones = new HashMap<>();
    }

    public void agregarConexion(Ciudad ciudadVecina, int distancia) {
        conexiones.put(ciudadVecina, distancia);
        ciudadVecina.conexiones.put(this, distancia); // Para asegurar que la conexión sea bidireccional
    }

    public String getNombre() {
        return nombre;
    }

    public Map<Ciudad, Integer> getConexiones() {
        return conexiones;
    }
}
