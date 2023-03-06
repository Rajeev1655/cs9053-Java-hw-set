package complexmatrix;

import java.util.Comparator;

/** A Complex class that represents a complex number.
 * a + ib
 */
public class Complex implements Comparable<Complex> {
	double a;
    double b;

    // Constructors
    public Complex(double a, double b) {
    	this.a = a;
    	this.b = b;
    }

    public Complex(double a) {
    	this.a = a;
    	this.b = 0;
    }

    public Complex() {
    	this.a = 0;
    	this.b = 0;
    }

    // Methods
    public double getReal() {
    	return this.a;
    }

    public void setReal(double a) {
    	this.a = a;
    }

    public double getImaginary() {
    	return this.b;
    }

    public void setImaginary(double b) {
    	this.b = b;
    }

    @Override
    public String toString() {
        if (b < 0){
            return String.format("%.2f",a) + " + " + "-i" + String.format("%.2f",Math.abs(b));
        }else{
            return String.format("%.2f",a) + " + " + "i" + String.format("%.2f",b);
        }
    }

    public double getMagnitude() {
    	return Math.sqrt(this.a * this.a + this.b * this.b);
    }

    public Complex add(Complex c) {
    	return new Complex(this.a + c.a, this.b + c.b);
    }

    public Complex subtract(Complex c) {
    	return new Complex(this.a - c.a, this.b - c.b);
    }

    public Complex multiply(Complex c) {
    	return new Complex(this.a * c.a - this.b * c.b, this.a * c.b + this.b * c.a);
    }

    public Complex divide(Complex c) {
    	double denominator = c.a * c.a + c.b * c.b;
    	return new Complex((this.a * c.a + this.b * c.b) / denominator, (this.b * c.a - this.a * c.b) / denominator);
    }

    @Override
    public int compareTo(Complex c) {
        double Threshold = 1e-6;
        // if the difference is less than the threshold, consider them equal
        if (Math.abs(this.getMagnitude() - c.getMagnitude()) < Threshold) {
            return 0;
        } else if (this.getMagnitude() > c.getMagnitude()) {
            return 1;
        } else {
            return -1;
        }
    }
}
