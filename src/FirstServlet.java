import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/servlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = new Date();
        resp.getWriter().write(date.toString());
        resp.getWriter().write(req.getMethod());
        resp.getWriter().write(req.getRemoteAddr());
        resp.getWriter().write(req.getRemoteUser());
        Enumeration e = req.getHeaderNames();
        while (e.hasMoreElements()) {

            String name = (String) e.nextElement();
            String value = req.getHeader(name);
            resp.getWriter().write(value);
        }
    }
}

