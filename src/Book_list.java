import java.util.ArrayList;

public class Book_list extends ArrayList<Book>{
    public User owner;
    Book_list()
    {

    }
    Book_list(User user)
    {
        super();
        owner=user;
    }

}
