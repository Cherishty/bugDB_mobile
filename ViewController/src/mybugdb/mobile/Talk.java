package mybugdb.mobile;
import  java.util.Date;


public class Talk 
{

    private String m_bugNumber;
    private String m_name;
    private Date m_date;
    private String m_text;
    private String m_title;


    public Talk()
    {
        super();
    }
    public Talk(String bugNumber,String name, Date date, String text ) {
        m_name = name;
        m_date = date;
        m_text = text;
        m_bugNumber = bugNumber;
        m_title=name+"  "+date.toString();
    }

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        m_title = title;
    }

    public String getBugNumber() {
        return m_bugNumber;
    }

    public void setBugNumber(String bugNumber) {
        m_bugNumber = bugNumber;
    }



    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public Date getDate() {
        return m_date;
    }

    public void setDate(Date date) {
        m_date = date;
    }

    public String getText() {
        return m_text;
    }

    public void setText(String text) {
        m_text = text;
    }

}


