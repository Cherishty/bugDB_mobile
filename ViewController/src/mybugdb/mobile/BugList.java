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
        m_bugList.put("1111",new Bug("wjm", "1111", "wewe"));
        m_bugList.put("2222",new Bug("cty", "2222", "frty"));
        m_bugList.put("3333",new Bug("zy", "3333", "rtgr"));
        m_bugList.put("5555",new Bug("wyp", "5555", "rtwr"));
        m_bugList.put("6666",new Bug("zy", "6666", "rg4w"));
    }
}
