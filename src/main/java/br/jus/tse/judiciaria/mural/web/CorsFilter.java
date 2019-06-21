package br.jus.tse.judiciaria.mural.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_HEADRS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_METHOD_AGE = "Access-Control-Method-Age";
    private static final String ORIGENS_PERMITIDAS = "*";
    private static final String HEADERS_PERMITIDOS = "origin, content-type, accept, authorization";
    private static final String CREDENCIAIS_PERMITIDAS = "true";
    private static final String METHODS_PERMITIDOS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
    private static final String VALOR_METHOD_AGE = "86400";

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ORIGENS_PERMITIDAS);
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_METHODS, METHODS_PERMITIDOS);
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_HEADRS, HEADERS_PERMITIDOS);
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, CREDENCIAIS_PERMITIDAS);
        httpResponse.setHeader(ACCESS_CONTROL_METHOD_AGE, VALOR_METHOD_AGE);
        chain.doFilter(request, response);
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // do nothing.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException();
    }
}
