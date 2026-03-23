package ctu.cit;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

public class RestCalcServiceClient {      
    public static void main(String[] args) {
    	ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        URI  uri = UriBuilder.fromUri(
          "http://localhost:8080/CalServiceRestProject/").build();

        WebTarget target = client.target(uri);

        // http://localhost:8080/CalRestService/rest/calc/add/7/5
        String response = target.path("rest").path("calc")
                                .path("add").path("7").path("5")
                        .request().accept(MediaType.TEXT_PLAIN)
                        .get(Response.class).toString();
        // call operation: rest/calc/add/7/5
        String plainAnswer =
                target.path("rest").path("calc")
                      .path("add").path("7").path("5")
                      .request().accept(MediaType.TEXT_PLAIN)
                      .get(String.class);
//        String xmlAnswer =
//                target.path("rest").path("calc")
//                      .path("add").path("7").path("5")
//                      .request().accept(MediaType.TEXT_XML)
//                      .get(String.class);

        //System.out.println(response);
        System.out.println("plainAnswer: "+ plainAnswer);
//        System.out.println("xmlAnswer: "  + xmlAnswer);
    }
}
