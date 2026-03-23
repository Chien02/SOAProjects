package ctu.cit;

import javax.ws.rs.core.Response;

public interface ICalculator3 {
	Response cong(int a, int b);
	Response tru(int a, int b);
	Response nhan(double a, double b);
	Response chia(double a, double b);
	Response luyThua(double a, int n);
	Response giaiThua(int a);
	Response gpt2(double a, double b, double c);
}
