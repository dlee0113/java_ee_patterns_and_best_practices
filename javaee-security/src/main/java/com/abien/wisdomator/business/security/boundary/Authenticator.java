package com.abien.wisdomator.business.security.boundary;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adam-bien.com
 */
@WebFilter("/*")
public class Authenticator implements Filter{

    @Override
    public void init(FilterConfig filterConfig) {   }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(req.authenticate(resp)) {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {  }
}
