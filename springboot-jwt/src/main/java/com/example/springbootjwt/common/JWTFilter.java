package com.example.springbootjwt.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTFilter implements Filter {

    private TokenService tokenService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        tokenService = context.getBean(TokenService.class);
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String tokenHeader = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(tokenHeader) || !tokenHeader.startsWith("Bearer"))
            throw new RuntimeException("Token not exists");

        String token = tokenHeader.substring(7);

        boolean flags = tokenService.verifyToken(token);
        if (!flags)
            throw new RuntimeException("Token not correct");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
