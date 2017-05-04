package ua.petshop.dto;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    String name;
    @NotNull
    String password;
    @NotNull
    String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
