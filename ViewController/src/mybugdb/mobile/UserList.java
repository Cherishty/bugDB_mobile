package mybugdb.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserList {
    public HashMap getUserList() {
        return m_userList;
    }

    private HashMap m_userList;
    public UserList(int test)
    {
        HashMap temp=new HashMap();
        //public User(String userName, String userID, String teamName, HashMap teamMembers, String jobTile, String email, String manager) {
        User cty=new User("cty", "6666","DevChina",null,"CTO","cty@com","zy");
        temp.put(cty.getUserID(),cty);
        m_userList=new HashMap();
        m_userList.put("8888", new User("zy", "8888","DevChina",temp,"CEO","zy@com","wyp"));
        m_userList.put("6666",new User("cty", "6666","DevChina",null,"CTO","cty@com","zy"));

    }
    public void Add(User user)
    {
        m_userList.put(user.getUserID(),user);
    }
}
