package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xu on 2015/6/8.
 */
@WebServlet
public class DispatcherServlet extends HttpServlet {

    private static final ThreadLocal<HttpSession> sessionContainer = new ThreadLocal<HttpSession>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        sessionContainer.set(session);
    }

    public static HttpSession getSession(){
        return sessionContainer.get();
    }
}
