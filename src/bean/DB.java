package bean;
import java.sql.*;
/**
 * Created by stiller on 15/11/18.
 */
public class DB {

    Connection con = null;
    Statement stm = null;

    public DB(){

        getCon();

    }

    private void getCon(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/transformers?userUnicode=true&characterEncoding=utf8", "root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getStatement(Connection con){
        if(con != null){
            try {
                stm=con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getResultSet(String sql){
        ResultSet rs=null;

        if(stm!=null){
            try {
                PreparedStatement pst=con.prepareStatement(sql);
                rs=pst.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public int changeResultSet(String sql){
        int rs = 0;
        if(con != null){
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                rs = pst.executeUpdate();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return rs;
    }

    public void close() throws SQLException{
        if(stm != null)
            stm.close();
        if(con != null)
            con.close();
    }


}
