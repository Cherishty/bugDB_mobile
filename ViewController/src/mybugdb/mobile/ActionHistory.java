package mybugdb.mobile;
import java.util.*;
public class ActionHistory {
    private String changer;
    private  int Status;
    private  Date date;
    public ActionHistory() {
        super();
    }

    public ActionHistory(String changer, int status, Date date) {
        this.changer = changer;
        Status = status;
        this.date = date;
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
