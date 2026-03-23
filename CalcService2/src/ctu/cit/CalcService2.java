package ctu.cit;

import javax.ws.rs.core.*;
import javax.ws.rs.*;

@Path("/calc2")
@Produces(MediaType.APPLICATION_JSON)
public class CalcService2 implements ICalculator2 {
	private static Calculator2 calculator = new Calculator2();

	@Override
	@POST
	@Path("/luythua/{a}/{n}")
	public Response luyThua(@PathParam("a") double a, @PathParam("n") int n) {
		double result = calculator.luyThua(a, n);
		return Response.ok(result).build();
	}

	@Override
	@POST
	@Path("/giaithua/{a}")
	public Response giaiThua(@PathParam("a") int a) {
		double result = calculator.giaiThua(a);
		return Response.ok(result).build();
	}

	@Override
	@POST
	@Path("/gpt2/{a}/{b}/{c}")
	public Response gpt2(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
		String result = calculator.gpt2(a, b, c);
		return Response.ok(result).build();
	}
}
