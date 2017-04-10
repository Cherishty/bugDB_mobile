package mybugdb.mobile;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeSupport;


public class managerBean {
    private String filter = "";
    private String username = "";
    private String loginusername = "";
    private String password = "";
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private static List s_employees = null;
    private static final String SORTLNAME = "LAST_NAME";
    private static final String SORTIDDESC = "EMPLOYEE_ID DESC";
    private static final String SORTID = "EMPLOYEE_ID";
    private static final int ALLRECORDS = -1;
    private List s_emps = null;
    

    
    
    public managerBean() {
    }
  
    private void initAllBugs(){
        s_emps = new ArrayList();
        s_emps.add(new Emp("wjm", "1111111", "wewe"));
        s_emps.add(new Emp("cty", "1452145", "frty"));
        s_emps.add(new Emp("zy", "2135874", "rtgr"));
        s_emps.add(new Emp("wyp", "2541237", "rtwr"));
        s_emps.add(new Emp("cty", "1287965", "rg4w"));
        s_emps.add(new Emp("wjm", "1324521", "wew0"));
        s_emps.add(new Emp("cty", "1452545", "frty"));
        s_emps.add(new Emp("zy", "2135244", "rtfe"));
        s_emps.add(new Emp("wyp", "2289637", "rtge"));
        s_emps.add(new Emp("cty", "12321465", "rv2w"));
        s_emps.add(new Emp("wjm", "1498921", "wevdv"));
        s_emps.add(new Emp("cty", "1455245", "fwyh"));
        s_emps.add(new Emp("zy", "2166474", "rdhr"));
        s_emps.add(new Emp("wyp", "2596237", "rtwr"));
        s_emps.add(new Emp("cty", "1211465", "rghw"));
        s_emps.add(new Emp("wjm", "14517521", "wede"));
        s_emps.add(new Emp("cty", "1421345", "frth"));
        s_emps.add(new Emp("zy", "2122174", "rthr"));
        s_emps.add(new Emp("wyp", "2522137", "rtgr"));
        s_emps.add(new Emp("cty", "1228965", "rghw"));
    }
    
    public void setFilter(String filter) {
        String oldFilter = this.filter;
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
    
    public void setClearFilter(){
        filter ="";
    }
    
    
    public void setPassWord(String password) {
        String oldpassword = this.password;
        this.password = password;
    }

    public String getPassWord() {
        return password;
    }
    
    public void setUserName(String username) {
        String oldusername = this.username;
        this.username = username;
    }

    public String getLoginUserName() {
        return username;
    }
    
    public void setLoginUserName() {
        executeLoginUserName();
    }

    public String getUserName() {
        return username;
    }
    
    public void executeLoginUserName() {
           loginusername = getUserName();
    }

    
    public void getResetLoginUserName() {
           loginusername ="";
           username ="";
           password ="";
        
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
//        s_employees = selectEmpsFromDB(whereClause, SORTLNAME, ALLRECORDS);
//        ..........................give  s_employees to searchBug  to get wanted BU
    }
    
    private ArrayList selectEmpsFromDB(String filter, String order, int maxRecords) {
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
//                Employee e =
//                    new Employee(id, first, last, email, phone, hireDate, jobId, salary, commPct, mgrId, deptId, emppic,
//                                 false);
//                empList.add(e);
            }
            rs.close();
          
        } catch (SQLException e) {
           
        } catch (Exception e) {
        }
        
        return empList;
    }
    
    public Emp[] getSearchedBug(){
        List list1 =new ArrayList();
         List list2 =new ArrayList();
         List list3 =new ArrayList();
         String sub= getFilter();
        for(int i=0;i< initList().size();i++){
            if(((Emp)(initList().get(i))).getBugnumber().equals(sub)){
                list1.add(((Emp)initList().get(i)).getName()); 
                list2.add(((Emp)initList().get(i)).getBugnumber()); 
                list3.add(((Emp)initList().get(i)).getText()); 
            }
              
        }
        Emp str[]=new Emp[list1.size()];
        for(int i=0;i<list1.size();i++){
            str[i]=new Emp(list1.get(i).toString(), list2.get(i).toString(), list3.get(i).toString());
        }   
         return str;
    }
    
    public String[] getAssignedBug(){
//       List list1 =new ArrayList();
        List list2 =new ArrayList();
        List list3 =new ArrayList();
         String sub= username;
         for(int i=0;i< initList().size();i++){
             if(((Emp)(initList().get(i))).getName().equals(sub)){
//                 list1.add(((Emp)initList().get(i)).getName()); 
                 list2.add(((Emp)initList().get(i)).getBugnumber()); 
                 list3.add(((Emp)initList().get(i)).getText()); 
             }
               
         }
         String str[]=new String[list2.size()];
         for(int i=0;i<list2.size();i++){
             str[i]=list2.get(i).toString()+"  "+list3.get(i).toString();
         }   
         return str;
    }

    private List initList() {
        if(s_emps == null){
            initAllBugs();
        }
        
        return s_emps;
    }
}

