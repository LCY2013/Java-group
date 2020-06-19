package com.fufeng.dream.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fufeng.dream.auth.TokenAuthenticationService;
import com.fufeng.dream.domain.AccountCredentials;
import com.fufeng.dream.utils.JSONResult;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java-group
 * @description: 登陆过滤器
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-18 18:09
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        // JSON反序列化成 AccountCredentials
        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
        // 返回一个验证令牌
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(res, auth.getName());
    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().println(JSONResult.fillResultString(500, "Internal Server Error!!!", JSONObject.NULL));
    }

}
