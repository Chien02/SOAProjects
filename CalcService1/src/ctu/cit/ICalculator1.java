package ctu.cit;

import javax.ws.rs.core.Response;

public interface ICalculator1 {
	Response cong(int a, int b);
	Response tru(int a, int b);
	Response nhan(double a, double b);
	Response chia(double a, double b);
}
