package mybugdb.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionHistoryList {
    public List getActionHistoryList() {
        return m_actionHistoryList;
    }

    private List m_actionHistoryList;
    public ActionHistoryList(int test)
    {
        m_actionHistoryList=new ArrayList();
        m_actionHistoryList.add(new ActionHistory("wjm",11,new Date()));
        m_actionHistoryList.add(new ActionHistory("zy",30,new Date()));

    }
    public void Add(ActionHistory actionHistory)
    {
        m_actionHistoryList.add(actionHistory);
    }
}
