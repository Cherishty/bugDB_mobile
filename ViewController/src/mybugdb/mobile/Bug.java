package mybugdb.mobile;
import java.util.*;
public class Bug {

    private String m_bugNumber;
    private String m_assignee;
    private String m_creator;
    private String m_customer;
    private int m_status;//状�?
    private String m_severity;//�?�?�?
    private String m_product;//产�?�??称
    private String m_component;//组件�??称
    private Date m_lastEdit;
    private List m_actionHistoryList;

    public Bug() {
        super();
    }

    public Bug(String assignee, String bugNumber, String text) {
        m_bugNumber = bugNumber;
        m_assignee = assignee;
        m_creator = text;
        m_customer = "Frederic";
        m_status = 11;
        m_severity = "S2";
        m_product = "bugDB_Mobile";
        m_component = "bugDB_Mobile";
        m_lastEdit = new Date();
    }

    public Bug(String bugNumber, String assignee, String creator, String customer, int status, String severity, String product, String component, Date lastEdit, List actionHistoryList) {
        m_bugNumber = bugNumber;
        m_assignee = assignee;
        m_creator = creator;
        m_customer = customer;
        m_status = status;
        m_severity = severity;
        m_product = product;
        m_component = component;
        m_lastEdit = lastEdit;
        m_actionHistoryList = actionHistoryList;
    }

    public String getCreator() {
        return m_creator;
    }

    public void setCreator(String creator) {
        m_creator = creator;
    }

    public List getActionHistoryList() {
        return m_actionHistoryList;
    }

    public void addActionHistoryList(ActionHistory actionHistory) {
        m_actionHistoryList.add(actionHistory);
    }

    public String getBugNumber() {
        return m_bugNumber;
    }

    public void setBugNumber(String bugNumber) {
        m_bugNumber = bugNumber;
    }

    public String getAssignee() {
        return m_assignee;
    }

    public void setAssignee(String assignee) {
        m_assignee = assignee;
    }

    public String getText() {
        return m_creator;
    }

    public void setText(String text) {
        m_creator = text;
    }

    public String getCustomer() {
        return m_customer;
    }

    public void setCustomer(String customer) {
        m_customer = customer;
    }

    public int getStatus() {
        return m_status;
    }

    public void setStatus(int status) {
        m_status = status;
    }

    public String getSeverity() {
        return m_severity;
    }

    public void setSeverity(String severity) {
        m_severity = severity;
    }

    public String getProduct() {
        return m_product;
    }

    public void setProduct(String product) {
        m_product = product;
    }

    public String getComponent() {
        return m_component;
    }

    public void setComponent(String component) {
        m_component = component;
    }

    public Date getLastEdit() {
        return m_lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        m_lastEdit = lastEdit;
    }

}
