package com.muchiri.utils;

import java.util.Set;
import java.util.stream.Collectors;

import com.muchiri.domain.Role;

import io.smallrye.jwt.build.Jwt;

public interface TokenUtil {
    //final String ISSUER = "com.muchiri";

    // Excluding things like expirationTime etc in this for simplicity
    public static String generateToken(String username, Set<Role> roles) {
        Set<String> rStrings = roles.stream()
                .map(role -> role.name()).collect(Collectors.toSet());

        String token = Jwt.issuer("com.muchiri")
                .upn(username).groups(rStrings).sign();

        return token;
    }
}
