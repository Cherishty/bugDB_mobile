package mybugdb.mobile;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeSupport;


public class managerBean {
    private String m_filter = "";
    private String m_username = "";
    private String m_loginusername = "";
    private String m_password = "";
    private String m_bugtalktext = "";
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private static List s_employees = null;
    private static final String SORTLNAME = "LAST_NAME";
    private static final String SORTIDDESC = "EMPLOYEE_ID DESC";
    private static final String SORTID = "EMPLOYEE_ID";
    private static final int ALLRECORDS = -1;
    private HashMap m_allBugs = null;
    private List m_allTalks=null;
    

    public managerBean() {
    }
  
    private void initAllBugs(){
        m_allBugs=(new BugList(1)).getBugList();
    }
    
    private void initAllTalks(){
        m_allTalks=(new TalkList(1)).getTalkList();
    }

    public void setFilter(String filter) {
        String oldFilter = this.m_filter;
        this.m_filter = filter;
    }

    public void updateSearchPage(){
            if(m_bugtalktext.length()>0){
            m_allTalks.add(new Talk(m_filter, m_username,new Date(),m_bugtalktext));
            m_bugtalktext = "";
            }          
        }
    
    public void setBugTalkText(String bugtalktext ){
        m_bugtalktext = bugtalktext;
    }
    
    public String getBugTalkText(){
       return  m_bugtalktext;
    }
    public String getFilter() {
        return m_filter;
    }
    
    public void setClearFilter(){
        m_filter ="";
    }
    
    
    public void setPassWord(String password) {
        String oldpassword = this.m_password;
        this.m_password = password;
    }

    public String getPassWord() {
        return m_password;
    }
    
    public void setUserName(String username) {
        String oldusername = this.m_username;
        this.m_username = username;
    }

    public String getLoginUserName() {
        return m_username;
    }
    
    public void setLoginUserName() {
        executeLoginUserName();
    }

    public String getUserName() {
        return m_username;
    }
    
    public void executeLoginUserName() {
           m_loginusername = getUserName();
    }

    
    public void getResetLoginUserName() {
           m_loginusername ="";
           m_username ="";
           m_password ="";
           m_allBugs = null;
           m_allTalks=null;
        
    }
    
// handle DB data    
    public void Execute() {
//        s_employees.clear();
//        String filter = getFilter();
//        String whereClause = "";
//        if (filter.length() > 0) {
//            whereClause += "FIRST_NAME LIKE '%" + filter + "%' OR LAST_NAME LIKE '%" + filter + "%'";
//        }
//       
//        s_employees = selectBugsFromDB(whereClause, SORTLNAME, ALLRECORDS);
//        ..........................give  s_employees to searchBug  to get wanted BU
    }
    
    private ArrayList selectBugsFromDB(String filter, String order, int maxRecords) {
        ArrayList empList = new ArrayList();

        try {
            Connection conn = DBConnectionFactory.getConnection();
            conn.setAutoCommit(false);
            String select = "SELECT * FROM EMPLOYEES";
            if (filter.length() > 0) {
                select += " WHERE " + filter;
            }
            if (order.length() > 0) {
                select += " ORDER BY " + order;
            }
            if (maxRecords != ALLRECORDS) {
                select += " lIMIT " + maxRecords;
            }
        
            PreparedStatement pStmt = conn.prepareStatement(select);
            ResultSet rs = pStmt.executeQuery();
           
            while (rs.next()) {
//                int id = rs.getInt("EMPLOYEE_ID");
//                String first = rs.getString("FIRST_NAME");
//                String last = rs.getString("LAST_NAME");
//                String email = rs.getString("EMAIL");
//                String phone = rs.getString("PHONE_NUMBER");
//                Date hireDate = rs.getDate("HIRE_DATE");
//                if (hireDate == null) {
//                    hireDate = new Date(0);
//                }
//                
//                
//                String jobId = rs.getString("JOB_ID");
//                double salary = getDouble(rs, "SALARY");
//                double commPct = getDouble(rs, "COMMISSION_PCT");
//                int mgrId = rs.getInt("MANAGER_ID");
//                int deptId = rs.getInt("DEPARTMENT_ID");
//                String emppic = NOPIC;
//
//                String picpath = apppath + "/" + id + ".png";
//                File f = new File(picpath);
//                if (f != null && f.exists()) {
//                    emppic = "file://" + picpath + "?" + System.currentTimeMillis();
//                } else {
//                    byte[] b = rs.getBytes("PIC");
//                    if (b != null && b.length > 0) {
//                        FileOutputStream out = new FileOutputStream(picpath);
//                        out.write(b);
//                        out.close();
//                        emppic = "file://" + picpath + "?" + System.currentTimeMillis();
//                    }
//                }
//                
//                Bugloyee e =
//                    new Bugloyee(id, first, last, email, phone, hireDate, jobId, salary, commPct, mgrId, deptId, emppic,
//                                 false);
//                empList.add(e);
            }
            rs.close();
          
        } catch (SQLException e) {
           
        } catch (Exception e) {
        }
        
        return empList;
    }
    
    public Bug getSearchedBug(){
        String sub= getFilter();
        Bug result= (Bug)(getAllBugs().get(sub));
        return result;
    }
    
    public Talk[] getRelatedTalkList(){
        String sub= getFilter();
        ArrayList result= new ArrayList();
        List allTalks=getAllTalks();
        for (int i=0;i<allTalks.size();i++)
        {
            Talk each=(Talk)allTalks.get(i);
            if (each.getBugNumber().equals(sub))
                result.add(each);
        }
        Talk result1[]=new Talk[result.size()];
        return (Talk[])result.toArray(result1);
    }
    /*public String[] getAssignedBug(){
//       List list1 =new ArrayList();
        List list2 =new ArrayList();
        List list3 =new ArrayList();
         String sub= username;
         for(int i=0;i< AllBugs.size();i++){
             if(((Bug)(AllBugs.get(i))).getName().equals(sub)){
//                 list1.add(((Bug)AllBugs.get(i)).getName()); 
                 list2.add(((Bug)AllBugs.get(i)).getBugnumber()); 
                 list3.add(((Bug)AllBugs.get(i)).getText()); 
             }
               
         }
         String str[]=new String[list2.size()];
         for(int i=0;i<list2.size();i++){
             str[i]=list2.get(i).toString()+"  "+list3.get(i).toString();
         }   
         return str;
    }*/

    private HashMap getAllBugs() 
    {
        if(m_allBugs == null){
            initAllBugs();
        }
        
        return m_allBugs;
    }

    private List getAllTalks() 
    {
        if(m_allTalks == null){
            initAllTalks();
        }
        
        return m_allTalks;
    }
    
    public String  getCheckAccount(){
//        if(m_username.length()==0 || m_password.length() ==0)
//             return "";
//        else
           return "login";
    }
}

