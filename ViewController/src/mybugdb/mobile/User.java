package mybugdb.mobile;

import java.util.HashMap;
import java.util.List;

public class User {
    private String m_userName;
    private String m_userID;
    private String m_teamName;
    private HashMap m_teamMembers;
    private String m_jobTile;
    private String m_email;
    private String m_manager;
    public User() {
        super();
    }

    public User(String userName, String userID, String teamName, HashMap teamMembers, String jobTile, String email, String manager) {
        m_userName = userName;
        m_userID = userID;
        m_teamName = teamName;
        m_teamMembers = teamMembers;
        m_jobTile = jobTile;
        m_email = email;
        m_manager = manager;
    }

    public String getManager() {
        return m_manager;
    }

    public void setManager(String manager) {
        m_manager = manager;
    }

    public void setTeamMembers(HashMap teamMembers) {
        m_teamMembers = teamMembers;
    }

    public String getUserName() {
        return m_userName;
    }

    public void setUserName(String userName) {
        m_userName = userName;
    }

    public String getUserID() {
        return m_userID;
    }

    public String getEmail() {
        return m_email;
    }

    public void setEmail(String email) {
        m_email = email;
    }

    public void setUserID(String userID) {
        m_userID = userID;
    }

    public String getTeamName() {
        return m_teamName;
    }

    public void setTeamName(String teamName) {
        m_teamName = teamName;
    }

    public HashMap getTeamMembers() {
        return m_teamMembers;
    }

    public void AddMember(User newMem)
    {
        m_teamMembers.put(newMem.getUserID(), newMem);
    }
    public String getJobTile() {
        return m_jobTile;
    }

    public void setJobTile(String jobTile) {
        m_jobTile = jobTile;
    }
}
