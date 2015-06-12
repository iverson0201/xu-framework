package thread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xu on 2015/6/9.
 */
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int result;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer a = Integer.parseInt(req.getParameter("a"));
        Integer b = Integer.parseInt(req.getParameter("b"));

        synchronized (this){
            if (a != null && b != null){
                result = a * b;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resp.getWriter().print(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
