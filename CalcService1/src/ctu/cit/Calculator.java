package ctu.cit;

import java.io.Serializable;

public class Calculator implements Serializable{
	
	// default serial
	private static final long serialVersionUID = 1L;

	public int cong(int a, int b) {
		return a+b;
	}
	
	public int tru(int a, int b) {
		return a-b;
	}
	
	public double nhan(double a, double b) {
		return a*b;
	}
	
	public double chia(double a, double b) {
		if (b==0) return 0.0;
		return a/b;
	}
}
