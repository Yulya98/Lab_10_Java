import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/database")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ConnectionToDatabase connection = new ConnectionToDatabase();
        try {
            String result = connection.getInfo(login,password);
            if(result ==""){
                resp.getWriter().write("Вы не аутентифицированы");
            }
            else{
                resp.getWriter().write(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
