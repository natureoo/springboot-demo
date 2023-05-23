package com.example.springbootjwt.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter implements Filter {

    private TokenService tokenService;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        tokenService = context.getBean(TokenService.class);
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String tokenHeader = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(tokenHeader) || !tokenHeader.startsWith("Bearer")) {
//            throw new RuntimeException("Token not exists");
            responseError(httpServletResponse, ResponseCode.TOKEN_NOT_EXIST);
            return;
        }

        String token = tokenHeader.substring(7);

        boolean flags = tokenService.verifyToken(token);
        if (!flags) {
            responseError(httpServletResponse, ResponseCode.TOKEN_NOT_CORRECT);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void responseError(HttpServletResponse httpServletResponse, ResponseCode responseCode) throws IOException {
        ResponseResult<String> responseResult = ResponseResult.fail(responseCode, null);
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(httpServletResponse.getWriter(), responseResult);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
