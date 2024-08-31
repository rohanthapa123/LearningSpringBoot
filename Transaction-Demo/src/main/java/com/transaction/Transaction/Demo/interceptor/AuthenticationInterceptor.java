package com.transaction.Transaction.Demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("AuthenticationInterceptor::prehandle");
        String authToken = request.getHeader("Authorization");

        if(StringUtils.hasText(authToken) && authToken.startsWith("Basic")){
            String base64Credential = authToken.substring("Basic ".length());
            byte[] decodedCred = Base64.getDecoder().decode(base64Credential);
            String credentials = new String(decodedCred , StandardCharsets.UTF_8);
            String[] parts = credentials.split(":");
            if(USERNAME.equals(parts[0]) && PASSWORD.equals(parts[1])){
                return  true;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false;
    }
}
