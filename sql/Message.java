package JavaBean;
import java.sql.*;
import java.time.*;
/**
 * Created by Rholais on 15/11/20.
 */
public class Message {
    private int msg_id;
    private int obj_id;
    private int user_id;
    private String user_name;
    private LocalDateTime msg_time;
    private String msg_addr;
    private int msg_plus;

    public Message() {
        this.msg_id = 0;
        this.obj_id = 0;
        this.user_id = 0;
        this.user_name = null;
        this.msg_time = LocalDateTime.now();
        this.msg_addr = null;
        this.msg_plus = 0;
    }

    public Message(int obj_id, int user_id, String user_name,
                   LocalDateTime msg_time, String msg_addr, int msg_plus) {
        this.msg_id = 0;
        this.obj_id = obj_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.msg_time = LocalDateTime.of(
                msg_time.toDate(), msg_time.toTime());
        this.msg_addr = msg_addr;
        this.msg_plus = msg_plus;
    }

    public Message(int msg_id, int obj_id, int user_id,
                   String user_name, LocalDateTime msg_time,
                   String msg_addr, int msg_plus) {
        this.msg_id = msg_id;
        this.obj_id = obj_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.msg_time = msg_time.clone();
        this.msg_addr = msg_addr;
        this.msg_plus = msg_plus;
    }

    public void setMsg_id(int msg_id) { this.msg_id = msg_id; }
    public void setObj_id(int obj_id) { this.obj_id = obj_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setUser_name(String user_name) { this.user_name = user_name; }
    public void setMsg_time(LocalDateTime msg_time) { this.msg_time = msg_time.clone(); }
    public void setMsg_addr(String msg_addr) { this.msg_addr = msg_addr; }
    public void setMsg_plus(int msg_plus) { this.msg_plus = msg_plus; }


}