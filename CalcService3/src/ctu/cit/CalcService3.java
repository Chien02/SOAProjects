package ctu.cit;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.core.*;
import javax.ws.rs.*;
import javax.ws.rs.client.*;

@Path("/calc3")
@Produces(MediaType.APPLICATION_JSON)
public class CalcService3 implements ICalculator3{
	private final String BASE_URL_1 = "http://localhost:8080/CalcService1/rest/calc";
    private final String BASE_URL_2 = "http://localhost:8080/CalcService2/rest/calc2";

    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);

	@Override
	@POST
	@Path("/cong/{a}/{b}")
	public Response cong(@PathParam("a") int a, @PathParam("b") int b) {
		WebTarget target = client.target(BASE_URL_1).path("cong").path(String.valueOf(a)).path(String.valueOf(b));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/tru/{a}/{b}")
	public Response tru(@PathParam("a") int a, @PathParam("b") int b) {
		WebTarget target = client.target(BASE_URL_1).path("tru").path(String.valueOf(a)).path(String.valueOf(b));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/nhan/{a}/{b}")
	public Response nhan(@PathParam("a") double a, @PathParam("b") double b) {
		WebTarget target = client.target(BASE_URL_1).path("nhan").path(String.valueOf(a)).path(String.valueOf(b));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/chia/{a}/{b}")
	public Response chia(@PathParam("a") double a, @PathParam("b") double b) {
		WebTarget target = client.target(BASE_URL_1).path("chia").path(String.valueOf(a)).path(String.valueOf(b));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/luythua/{a}/{n}")
	public Response luyThua(@PathParam("a") double a, @PathParam("n") int n) {
		WebTarget target = client.target(BASE_URL_2).path("luythua").path(String.valueOf(a)).path(String.valueOf(n));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/giaithua/{a}")
	public Response giaiThua(@PathParam("a") int a) {
		WebTarget target = client.target(BASE_URL_2).path("giaithua").path(String.valueOf(a));
		return target.request().post(null);
	}

	@Override
	@POST
	@Path("/gpt2/{a}/{b}/{c}")
	public Response gpt2(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
		WebTarget target = client.target(BASE_URL_2).path("gpt2")
                .path(String.valueOf(a))
                .path(String.valueOf(b))
                .path(String.valueOf(c));
		return target.request().post(null);
	}

}
