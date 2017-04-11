package mybugdb.mobile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TalkList
{
    public List getTalkList() {
        return m_talkList;
    }

    private List m_talkList;
    public TalkList(int test)
    {
        m_talkList=new ArrayList();
        m_talkList.add(new Talk("1111", "cty",new Date(),"i have a pen"));
        m_talkList.add(new Talk("1111", "wjm",new Date(),"i have a apple"));
        m_talkList.add(new Talk("1111", "zy",new Date(),"a, apple pen"));
        m_talkList.add(new Talk("1111", "wyp",new Date(),"I have a pen "));
        m_talkList.add(new Talk("1111", "zy",new Date(),"I have a pinapple"));
    }
    public TalkList(String bugNumber)
    {
        this(1);
    }
    public void Add(Talk talk)
    {
        m_talkList.add(talk);
    }
}