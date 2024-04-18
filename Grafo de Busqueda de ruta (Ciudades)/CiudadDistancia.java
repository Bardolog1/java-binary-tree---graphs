public class CiudadDistancia {
    private Ciudad ciudad;
    private int distancia;

    public CiudadDistancia(Ciudad ciudad, int distancia) {
        this.ciudad = ciudad;
        this.distancia = distancia;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public int getDistancia() {
        return distancia;
    }
}
