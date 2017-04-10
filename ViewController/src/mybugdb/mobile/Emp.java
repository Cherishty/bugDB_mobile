package mybugdb.mobile;

public class Emp {
  
    public Emp() {
        super();
    }
    private String name;
    private String bugnumber;
    private String text;

    public Emp(String name, String bugnumber, String text) {
        super();
        this.name = name;
        this.bugnumber = bugnumber;
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setBugnumber(String bugnumber) {
        this.bugnumber = bugnumber;
    }

    public String getBugnumber() {
        return bugnumber;
    }

    public void setText(String  text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
