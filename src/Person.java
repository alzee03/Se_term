import java.util.ArrayList;

public class Person {
    protected String id;
    protected String password;
    public static ArrayList<Person> user_list=new ArrayList<Person>();
    Person()
    {
        this.id="Unknown";
        this.password="Unknown";
    }
    Person(String id,String password)
    {
        this.id=id;
        this.password=password;
    }

    //로그인 성공 return 1 disactivated 라서 실패 return 0 일치하는 id가 없어 실패 return -1 id는 있는 password가 틀리면  return -2

    public String getId()
    {
        return this.id;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
}
