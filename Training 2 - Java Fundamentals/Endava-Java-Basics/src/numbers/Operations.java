package numbers;

/**
 * Created by iciuta on 7/7/2016.
 */
public class Operations {
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.re + b.re, a.im + b.im);
    }

    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(
                a.re*b.re - a.im*b.im,
                a.re*b.im + b.re*b.im
        );
    }
}
