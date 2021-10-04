package filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String ipAddress = request.getRemoteAddr();
        System.out.println("Ip Address: " + ipAddress);

        filterChain.doFilter(request,response);

    }
}
