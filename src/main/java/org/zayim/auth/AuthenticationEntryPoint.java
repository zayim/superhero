package org.zayim.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {

    @Value("superhero")
    private String realmName;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.addHeader("WWW-Authenticate", "Basic realm=\"" + realmName + "\"");
        response.addHeader("Content-Type", "application/json");
        response.setStatus(401);
        response.getWriter().write("{\"errorMessage\": \"" + authException.getMessage() + "\"}");
        response.getWriter().flush();
    }

}
