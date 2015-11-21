package JavaBean;

import java.sql.*;
import java.util.*;

/**
 * Created by Rholais on 15/11/20.
 */
public class Exhibit {
    private int exb_id;
    private String exb_name;
    private String exb_imageaddr;
    private String exb_demo;
    private int exb_num;

    public Exhibit() {
        this.exb_id = 0;
        this.exb_name = null;
        this.exb_imageaddr = null;
        this.exb_demo = null;
        this.exb_num = 0;
    }

    public Exhibit(String exb_name, String exb_imageaddr,
                   String exb_demo, int exb_num) {
        this.exb_id = 0;
        this.exb_name = exb_name;
        this.exb_imageaddr = exb_imageaddr;
        this.exb_demo = exb_demo;
        this.exb_num = exb_num;
    }

    public Exhibit(int exb_id, String exb_name,
                   String exb_imageaddr, String exb_demo,
                   int exb_num) {
        this.exb_id = exb_id;
        this.exb_name = exb_name;
        this.exb_imageaddr = exb_imageaddr;
        this.exb_demo = exb_demo;
        this.exb_num = exb_num;
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

    public void setExb_num(int exb_num) {
        this.exb_num = exb_num;
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

    public int getExb_num() {
        return exb_num;
    }

    @Override
    public String toString() {
        return java.lang.String.format(
                "Exhibit[exb_id=%d,exb_name=%s,exb_imageaddr=%s,exb_demo=%s,exb_num=%d]",
                this.exb_id, this.exb_name, this.exb_imageaddr,
                this.exb_demo, this.exb_num
        );
    }

    public boolean insertExhibit(DB db) {
        String sql = java.lang.String.format(
                "insert into tb_exb (exb_name,exb_imageaddr,exb_demo,exb_num) value (‘%s‘,’%s’,'%s', %d)",
                this.exb_name, this.exb_imageaddr, this.exb_demo,
                this.exb_num
        );
        return  db.changeResultSet(sql);
    }

    public boolean deleteExhibit(DB db) {
        String sql = java.lang.String.format(
                "delete from tb_exb where exb_id=%d", this.exb_id
        );
        return  db.changeResultSet(sql);
    }

    public boolean updateExhibit(DB db) {
        String sql = java.lang.String.format(
                "update tb_exb set exb_name='%s',exb_imageaddr='%s',exb_demo='%s',exb_num=%d where exb_id=%d",
                this.exb_name, this.exb_imageaddr, this.exb_demo,
                this.exb_num, this.exb_id
        );
        return db.changeResultSet(sql);
    }

    public ArrayList<Exhibit> selectExhibitById(DB db) {
        String sql = java.lang.String.format(
                "select * from tb_exb where exb_id=%d",
                this.exb_id);
        ResultSet rs = db.getResultSet(sql);

        ArrayList<Exhibit> al = new ArrayList<Exhibit>();
        try {
            while(rs.next()) {
                Exhibit exb = new Exhibit(
                        this.exb_id, rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5)
                );
                al.add(exb);
            }
            this.setExb_name();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this
    }
}
