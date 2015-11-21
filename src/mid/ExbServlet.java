package mid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import bean.*;
import com.google.gson.Gson;

/**
 * Created by lhch on 2015/11/21 0021.
 */
@WebServlet(name = "ExbServlet")
public class ExbServlet extends HttpServlet {

    private Exhibit exb;
    private ArrayList<Message> msg_al;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

     }

    protected void doGet(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int exb_id = Integer.parseInt(request.getParameter("id"));
        Boolean isLast = Integer.parseInt(request.getParameter("last")) != 0;
        exb = new Exhibit(exb_id);
        Message msg = new Message(0, exb_id, 0);
        DB db = new DB();
        exb = exb.selectExhibitById(db).get(0);
        msg_al = msg.selectMessageByExb(db, isLast);
        Gson gson = new Gson();
        String json = gson.toJson(this);
        response.getWriter().print(json);
    }
}
