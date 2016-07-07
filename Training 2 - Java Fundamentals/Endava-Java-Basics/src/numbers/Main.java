package numbers;

public class Main {

    public static void main(String[] args) {
        ComplexNumber c1, c2;
        c1 = new ComplexNumber(2f, 3f);
        c2 = new ComplexNumber(0.3f, -5f);
        System.out.println(Operations.add(c1, c2));
        System.out.println(Operations.multiply(c1, c2));
    }
}
