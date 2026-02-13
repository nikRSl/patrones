public class GeneradorFacturas {

    private static GeneradorFacturas instancia;
    private int numero = 0;

    private GeneradorFacturas() {}

    public static GeneradorFacturas getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorFacturas();
        }
        return instancia;
    }

    public int generar() {
        return ++numero;
    }
}

public class Main {
    public static void main(String[] args) {

        InvoiceGenerator g1 = InvoiceGenerator.getInstance();
        InvoiceGenerator g2 = InvoiceGenerator.getInstance();

        System.out.println(g1.generate()); 
        System.out.println(g2.generate()); 
        System.out.println(g1 == g2);      
    }
}
