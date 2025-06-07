public class DescuentoEstudiante implements PoliticaDescuento {
    public double calcularDescuento(double monto) {
        return monto * 0.20;
    }
}
