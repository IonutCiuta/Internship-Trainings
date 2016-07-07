package numbers;

/**
 * Created by iciuta on 7/7/2016.
 */
public class ComplexNumber {
    public Float re, im;

    public ComplexNumber(Float re, Float im) {
        this.re = re;
        this.im = im;
    }

    /*Check if imag. part is negative to display the number in a proper way*/
    @Override
    public String toString() {
        String result = "";
        if(im > 0) {
            result = String.format("%.2f", re) + " + i" + String.format("%.2f", im);
        } else {
            result = String.format("%.2f", re) + " - i" + String.format("%.2f", Math.abs(im));
        }
        return result;
    }
}
