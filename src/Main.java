import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        User.user_list=new ArrayList<User>();
        Admin admin=new Admin();
        System.out.println(admin.getId() + admin.getPassword()+ admin.getName());

    }
}