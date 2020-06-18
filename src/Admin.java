import java.util.ArrayList;

public class Admin extends User
{
    Admin()
    {
        super();

        this.setId("admin");
        this.setPassword("nayana");
        User.user_list.add(this);
    }
}
