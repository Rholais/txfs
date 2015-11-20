package JavaBean;
import java.sql.*;
/**
 * Created by stiller on 15/11/20.
 */
public class UserMessage {
    private int user_id;
    private String user_name;
    private String user_sex;
    private String user_birth;
    private String user_email;
    private String user_memo;


    public UserMessage() {
        this.user_id = 0;
        this.user_name = null;
        this.user_sex = null;
        this.user_birth = null;
        this.user_email = null;
        this.user_memo = null;
    }

    public UserMessage(String name, String sex, String borth,
                       String email, String memo){
        this.user_id = 0;
        this.user_name = name;
        this.user_sex = sex;
        this.user_birth = birth;
        this.user_email = email;
        this.user_memo = memo;
    }

    public UserMessage(int id, String name, String sex,
                       String birth, String email, String memo){
        this.user_id = id;
        this.user_name = name;
        this.user_sex = sex;
        this.user_birth = birth;
        this.user_email = email;
        this.user_memo = memo;
    }

    public void setUser_id(int id){
        this.user_id = id;
    }
    public void setUser_name(String name){
        this.user_name = name;
    }
    public void setUser_sex(String sex){
        this.user_sex = sex;
    }
    public void setUser_birth(String birth){
        this.user_birth = birth;
    }
    public void setUser_email(String email){
        this.user_email = email;
    }
    public void setUser_memo(String memo){
        this.user_memo = memo;
    }

    public int getUser_id(){
        return this.user_id;
    }
    public String getUser_name(){
        return this.user_name;
    }
    public String getUser_sex(){
        return this.user_sex;
    }
    public String getUser_birth(){
        return this.user_birth;
    }
    public String getUser_email(){
        return this.user_email;
    }
    public String getUser_memo(){
        return this.user_memo;
    }

    @Override
    public String toString(){
        return "UserMessage[user_id=" + this.user_id
                + ",user_name=" + this.user_name
                + ",user_sex=" + this.user_sex
                + ",user_birth=" + this.user_birth
                + ",user_email=" + this.user_email
                + ",user_memo=" + this.user_memo
                + "]";
    }

    public boolean updateUserMessage(DB db){
        String sql = "update tb_userMsg set "
                + "user_sex='" + this.user_sex + "',"
                + "user_birth='" + this.user_birth + "',"
                + "user_email='" + this.user_email + "',"
                + "user_memo='" + this.user_memo + "' "
                + "where user_id='" + this.user_id + "'";
        return db.changeResultSet(sql);
    }

    public UserMessage selectUserMessage(DB db) {
        String sql = "select * from tb_userMsg where "
    }
}
