import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello!!!</h1>");
        out.println("<h3>Hello!!!</h3>");
        out.println("<h6>Hello!!!</h6>");

        String email =getServletContext().getInitParameter("email");
        out.println("<h2>"+email+"</h2>");


        String course = getServletConfig().getInitParameter("course");
        out.println("<h2>"+course+"</h2>"); //php
    }
}
