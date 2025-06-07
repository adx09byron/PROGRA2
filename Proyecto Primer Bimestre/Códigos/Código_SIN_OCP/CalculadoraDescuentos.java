public class CalculadoraDescuentos {
    public double calcularDescuento(String tipoCliente, double monto) {
        if (tipoCliente.equals("Estudiante")) {
            return monto * 0.20;
        } else if (tipoCliente.equals("TerceraEdad")) {
            return monto * 0.30;
        } else if (tipoCliente.equals("Empleado")) {
            return monto * 0.15;
        } else {
            return 0.0;
        }
    }
}
