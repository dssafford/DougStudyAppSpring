package com.doug.commands;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by jt on 2/2/16.
 */
public class LoginCommand {

    @NotEmpty
    @Size(min = 2, max = 50)
    private String username;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
