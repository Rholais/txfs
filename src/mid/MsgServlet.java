package mid;

import bean.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by lhch on 2015/11/21 0021.
 */
@WebServlet(name = "MsgServlet")
public class MsgServlet extends HttpServlet {

    private Boolean status;

    private void dot(
    HttpServletRequest request,
    HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int exb_id = Integer.parseInt(request.getParameter("exb_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_name = request.getParameter("user_name");
        LocalDateTime msg_time = LocalDateTime.parse(request.getParameter("msg_time"));
        String msg_addr = request.getParameter("msg_addr");
        Message msg = new Message(exb_id, user_id, user_name,
                msg_time, msg_addr, 0);
        DB db = new DB();
        status = msg.insertMessage(db) != 0;
        Gson gson = new Gson();
        String json = gson.toJson(this);
        response.getWriter().print(json);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        dot(request, response);
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        dot(request, response);
    }
}
