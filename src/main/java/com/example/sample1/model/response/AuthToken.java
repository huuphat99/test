package com.example.sample1.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthToken implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }
}