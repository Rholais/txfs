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
}
