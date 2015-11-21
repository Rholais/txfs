package JavaBean;

import java.sql.*;

/**
 * Created by stiller on 15/11/18.
 */
public class UserAccount {

    private int user_id;
    private String user_name;
    private String user_pswd;

    public UserAccount(String name,String pass){
        this.user_id=0;
        this.user_name=name;
        this.user_pswd=pass;
    }

    public UserAccount(int id,String name,String pass){
        this.user_id=id;
        this.user_name=name;
        this.user_pswd=pass;
    }
    public UserAccount(){
        this.user_id=0;
        this.user_name=null;
        this.user_pswd=null;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public String getUser_name(){
        return this.user_name;
    }

    public String getUser_pswd(){
        return this.user_pswd;
    }

    public void setUser_id(int id){
        this.user_id=id;
    }

    public void setUser_name(String name){
        this.user_name=name;
    }
    public void setUser_pswd(String pass){
        this.user_pswd=pass;
    }

    @Override
    public String toString(){
        return "UserAccount [user_id=" + user_id
                + ",user_name=" + user_name
                + ",user_pswd=" + user_pswd
                + "]";
    }

    public boolean insertUserAccount(DB db) {
        String sql = "select * from tb_user where user_name='"
                + this.user_name + "'";
        ResultSet rs = db.getResultSet(sql);

        try {
            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = java.lang.String.format(
                "insert into tb_user (user_uame,user_pswd) value (%d,%s,%s)",
                user_name, user_pswd );
        return  db.changeResultSet(sql);
    }

    public boolean updateUserAccount(DB db) {
        String sql = "select * from tb_user where user_name='"
                + this.user_name + "'";
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql="update tb_user set "
                + "user_pswd='" + this.user_pswd + "' "
                + "where user_id=" + this.user_id;

        return db.changeResultSet(sql);
    }

    public UserAccount selectUserAccountById(DB db){
        String sql = "select * from tb_user where user_id="
                + this.user_id;
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()) return null;
            this.setUser_name(rs.getString(2));
            this.setUser_pswd(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public UserAccount selectUserAccountByName(DB db){
        String sql = "select * from tb_user where user_name="
                + this.user_name;
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()) return null;
            this.setUser_id(rs.getInt(1));
            this.setUser_pswd(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }
}
