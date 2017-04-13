package mybugdb.mobile;

import java.util.*;

public class BugList {

    private  HashMap m_bugList;

    public HashMap getBugList() {
        return m_bugList;
    }
    
    public BugList()
    {
        super();    
    }
    public BugList(int test) {
        
        m_bugList = new HashMap();
        //public Bug(String bugNumber, String assignee, String creator, String customer, int status, String severity, String product, String component, Date lastEdit, List actionHistoryList) {
        m_bugList.put("0001",new Bug("zy", "0001", "come with me"));
        m_bugList.put("0002",new Bug("zy", "0002", "for a little ride"));
        m_bugList.put("0003",new Bug("zy", "0003", "look at the sun"));
        m_bugList.put("0004",new Bug("zy", "0004", "see the clouds"));
        m_bugList.put("0005",new Bug("zy", "0005", "turn to faces"));
        m_bugList.put("0006",new Bug("zy", "0006", "in the sky"));
        m_bugList.put("0007",new Bug("zy", "0007", "we've been awake"));
        m_bugList.put("0008",new Bug("zy", "0008", "all night"));
        m_bugList.put("0009",new Bug("zy", "0009", "close your sad"));
        m_bugList.put("0010",new Bug("zy", "0010", "we will be safe and sound"));
        m_bugList.put("0011",new Bug("zy", "0011", "come with me"));
        m_bugList.put("0012",new Bug("zy", "0012", "for a little ride"));
        m_bugList.put("0013",new Bug("zy", "0013", "see a shadows passing by"));
        m_bugList.put("0014",new Bug("zy", "0014", "look at the sun"));
        m_bugList.put("0015",new Bug("zy", "0015", "see the clouds"));
        m_bugList.put("0016",new Bug("zy", "0016", "turn to faces in the sky"));
        m_bugList.put("0017",new Bug("zy", "0017", "daydreaming lightly through the rain"));
        m_bugList.put("0018",new Bug("zy", "0018", "allis forgiven on a summer train"));
        m_bugList.put("0019",new Bug("zy", "0019", "come with me"));
        m_bugList.put("0020",new Bug("zy", "0020", "for a little ride"));
    }
    public void Add(Bug bug)
    {
        m_bugList.put(bug.getBugNumber() ,bug);
    }
}
