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
               m_talkList.add(new Talk("0001", "wjm",new Date(),"i have a apple"));
               m_talkList.add(new Talk("0001", "zy",new Date(),"a, apple pen"));
               m_talkList.add(new Talk("0001", "wyp",new Date(),"I have a pen "));
               m_talkList.add(new Talk("0001", "zy",new Date(),"I have a pinapple"));
               m_talkList.add(new Talk("0002", "cty",new Date(),"to all my friends"));
               m_talkList.add(new Talk("0002", "wjm",new Date(),"the night is young"));
               m_talkList.add(new Talk("0002", "zay",new Date(),"the music's cloud"));
               m_talkList.add(new Talk("0003", "wyp",new Date(),"they playing our song"));
               m_talkList.add(new Talk("0003", "zy",new Date(),"than here with you"));
               m_talkList.add(new Talk("0003", "wjm",new Date(),"Oh oh oh oh oh"));
               m_talkList.add(new Talk("0003", "cty",new Date(),"ain't felt this good since I remember"));
               m_talkList.add(new Talk("0004", "zy",new Date(),"this night got started"));
               m_talkList.add(new Talk("0004", "zay",new Date(),"when you entered"));
               m_talkList.add(new Talk("0004", "wyp",new Date(),"I hope we can get a litter closer"));
               m_talkList.add(new Talk("0005", "zy",new Date(),"maybe even get to know your name"));
               m_talkList.add(new Talk("0005", "cty",new Date(),"I wanna hear the music so cloud"));
               m_talkList.add(new Talk("0005", "zay",new Date(),"get some drinks inside me right now"));
               m_talkList.add(new Talk("0006", "wyp",new Date(),"so baby let it go"));
               m_talkList.add(new Talk("0006", "zy",new Date(),"you had me at hello"));
               
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