package com.platzimarket.web.security.filter;

import com.platzimarket.domain.services.UserDetailsSecurityService;
import com.platzimarket.web.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author aguileradev
 */
@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private UserDetailsSecurityService userDetails;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){

            Jws<Claims> jwtHeaderClaims = jwtConfig.getClaims(authorizationHeader.substring(7));
            String userName = jwtConfig.extractTokenUserName(jwtHeaderClaims);

            Authentication authenticationContext = SecurityContextHolder.getContext().getAuthentication();

            if(userName!=null && authenticationContext == null ){

                UserDetails user = userDetails.loadUserByUsername(userName);

                if(jwtConfig.validateToken(jwtHeaderClaims , user)){
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request,response);
    }

}
