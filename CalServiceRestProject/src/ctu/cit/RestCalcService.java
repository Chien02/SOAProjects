package ctu.cit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class RestCalcService {
	@GET
	@Path("/add/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String add(@PathParam("a") double a, @PathParam("b") double b) {
		return (a + b) + "";
	}
	
	@GET
	@Path("/sub/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sub(@PathParam("a") double a, @PathParam("b") double b) {
		return (a - b) + "";
	}
	
//	@GET
//	@Path("/add/{a}/{b}")
//	@Produces(MediaType.TEXT_XML)
//	public String add(@PathParam("a") double a, @PathParam("b") double b) {
//		return (a + b) + "";
//	}
//	
//	@GET
//	@Path("/sub/{a}/{b}")
//	@Produces(MediaType.TEXT_XML)
//	public String sub(@PathParam("a") double a, @PathParam("b") double b) {
//		return (a - b) + "";
//	}
}
