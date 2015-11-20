package JavaBean;
import java.sql.*;
import java.time.*;
/**
 * Created by Rholais on 15/11/20.
 */
public class Message {
    private int msg_id;
    private int exb_id;
    private int user_id;
    private String user_name;
    private LocalDateTime msg_time;
    private String msg_addr;
    private int msg_plus;

    public Message() {
        this.msg_id = 0;
        this.exb_id = 0;
        this.user_id = 0;
        this.user_name = null;
        this.msg_time = LocalDateTime.now();
        this.msg_addr = null;
        this.msg_plus = 0;
    }

    public Message(int exb_id, int user_id, String user_name,
                   LocalDateTime msg_time, String msg_addr, int msg_plus) {
        this.msg_id = 0;
        this.exb_id = exb_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.msg_time = msg_time.clone());
        this.msg_addr = msg_addr;
        this.msg_plus = msg_plus;
    }

    public Message(int msg_id, int exb_id, int user_id,
                   String user_name, LocalDateTime msg_time,
                   String msg_addr, int msg_plus) {
        this.msg_id = msg_id;
        this.exb_id = exb_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.msg_time = msg_time.clone();
        this.msg_addr = msg_addr;
        this.msg_plus = msg_plus;
    }

    public void setMsg_id(int msg_id) { this.msg_id = msg_id; }
    public void setObj_id(int exb_id) { this.exb_id = exb_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setUser_name(String user_name) { this.user_name = user_name; }
    public void setMsg_time(LocalDateTime msg_time) { this.msg_time = msg_time.clone(); }
    public void setMsg_addr(String msg_addr) { this.msg_addr = msg_addr; }
    public void setMsg_plus(int msg_plus) { this.msg_plus = msg_plus; }

    public int getMsg_id() { return this.msg_id; }
    public int getObj_id() { return this.exb_id; }
    public int getUser_id() { return this.user_id; }
    public String getUser_name() { return this.user_name; }
    public LocalDateTime getMsg_time() { return this.msg_time; }
    public String getMsg_addr() { return this.msg_addr; }
    public int getMsg_plus() { return msg_plus; }

    @Override
    public String toString() {
        return java.lang.String.format(
                "Message[msg_id=%d,exb_id=%d,user_id=%d,user_name=%s,msg_time=%s,msg_addr=%s,msg_plus=%d]",
                this.msg_id, this.exb_id, this.user_id,
                this.user_name, this.msg_time.toString(),
                this.msg_addr, this.msg_plus);
    }

    public boolean updateMessage(DB db) {
        String sql = java.lang.String.format(
                "update tb_msg set exb_id=%d,user_id=%d,user_name='%s',msg_time='%s',msg_addr='%s',msg_plus=%d where msg_id=%d",
                this.exb_id, this.user_id, this.user_name,
                this.msg_time.toString(), this.msg_addr,
                this.msg_plus, this.msg_id);
        return db.changeResultSet(sql);
    }

    public Message selectMessage(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_msg where msg_id=%d",
                this.msg_id);
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()) { return null; }
            this.setObj_id(rs.getInt(2));
            this.setUser_id(rs.getInt(3));
            this.setUser_name(rs.getString(4));
            this.setMsg_time(LocalDateTime.parse(rs.getString(5)));
            this.setMsg_addr(rs.getString(6));
            this.setMsg_plus(rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this
    }
}