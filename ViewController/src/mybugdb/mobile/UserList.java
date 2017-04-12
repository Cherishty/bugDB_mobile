package mybugdb.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserList {
    public List getUserList() {
        return m_userList;
    }

    private List m_userList;
    public UserList(int test)
    {
        ArrayList temp=new ArrayList();
        temp.add(new User("cty", 6666,"DevChina",null,"CTO","cty@com"));
        m_userList=new ArrayList();
        m_userList.add(new User("zy", 8888,"DevChina",temp,"CEO","zy@com"));
        m_userList.add(new User("cty", 6666,"DevChina",null,"CTO","cty@com"));

    }
    public void Add(User user)
    {
        m_userList.add(user);
    }
}
