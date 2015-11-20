package JavaBean;
import java.sql.*;
/**
 * Created by stiller on 15/11/18.
 */
public class UserMessage {
    private int user_id;
    private String user_name;
    private String user_sex;
    private String user_borth;
    private String user_memo;

    public UserMessage(){
        this.user_id=0;
        this.user_name=null;
        this.user_sex=null;
        this.user_borth=null;
        this.user_memo=null;
    }

    public UserMessage(int id,String name,String sex,String borth,String memo){
        this.user_id=id;
        this.user_name=name;
        this.user_borth=borth;
        this.user_sex=sex;
        this.user_memo=memo;
    }

    public UserMessage(String name,String sex,String borth,String memo){
        this.user_id=0;
        this.user_name=name;
        this.user_borth=borth;
        this.user_sex=sex;
        this.user_memo=memo;
    }

    public void setUser_id(int id){
        this.user_id=id;
    }
    public void setUser_name(String name){
        this.user_name=name;
    }
    public void setUser_sex(String sex){
        this.user_sex=sex;
    }
    public void setUser_borth(String borth){
        this.user_borth=borth;
    }
    public void setUser_memo(String memo){
        this.user_memo=memo;
    }

    public int getUser_id(){
        return this.user_id;
    }
    public String getUser_name(){
        return this.user_name;
    }
    public String getUser_borth(){
        return this.user_borth;
    }
    public String getUser_sex(){
        return this.user_sex;
    }
    public String getUser_memo(){
        return this.user_memo;
    }

    @Override
    public String toString(){
        return "UserMessage[user_id="+this.user_id+",user_name="+this.user_name+",user_sex="+this.user_sex+"," +
                "user_borth="+this.user_borth+",user_memo="+this.user_memo+"]";
    }

    public boolean reUserMessage(DB db){
        String sql="update tb_userMsg set user_name='"+this.user_name+"',user_borth='"+this.user_borth+"'," +
                "user_sex='"+this.user_sex+"',user_memo='"+this.user_memo+"'";
        int res=db.changeResultSet(sql);
        if(res>0)
            return true;
        else
            return false;
    }



















}
