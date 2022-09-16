package com.indir.heroku.app.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserDto {

    @NotBlank(message = "First name can not be blank")
    private String firstName;

    @NotBlank(message = "Last name can not be blank")
    private String lastName;

    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotBlank(message = "Organisation can not be blank")
    private String organisation;
}
