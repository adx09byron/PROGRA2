public class Main {
    public static void main(String[] args) {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        PoliticaDescuento politica1 = new DescuentoEstudiante();
        PoliticaDescuento politica2 = new DescuentoTerceraEdad();
        PoliticaDescuento politica3 = new DescuentoEmpleado();
        double descuento1 = calculadora.aplicarDescuento(politica1, 100);
        double descuento2 = calculadora.aplicarDescuento(politica2, 200);
        double descuento3 = calculadora.aplicarDescuento(politica3, 150);
        System.out.println("Descuento aplicado: $" + descuento1);
        System.out.println("Descuento aplicado: $" + descuento2);
        System.out.println("Descuento aplicado: $" + descuento3);
    }
}
