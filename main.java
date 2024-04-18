import java.util.List;

public class main {
    public static void main(String[] args) {
        Ciudad bogota = new Ciudad("Bogotá");
        Ciudad medellin = new Ciudad("Medellín");
        Ciudad cali = new Ciudad("Cali");
        Ciudad barranquilla = new Ciudad("Barranquilla");
        Ciudad cartagena = new Ciudad("Cartagena");

        bogota.agregarConexion(medellin, 415);
        bogota.agregarConexion(cali, 321);
        bogota.agregarConexion(barranquilla, 844);

        medellin.agregarConexion(cali, 280);
        medellin.agregarConexion(barranquilla, 650);

        cali.agregarConexion(cartagena, 671);


        barranquilla.agregarConexion(cartagena, 132);

        ArbolCiudades arbol = new ArbolCiudades(bogota);

        // Encontrar la ruta más corta entre Bogotá y Cartagena
        String origen = "barranquilla";
        String destino = "cali";
        List<Ciudad> rutaMasCorta = arbol.encontrarRutaMasCorta(origen, destino);
        System.out.println("Ruta más corta entre " + origen + " y " + destino + ": " + rutaMasCorta.stream().map(Ciudad::getNombre).reduce((a, b) -> a + " -> " + b).orElse("No encontrada"));
    }
}
