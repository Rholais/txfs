package bean;

import java.sql.*;
import java.util.*;

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
        return java.lang.String.format(
                "UserAccount [user_id=%d,user_name=%s,user_pswd=%s]",
                user_id, user_name, user_pswd
        );
    }

    public int insertUserAccount(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_user where user_name='%s'",
                this.user_name
        );
        ResultSet rs = db.getResultSet(sql);

        try {
            if(rs.next()){
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = java.lang.String.format(
                "insert into tb_user (user_uame,user_pswd) value ('%s','%s')",
                this.user_name, this.user_pswd );
        return db.changeResultSet(sql);
    }

    public int deleteUserAccount(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_user where user_name='%s'",
                this.user_name
        );
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()){
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = java.lang.String.format(
                "delete from tb_user where user_name='%s'",
                this.user_name);
        return db.changeResultSet(sql);
    }

    public int updateUserAccount(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_user where user_name='%s'",
                this.user_name
        );
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()){
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = java.lang.String.format(
                "update tb_user set user_pswd='%s' where user_id=%d",
                this.user_pswd, this.user_id);

        return db.changeResultSet(sql);
    }

    public ArrayList<UserAccount> selectUserAccountById(DB db){
        String sql = java.lang.String.format(
                "select * from tb_user where user_id=%d",
                this.user_id
        );
        ResultSet rs = db.getResultSet(sql);

        ArrayList<UserAccount> al = new ArrayList<UserAccount>();
        try {
            while(rs.next()) {
                UserAccount user = new UserAccount(
                        this.user_id, rs.getString(2),
                        rs.getString(3)
                );
                al.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList<UserAccount> selectUserAccountByName(DB db){
        String sql = java.lang.String.format(
                "select * from tb_user where user_name=%s",
                this.user_name
        );
        ResultSet rs = db.getResultSet(sql);

        ArrayList<UserAccount> al = new ArrayList<UserAccount>();
        try {
            while(rs.next()) {
                UserAccount user = new UserAccount(
                        rs.getInt(1), this.user_name,
                        rs.getString(3)
                );
                al.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}