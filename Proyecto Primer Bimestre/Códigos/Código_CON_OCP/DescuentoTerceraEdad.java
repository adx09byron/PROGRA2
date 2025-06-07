public class DescuentoTerceraEdad implements PoliticaDescuento {
    public double calcularDescuento(double monto) {
        return monto * 0.30;
    }
}
