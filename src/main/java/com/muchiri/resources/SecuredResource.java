package com.muchiri.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("secured")
@RequestScoped
public class SecuredResource {

    public record Message(String message) {
    }

    @GET
    @RolesAllowed({ "USER", "ADMIN" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Message message = new Message("You have accessed secured resource.");
        String json = JsonbBuilder.create().toJson(message);
        return Response.ok(json).build();

    }

    @GET
    @Path("admin")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    public Response admin() {
        Message message = new Message("You have accessed secured resource.");
        String json = JsonbBuilder.create().toJson(message);
        return Response.ok(json).build();

    }

    @GET
    @Path("user")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    public Response user() {
        Message message = new Message("You have accessed secured resource.");
        String json = JsonbBuilder.create().toJson(message);
        return Response.ok(json).build();

    }

}
