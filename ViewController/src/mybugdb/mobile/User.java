package mybugdb.mobile;

import java.util.List;

public class User {
    private String m_userName;
    private int m_userID;
    private String m_teamName;
    private List m_teamMembers;
    private String m_jobTile;
    private String m_email;

    public User() {
        super();
    }

    public User(String userName, int userID, String teamName, List teamMembers, String jobTile, String email) {
        m_userName = userName;
        m_userID = userID;
        m_teamName = teamName;
        m_teamMembers = teamMembers;
        m_jobTile = jobTile;
        m_email = email;
    }

    public String getUserName() {
        return m_userName;
    }

    public void setUserName(String userName) {
        m_userName = userName;
    }

    public int getUserID() {
        return m_userID;
    }

    public String getEmail() {
        return m_email;
    }

    public void setEmail(String email) {
        m_email = email;
    }

    public void setUserID(int userID) {
        m_userID = userID;
    }

    public String getTeamName() {
        return m_teamName;
    }

    public void setTeamName(String teamName) {
        m_teamName = teamName;
    }

    public List getTeamMembers() {
        return m_teamMembers;
    }

    public void AddMember(User newMem)
    {
        m_teamMembers.add(newMem);
    }

    public User GetMemberInfoByName(String name)
    {
        for (int i=0;i<m_teamMembers.size();i++)
        {
            User currentUser=(User)(m_teamMembers.get(i));
            if(currentUser.getUserName().equals(name))
                return currentUser;
        }
        return null;
    }

    public User GetMemberInfoByID(int ID)
    {
        for (int i=0;i<m_teamMembers.size();i++)
        {
            User currentUser=(User)(m_teamMembers.get(i));
            if(currentUser.getUserID()==ID)
                return currentUser;
        }
        return null;
    }

    public String getJobTile() {
        return m_jobTile;
    }

    public void setJobTile(String jobTile) {
        m_jobTile = jobTile;
    }
}
