package mid;

import bean.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lhch on 2015/11/21 0021.
 */
@WebServlet(name = "PlusServlet")
public class PlusServlet extends HttpServlet {

    private Boolean plus;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int msg_id = Integer.parseInt(request.getParameter("id"));
        Message msg = new Message(msg_id, 0, 0);
        DB db = new DB();
        msg = msg.selectMessageById(db).get(0);
        msg.setMsg_plus(msg.getMsg_plus() + 1);
        plus = msg.updateMessage(db) != 0;
        Gson gson = new Gson();
        String json = gson.toJson(this);
        response.getWriter().print(json);
    }
}
