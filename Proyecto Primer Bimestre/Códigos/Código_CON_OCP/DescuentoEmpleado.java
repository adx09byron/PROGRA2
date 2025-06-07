public class DescuentoEmpleado implements PoliticaDescuento {
    public double calcularDescuento(double monto) {
        return monto * 0.15;
    }
}
