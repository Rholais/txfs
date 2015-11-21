package mid;

import java.io.IOException;
import java.util.ArrayList;

import bean.*;
import com.google.gson.Gson;

/**
 * Created by lhch on 2015/11/21 0021.
 */
public class ExbServlet extends javax.servlet.http.HttpServlet {

    private Exhibit exb;
    private ArrayList<Message> msg_al;

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
        int exb_id = Integer.parseInt(request.getParameter("id"));
        exb = new Exhibit(exb_id);
        Message msg = new Message(0, exb_id, 0);
        DB db = new DB();
        exb = exb.selectExhibitById(db).get(0);
        msg_al = msg.selectMessageByExb(db);
        Gson gson = new Gson();
        String json = gson.toJson(this);
        response.getWriter().print(json);
    }
}
