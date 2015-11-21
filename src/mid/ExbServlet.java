package mid;

import java.io.IOException;

import bean.*;

/**
 * Created by lhch on 2015/11/21 0021.
 */
public class ExbServlet extends javax.servlet.http.HttpServlet {
    public ExbServlet() {
        super();
    }

    protected void doPost(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

     }

    protected void doGet(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    }
}
