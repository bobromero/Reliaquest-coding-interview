package com.challenge.api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String API_KEY_HEADER = "X-Api-Key";

    private final Set<String> validApiKeys; // multiple api keys to track usage by user's key

    public ApiKeyFilter(@Value("${api.keys}") String[] keys) {
        this.validApiKeys = Set.of(keys);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String apiKey = request.getHeader(API_KEY_HEADER);
        if (apiKey == null || !validApiKeys.contains(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Invalid or missing API Key");
            return;
        }

        // Log this call to some sort of database to keep track of usage
        logger.info("apiKey: " + apiKey + " | request: " + request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
