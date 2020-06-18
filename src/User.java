import java.lang.reflect.Array;
import java.util.ArrayList;
public class User {
    private static final int Unknown=-524288;
    private static final int Activated=-8388608;
    private static final int Disactivated=8388608;
    private String id;
    private String password;
    private String name;
    private int phone_num;  //010-8533-8992 is saved as 01085338992
    private String email;
    private int state;
    public static ArrayList<User> user_list;
    User()
    {
        this.id="Unknown";
        this.password="Unknown";
        this.name="Unknown";
        this.phone_num=Unknown;
        this.email="Unknown";
        this.state=Activated;
    }
    User(String id,String password,String name,int phone_num,
         String email)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.phone_num=phone_num;
        this.email=email;
        this.state=Activated;
        User.user_list.add(this);
    }
    //로그인 성공 return 1 disactivated 라서 실패 return 0 일치하는 id가 없어 실패 return -1 id는 있는 password가 틀리면  return -2
    public static int Login(String id,String password)
    {
        int target=-1;
        for(int i=0;i<User.user_list.size();i++)
        {
            if(user_list.get(i).getId().equals(id))
            {
                target=i;
                break;
            }
        }
        if(target == -1)
            return -1;
        if(!user_list.get(target).getPassword().equals(password))
        {
            return -2;
        }
        if(user_list.get(target).state==Disactivated)
        {
            return 0;
        }
         return 1;
    }
    public String getId()
    {
        return this.id;
    }
    public String getPassword()
    {
        return this.password;
    }
    public  String getName()
    {
        return this.name;
    }
    public int getPhone_num()
    {
        return this.phone_num;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPhone_num(int phone_num)
    {
        this.phone_num=phone_num;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

}
