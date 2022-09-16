package com.indir.heroku.app.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String organisation;
    private Date createdAt;
    private boolean isActive;
}
