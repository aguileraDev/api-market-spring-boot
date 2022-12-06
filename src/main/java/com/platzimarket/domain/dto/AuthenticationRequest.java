package com.platzimarket.domain.dto;

import lombok.Data;

/**
 * @author aguileradev
 */
@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
