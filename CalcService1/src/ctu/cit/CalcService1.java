package ctu.cit;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/calc")
@Produces(MediaType.APPLICATION_JSON)
public class CalcService1 implements ICalculator1{
	private static Calculator calculator = new Calculator();

	@Override
	@POST
	@Path("/cong/{a}/{b}")
	public Response cong(@PathParam("a") int a, @PathParam("b") int b) {
		return Response.ok(calculator.cong(a, b)).build();
	}

	@Override
	@POST
	@Path("/tru/{a}/{b}")
	public Response tru(@PathParam("a") int a, @PathParam("b") int b) {
		return Response.ok(calculator.tru(a, b)).build();
	}

	@Override
	@POST
	@Path("/nhan/{a}/{b}")
	public Response nhan(@PathParam("a") double a, @PathParam("b") double b) {
		return Response.ok(calculator.nhan(a, b)).build();
	}

	@Override
	@POST
	@Path("/chia/{a}/{b}")
	public Response chia(@PathParam("a") double a, @PathParam("b") double b) {
		return Response.ok(calculator.chia(a, b)).build();
	}
	
}
