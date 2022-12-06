package com.platzimarket.web.controllers;

import com.platzimarket.domain.dto.AuthenticationRequest;
import com.platzimarket.domain.dto.AuthenticationResponse;
import com.platzimarket.domain.services.UserDetailsSecurityService;
import com.platzimarket.web.security.JwtConfig;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aguileradev
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserDetailsSecurityService userDetails;

    @Autowired
    private AuthenticationManager authManager;


    @PostMapping(path = "/authenticate")
    @Operation(description = "user = root , password = apiserver99", summary = "JWT Auth Session")
    public ResponseEntity<AuthenticationResponse> createToken (@RequestBody AuthenticationRequest authRequest){

        String user = authRequest.getUsername();
        String password = authRequest.getPassword();

        try {

            authManager.authenticate(new UsernamePasswordAuthenticationToken(user,password));
            UserDetails userApi = userDetails.loadUserByUsername(user);
            String jwt = jwtConfig.generateToken(userApi);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
