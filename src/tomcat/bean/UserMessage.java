package bean;

import java.sql.*;
import java.time.*;
import java.util.*;

/**
 * Created by stiller on 15/11/20.
 */
public class UserMessage {
    private int user_id;
    private String user_name;
    private String user_sex;
    private LocalDate user_birth;
    private String user_email;
    private String user_memo;


    public UserMessage() {
        this.user_id = 0;
        this.user_name = null;
        this.user_sex = null;
        this.user_birth = LocalDate.now();
        this.user_email = null;
        this.user_memo = null;
    }

    public UserMessage(String name, String sex, LocalDate birth,
                       String email, String memo){
        this.user_id = 0;
        this.user_name = name;
        this.user_sex = sex;
        this.user_birth = birth;
        this.user_email = email;
        this.user_memo = memo;
    }

    public UserMessage(int id, String name, String sex,
                       LocalDate birth, String email, String memo){
        this.user_id = id;
        this.user_name = name;
        this.user_sex = sex;
        this.user_birth = LocalDate.parse(birth.toString());
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
    public void setUser_birth(LocalDate birth){
        this.user_birth = LocalDate.parse(birth.toString());
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
    public LocalDate getUser_birth(){
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
        return java.lang.String.format(
                "UserMessage[user_id=%d,user_name=%s,user_sex=%s,user_birth=%s,user_email=%s,user_memo=%s]",
                this.user_id, this.user_name, this.user_sex,
                this.user_birth.toString(), this.user_email,
                this.user_memo);
    }

    public int insertUserMessage(DB db) {
        String sql = java.lang.String.format(
                "insert into tb_userMsg (user_id,user_name,user_sex,user_birth,user_email,user_memo) value (%d,'%s','%s','%s','%s','%s')",
                this.user_id, this.user_sex,
                this.user_birth.toString(), this.user_email,
                this.user_memo
        );
        return db.changeResultSet(sql);
    }

    public int deleteUserMessage(DB db) {
        String sql = java.lang.String.format(
                "delete from tb_userMsg where user_id=%d",
                this.user_id
        );
        return db.changeResultSet(sql);
    }

    public int updateUserMessage(DB db){
        String sql = java.lang.String.format(
                "update tb_userMsg set user_sex='%s',user_birth='%s',user_email='%s',user_memo='%s' where user_id=%d",
                this.user_sex, this.user_birth.toString(),
                this.user_email, this.user_memo, this.user_id);
        return db.changeResultSet(sql);
    }

    public ArrayList<UserMessage> selectUserMessageById(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_userMsg where user_id=%d",
                this.user_id);
        ResultSet rs = db.getResultSet(sql);

        ArrayList<UserMessage> al = new ArrayList<UserMessage>();
        try {
            while(rs.next()) {
                UserMessage userMsg = new UserMessage(
                        this.user_id, rs.getString(2),
                        rs.getString(3),
                        LocalDate.parse(rs.getString(4)),
                        rs.getString(5), rs.getString(6)
                );
                al.add(userMsg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}
