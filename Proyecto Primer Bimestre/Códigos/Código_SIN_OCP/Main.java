public class Main {
    public static void main(String[] args) {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        double descuento1 = calculadora.calcularDescuento("Estudiante", 100);
        double descuento2 = calculadora.calcularDescuento("TerceraEdad", 200);
        double descuento3 = calculadora.calcularDescuento("Empleado", 150);
        System.out.println("Descuento aplicado: $" + descuento1);
        System.out.println("Descuento aplicado: $" + descuento2);
        System.out.println("Descuento aplicado: $" + descuento3);
    }
}
