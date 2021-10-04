package filter;

import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class BrowserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String userAgent = httpServletRequest.getHeader("user-agent");

        Parser uaParser = new Parser();
        Client client = uaParser.parse(userAgent);

        if (client.userAgent.family.equals("Firefox")) {
            PrintWriter out = servletResponse.getWriter();
            out.println("<font color='red'>You are not authorized!!! You should use another browser!!!</font>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        System.out.println(userAgent);
    }
}
