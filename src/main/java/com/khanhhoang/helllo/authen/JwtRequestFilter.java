package com.khanhhoang.helllo.authen;

import com.khanhhoang.helllo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        try {
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                var token = requestTokenHeader.substring(7);
                if (jwtUtil.isTokenExpired(token)) {
                    log.error("Token expired {}", token);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                var username = jwtUtil.extractUsername(token);
                if (username == null) {
                    log.error("Username is null from token");
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                var user = userRepository.findByUsername(username);
                if (user == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                var userDetails = userDetailsService.loadUserByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.info("New request [{}] from: {}", request.getRequestURI(), username);
            }
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            logger.error("Do filter token error: ", ex);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
