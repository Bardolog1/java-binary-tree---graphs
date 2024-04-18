import java.util.*;

public class ArbolCiudades {
    private Ciudad raiz;

    public ArbolCiudades(Ciudad raiz) {
        this.raiz = raiz;
    }

    public List<Ciudad> encontrarRutaMasCorta(String origen, String destino) {
        Map<Ciudad, Integer> distancias = new HashMap<>();
        Map<Ciudad, Ciudad> predecesores = new HashMap<>();
        Set<Ciudad> visitados = new HashSet<>();
        PriorityQueue<CiudadDistancia> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(CiudadDistancia::getDistancia));

        // Inicializar distancias con infinito para todas las ciudades excepto el origen
        for (Ciudad ciudad : obtenerTodasLasCiudades()) {
            if (ciudad.getNombre().equals(origen)) {
                distancias.put(ciudad, 0);
            } else {
                distancias.put(ciudad, Integer.MAX_VALUE);
            }
            colaPrioridad.add(new CiudadDistancia(ciudad, distancias.get(ciudad)));
        }

        while (!colaPrioridad.isEmpty()) {
            CiudadDistancia ciudadActualDistancia = colaPrioridad.poll();
            Ciudad ciudadActual = ciudadActualDistancia.getCiudad();

            if (ciudadActual.getNombre().equals(destino)) {
                break;
            }

            visitados.add(ciudadActual);

            for (Map.Entry<Ciudad, Integer> vecino : ciudadActual.getConexiones().entrySet()) {
                Ciudad ciudadVecina = vecino.getKey();
                int distanciaHastaVecino = vecino.getValue();

                if (!visitados.contains(ciudadVecina)) {
                    int nuevaDistancia = distancias.get(ciudadActual) + distanciaHastaVecino;
                    if (nuevaDistancia < distancias.get(ciudadVecina)) {
                        distancias.put(ciudadVecina, nuevaDistancia);
                        predecesores.put(ciudadVecina, ciudadActual);
                        colaPrioridad.add(new CiudadDistancia(ciudadVecina, nuevaDistancia));
                    }
                }
            }
        }

        return reconstruirRuta(predecesores, origen, destino);
    }

    private List<Ciudad> reconstruirRuta(Map<Ciudad, Ciudad> predecesores, String origen, String destino) {
        List<Ciudad> ruta = new ArrayList<>();
        Ciudad ciudadActual = new Ciudad(destino);
        while (ciudadActual != null && !ciudadActual.getNombre().equals(origen)) {
            ruta.add(0, ciudadActual);
            ciudadActual = predecesores.get(ciudadActual);
        }
        if (ciudadActual != null) {
            ruta.add(0, ciudadActual);
        }
        return ruta;
    }

    private Set<Ciudad> obtenerTodasLasCiudades() {
        Set<Ciudad> ciudades = new HashSet<>();
        Queue<Ciudad> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Ciudad ciudadActual = cola.poll();
            ciudades.add(ciudadActual);
            for (Ciudad vecino : ciudadActual.getConexiones().keySet()) {
                if (!ciudades.contains(vecino)) {
                    cola.add(vecino);
                }
            }
        }
        return ciudades;
    }
}
