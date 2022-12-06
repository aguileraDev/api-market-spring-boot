package com.platzimarket.domain.dto;

import lombok.Data;

/**
 * @author aguileradev
 */
@Data
public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }
}
