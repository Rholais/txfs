package JavaBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by stiller on 15/11/18.
 */
public class UserAccount {

    private int user_id;
    private String user_username;
    private String user_password;

    public UserAccount(String name,String pass){
        this.user_id=0;
        this.user_username=name;
        this.user_password=pass;
    }

    public UserAccount(int id,String name,String pass){
        this.user_id=id;
        this.user_username=name;
        this.user_password=pass;
    }
    public UserAccount(){
        this.user_id=0;
        this.user_username=null;
        this.user_password=null;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public String getUser_username(){
        return this.user_username;
    }

    public String getUser_password(){
        return this.user_password;
    }

    public void setUser_id(int id){
        this.user_id=id;
    }

    public void setUser_username(String name){
        this.user_username=name;
    }
    public void setUser_password(String pass){
        this.user_password=pass;
    }

    @Override
    public String toString(){
        return "UserAccount [user_id="+user_id+",user_username="+user_username+",user_password="+user_password+"]";
    }

    public boolean updateUserAccount(DB db){
        String sql=null;
        sql="select * from tb_user where user_username='"+this.user_username+"'";
        ResultSet rs=db.getResultSet(sql);

        try {
            if(!rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql="update tb_user set "
                + "user_password='" + this.user_password + "' "
                + "where user_id='" + this.user_id + "'";

        return db.changeResultSet(sql);
    }

    public UserAccount selectUserAccount(DB db){
        String sql = "select * from tb_user where user_id='"
                + this.user_id + "'";
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()) return null;
            this.setUser_username(rs.getString(2));
            this.setUser_password(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }
}
