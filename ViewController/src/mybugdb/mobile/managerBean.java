package mybugdb.mobile;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

public class managerBean {
    private String m_filter = "";
    private String m_username = "";
    private String m_loginusername = "";
    private String m_password = "";
    private String m_bugtalktext = "";
    private static List s_employees = null;
    private static final String SORTLNAME = "LAST_NAME";
    private static final String SORTIDDESC = "EMPLOYEE_ID DESC";
    private static final String SORTID = "EMPLOYEE_ID";
    private static final int ALLRECORDS = -1;
    private HashMap m_allBugs = null;
    private HashMap m_saveSearch=null;
    private List m_allTalks=null;
    
    private Bug m_oriSearchBug=null;
    private Bug m_updSearchBug=null;

    public managerBean() {
    }

    private void initAllBugs(){
        m_allBugs=(new BugList(1)).getBugList();
    }
    private void initSaveSearch(){
        m_saveSearch=(new BugList("1")).getBugList();
    }
  
    private void initAllTalks(){
        m_allTalks=(new TalkList(1)).getTalkList();
    }

    public void setFilter(String filter) {
        String oldFilter = this.m_filter;
        this.m_filter = filter;
    }

    public void updateSearchPage() {

        String remark="";
        if(m_oriSearchBug.getAssignee()!=m_updSearchBug.getAssignee())
            remark+="Assign ->"+m_updSearchBug.getAssignee();
        if(m_oriSearchBug.getStatus()!=m_updSearchBug.getStatus())
            remark+="  Stauts ->"+m_updSearchBug.getStatus();
        if(m_oriSearchBug.getSeverity()!=m_updSearchBug.getSeverity())
            remark+="  Severity ->"+m_updSearchBug.getSeverity();
        if(!remark.equals(""))
            m_allTalks.add(new Talk(m_filter, m_username, new Date(), remark));
        
        if (m_bugtalktext.length() > 0) {
            if (flagOfAdvanced == true) {
                m_allTalks.add(new Talk(bugnumdata, m_username, new Date(), m_bugtalktext));
            } else {
                m_allTalks.add(new Talk(m_filter, m_username, new Date(), m_bugtalktext));
            }
            m_bugtalktext = "";
        }
        if(!remark.equals("") && m_bugtalktext.length() > 0)
        {
            m_updSearchBug.setLastEdit(new Date());
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
        flagOfAdvanced =false;
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

    private Bug m_condition=new Bug();

    public Bug getCondition() {
        return m_condition;
    }

    public void setCondition(Bug condition) {
        m_condition = condition;
    }

    public void executeAdvanced(){
        bugnumdata=bugnum;
        m_condition=new Bug();
    }

    private boolean flagOfAdvanced = false;
    private String bugnum="";
    private String bugnumdata="";

    public void AddSaveCondition()
    {
        HashMap saveSearch=getSaveSearch();
        saveSearch.put(m_condition.getBugNumber(),m_condition);
    }

    public Bug[] getAdvancedBug(){
        flagOfAdvanced =true;
        String assignee=m_condition.getAssignee();
        String customer=m_condition.getCustomer();
        String status= m_condition.getStatus();
        String severity=m_condition.getSeverity();
        String product=m_condition.getProduct();
        Date lastEdit=m_condition.getLastEdit();
        HashMap bugMap =getAllBugs();
        ArrayList result= new ArrayList();
        Iterator iter = bugMap.entrySet().iterator();
        while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        Bug val = (Bug)entry.getValue();
            if(assignee.length()==0||val.getAssignee().equals(assignee)){
                if(val.getCustomer().equals(customer)||customer.length()==0){
                    if(val.getStatus().equals(status)||status.length()==0){
                        if(val.getSeverity().equals(severity)||severity.length()==0){
                            if(val.getProduct().equals(product)||product.length()==0){
                                    result.add(val);
                                bugnum =val.getBugNumber();
                            }
                        }
                    }
                }
            }
         
                
        }
        Bug result1[]=new Bug[result.size()];
        return (Bug[])result.toArray(result1);

    }

    public Bug getSearchedBug(){
        String sub ="";
        if( flagOfAdvanced ==true){
          sub =  bugnumdata;
        }
        else{
         sub= getFilter();
        }
        Bug result= (Bug)(getAllBugs().get(sub));
        m_oriSearchBug=new Bug(result);
        m_updSearchBug=result;
        return result;
    }
    
    public Talk[] getRelatedTalkList(){
        String sub="";
        if( flagOfAdvanced ==true){
          sub =  bugnumdata;
        }
        else{
         sub= getFilter();
        }
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
    
    public Bug[] getAssignedBug(){
        String sub= m_username;
        ArrayList result= new ArrayList();
        HashMap allBugs=getAllBugs();
        
        Iterator iter = allBugs.entrySet().iterator();
        while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        Bug val = (Bug)entry.getValue();
            if(val.getAssignee().equals(sub)){
                result.add(val);
            }
                
        }
        Bug result1[]=new Bug[result.size()];
        return (Bug[])result.toArray(result1);
    }

    private HashMap getAllBugs() 
    {
        if(m_allBugs == null){
            initAllBugs();
        }
        
        return m_allBugs;
    }

    private HashMap getSaveSearch()
    {
        if(m_saveSearch == null){
            initSaveSearch();
        }

        return m_saveSearch;
    }
    public Bug[] getSaveSearchArray()
    {
        ArrayList result= new ArrayList();
        Iterator iter = getSaveSearch().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Bug val = (Bug)entry.getValue();
            result.add(val);
        }

        Bug result1[]=new Bug[result.size()];
        return (Bug[])result.toArray(result1);

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
    
    private Date date=null;
    public void setDate(Date ddate){
        date=ddate;
    }
    public Date getDate(){
        return date;
    }
    
    public Bug[] getOpendedBug(){
        Date selectedDate = getDate();
        List result= new ArrayList();
        HashMap allBugs=getAllBugs(); 
        Iterator iter = allBugs.entrySet().iterator();
        while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        Bug val = (Bug)entry.getValue();
            if(val.getLastEdit().after(selectedDate)){
                result.add(val);
            }       
        }
        Bug result1[]=new Bug[result.size()];
        result.toArray(result1);
        List result2= new ArrayList();
        for(int i=0;i<result.size();i++){
            if(result1[i].getStatus().equals("30")||result1[i].getStatus().equals("80"))   
                result2.add(result1[i]);
        }
        Bug result3[]=new Bug[result2.size()];
        return (Bug [])result2.toArray(result3);
    }
}

