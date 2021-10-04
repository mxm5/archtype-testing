import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("username");
        out.println(name+ "'s profile!");

        Cookie[] cookies = request.getCookies();
        out.println(cookies[1].getValue());
    }


}
