package com.muchiri.domain;

import java.util.Collections;
import java.util.Set;

public class User {

    public String username;
    public String password;
    public Set<Role> roles;

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // This juust example. Load user from the database
    public static User findByUsername(String username) {
        String user = "user", admin = "admin";
        String uPassword = "upassword", aPassword = "apassword";

        if (user.equals(username)) {
            return new User(user, uPassword, Collections.singleton(Role.USER));
        } else if (admin.equals(username)) {
            return new User(admin, aPassword, Collections.singleton(Role.ADMIN));
        } else {
            return null;
        }

    }

}
