package com.intech.session6.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader =request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (requestHeader!=null && requestHeader.startsWith("Bearer")){
            token=requestHeader.substring(7);
            try {
                username=jwtHelper.getUserNameFromToken(token);
            }catch (IllegalArgumentException e){
                System.out.println("Illegal args exception");
                e.printStackTrace();
            }catch (ExpiredJwtException e){
                System.out.println("Token Expired");
                e.printStackTrace();
            }
        }
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            Boolean validateToken=jwtHelper.validateToken(token,userDetails);
            if(validateToken){
                UsernamePasswordAuthenticationToken authontication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authontication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authontication);
            }
        }
        filterChain.doFilter(request,response);
    }
}
