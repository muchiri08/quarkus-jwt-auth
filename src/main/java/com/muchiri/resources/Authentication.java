package com.muchiri.resources;

import com.muchiri.domain.User;
import com.muchiri.dto.AuthRequest;
import com.muchiri.dto.AuthResponse;
import com.muchiri.utils.TokenUtil;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
@PermitAll
@RequestScoped
public class Authentication {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest authRequest) {
        if (authRequest == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        User user = User.findByUsername(authRequest.username);

        if (user != null && user.password.equals(authRequest.password)) {
            String token = TokenUtil.generateToken(user.username, user.roles);
            return Response.ok(new AuthResponse(token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }
}
