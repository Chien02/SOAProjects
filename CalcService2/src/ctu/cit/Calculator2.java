package ctu.cit;

import java.io.Serializable;

public class Calculator2 implements Serializable {
	public double luyThua(double a, int n) {
		double result = 1;
		for (int i=1; i<=n; i++) result *= a;
		return result;
	}
	
	public double giaiThua(int n) {
		double result = 1;
		for (int i=1; i<=n; i++) result *= i;
		return result;
	}
	
	public String gpt2(double a, double b, double c) {
	    if (a == 0) {
	        if (b == 0) {
	            return (c == 0) ? "Phuong trinh vo so nghiem" : "Phuong trinh vo nghiem";
	        }
	        return "Phuong trinh co mot nghiem: x = " + (-c / b);
	    }

	    // Tinh Delta
	    double delta = b * b - 4 * a * c;

	    if (delta > 0) {
	        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
	        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
	        return "Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2;
	    } else if (delta == 0) {
	        double x = -b / (2 * a);
	        return "Phuong trinh co nghiem kep: x = " + x;
	    } else {
	        return "Phuong trinh vo nghiem";
	    }
	}
}
