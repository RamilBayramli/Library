package Config;


import Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, {
        String authHeader =
                httpServletRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            FilterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String token = authHeader.substring(7);

        try {
            String username = jwtService.extractUsername(token);
            String role = jwtService.extractRole(token);

            if (username == null || role == null) {
                httpServletResponse.sendError(401, "Invalid Credentials");
                return;
            }
            If(SecurityContextHolder.getContext().getAuthentication() == null) {
                var authoritties = List.of(
                        new SimpleGrantedAuthority("ROLE_" + role)
                );

                SecurityContext.getContext()
                        .setAuthentication(authentication);
            } catch(JwtException | IllegalArgumentException ex){
                SecurityContextHolder.clearContext();
                httpServletResponse.sendError(401, "Invalid or expired JWT");
                return;

            }
        }
        filterChain.doFilter(httpServletRequest);
    }
}
