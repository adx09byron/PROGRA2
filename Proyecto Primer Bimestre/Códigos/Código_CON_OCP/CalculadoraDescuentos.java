public class CalculadoraDescuentos {
    public double aplicarDescuento(PoliticaDescuento politica, double monto) {
        return politica.calcularDescuento(monto);
    }
}
