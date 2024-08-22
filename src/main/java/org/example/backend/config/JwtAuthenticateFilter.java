package org.example.backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.backend.model.entity.UserEntity;
import org.example.backend.provider.JwtProvider;
import org.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticateFilter extends OncePerRequestFilter {



    private final JwtProvider jwtProvider;

    private final UserRepository userRepository;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{

            String token= parseBearerToken(request);
            if (token==null){
                filterChain.doFilter(request,response);
                return;
            }


            String username= jwtProvider.validate(token);
            if (username==null){
                filterChain.doFilter(request,response);
                return;
            }
            UserEntity userEntity= userRepository.findByUsername(username);
            String role= userEntity.getRole();


            System.out.println("role: " +role);

            List<GrantedAuthority> authorities= new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));




            SecurityContext securityContext=SecurityContextHolder.createEmptyContext();
            AbstractAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username,null,authorities);

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        }
        catch (Exception e){
            e.printStackTrace();
        }


        //검증이 끝난 후엔 이후 필터 적용
        filterChain.doFilter(request,response);
    }

    private String parseBearerToken(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization= StringUtils.hasText(authorization);
        if (!hasAuthorization)
            return null;

        boolean isBearer= authorization.startsWith("Bearer ");
        if(!isBearer)
            return null;

        String token= authorization.substring(7);
        return token;
    }
}
