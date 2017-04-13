package mybugdb.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionHistoryList {

    private List m_actionHistoryList;
    public List getActionHistoryList() {
        return m_actionHistoryList;
    }

    public ActionHistoryList(int test)
    {
        
        m_actionHistoryList=new ArrayList();
        //public ActionHistory(String changer, int status, Date date) 
        m_actionHistoryList.add(new ActionHistory("wjm",11,new Date()));
        m_actionHistoryList.add(new ActionHistory("zy",30,new Date()));

    }
    public void Add(ActionHistory actionHistory)
    {
        m_actionHistoryList.add(actionHistory);
    }
}
