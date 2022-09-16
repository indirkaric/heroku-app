package com.indir.heroku.app.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class RestApiError implements Serializable {
    public static final RestApiError USER_NOT_FOUND = new RestApiError("user_not_found", "user not found");
    public static final RestApiError USER_ALREADY_EXIST = new RestApiError("user_already_exist", "user already exist");
    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
    @JsonProperty(ERROR)
    private String error;
    @JsonProperty(ERROR_DESCRIPTION)
    private String description;

    public RestApiError(String error, String description) {
        this.error = error;
        this.description = description;
    }
}
