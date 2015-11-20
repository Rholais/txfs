package JavaBean;
import java.sql.*;
/**
 * Created by Rholais on 15/11/20.
 */
public class Exhibit {
    private int exb_id;
    private String exb_name;
    private String exb_imageaddr;
    private String exb_demo;

    public Exhibit() {
        this.exb_id = 0;
        this.exb_name = null;
        this.exb_imageaddr = null;
        this.exb_demo = null;
    }

    public Exhibit(String exb_name, String exb_imageaddr,
                   String exb_demo) {
        this.exb_id = 0;
        this.exb_name = exb_name;
        this.exb_imageaddr = exb_imageaddr;
        this.exb_demo = exb_demo;
    }

    public Exhibit(int exb_id, String exb_name,
                   String exb_imageaddr, String exb_demo) {
        this.exb_id = exb_id;
        this.exb_name = exb_name;
        this.exb_imageaddr = exb_imageaddr;
        this.exb_demo = exb_demo;
    }

    public void setExb_id(int exb_id) {
        this.exb_id = exb_id;
    }

    public void setExb_name(String exb_name) {
        this.exb_name = exb_name;
    }

    public void setExb_imageaddr(String exb_imageaddr) {
        this.exb_imageaddr = exb_imageaddr;
    }

    public void setExb_demo(String exb_demo) {
        this.exb_demo = exb_demo;
    }

    public int getExb_id() {
        return exb_id;
    }

    public String getExb_name() {
        return exb_name;
    }

    public String getExb_imageaddr() {
        return exb_imageaddr;
    }

    public String getExb_demo() {
        return exb_demo;
    }

    @Override
    public String toString() {
        return "Exhibit[exb_id=" + this.exb_id
                + ",exb_name=" + this.exb_name
                + ",exb_imageaddr=" + this.exb_imageaddr
                + ",exb_demo=" this.exb_demo
                + "]";
    }

    public boolean updateExhibit(DB db) {
        String sql = "update tb_exb set "
                + "exb_id='" + this.exb_id
                + "',exb_name='" + this.exb_name
                + "',exb_imageaddr='" + this.exb_imageaddr
                + "',exb_demo='" + this.exb_demo
                + "'";
        return db.changeResultSet(sql);
    }

    public Exhibit selectExhibit(DB db) {
        String sql = "select * from tb_exb where exb_id='"
                + this.exb_id + "'";
        ResultSet rs = db.getResultSet(sql);

        try {
            if(!rs.next()) { return null; }
            this.setExb_name(rs.getString(2));
            this.setExb_imageaddr(rs.getString(3));
            this.setExb_demo(rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this
    }
}
