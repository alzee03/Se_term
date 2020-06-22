import java.util.ArrayList;
import java.util.Observable;

public class Model{
    ArrayList<Person> User_list;
    Admin admin=new Admin();
    Person current_user;
    public static Book_list meta_book_list=new Book_list();
    Book_list book_list_display=new Book_list();
    Book edit_book;
    Book buy_book;
    Model()
    {
        User_list=admin.user_list;
    }
    public void subscribe(String ID,String password,String name, String phone,String email)
    {
        User u=new User(ID,password,name,Integer.parseInt(phone),email);
    }
    public int Login(String id,String password)
    {
        int target=-1;
        if(id.equals(admin.id) && password.equals(admin.password))
        {
            current_user=admin;
            return 2;
        }
        for(int i=0;i<User_list.size();i++)
        {
            if((User_list.get(i)).getId().equals(id))
            {
                target=i;
                break;
            }
        }
        if(target == -1)
            return -1;
        if(!(User_list.get(target)).getPassword().equals(password))
        {
            return -2;
        }
        if(User_list.get(target).getId().equals("admin"))
        {
            return 1;
        }
        else if(((User)User_list.get(target)).state==User.Disactivated)
        {
            return 0;
        }
        current_user=(User)User_list.get(target);
        return 1;
    }
    //name이 null이면 오류이므로 return -1
    public int regist_book( String name,String publisher,String author,String ISBN,String year,String price,String state)
    {
        int isbn,y,p;
        if(name.isEmpty())
            return -1;
        if(ISBN.isEmpty())
            isbn=Book.UNKNOWN;
        else
            isbn=Integer.parseInt(ISBN);
        if(year.isEmpty())
            y=Book.UNKNOWN;
        else
            y=Integer.parseInt(year);
        if(price.isEmpty())
            p=Book.UNKNOWN;
        else
            p=Integer.parseInt(price);

        Book b=new Book(name,publisher,author,isbn,y,p,state,(User)current_user);

        return 1;
    }
    public void logout()
    {
        this.current_user=null;
        this.buy_book=null;
        this.book_list_display=null;
        this.edit_book=null;
    }
    public int search_book_name(String name)
    {
        book_list_display=new Book_list();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getName().equals(name))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }
    public int search_book_ISBN(String ISBN)
    {
        book_list_display.clear();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getISBN()==Integer.parseInt(ISBN))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }
    public int search_book_publisher(String publisher)
    {
        book_list_display.clear();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getPublisher().equals(publisher))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }
    public int search_book_author(String author)
    {
        book_list_display.clear();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getAuthor().equals(author))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }
    public int search_book_year(String year)
    {
        book_list_display.clear();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getYear()==Integer.parseInt(year))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }
    public int search_book_ID(String ID)
    {
        book_list_display.clear();
        ArrayList<Integer> target=new ArrayList<Integer>();
        for(int i=0;i<this.meta_book_list.size();i++)
        {
            if(this.meta_book_list.get(i).getUserId().equals(ID))
            {
                target.add(i);
            }
        }
        for(int i=0;i<target.size();i++)
        {
            this.book_list_display.add(this.meta_book_list.get(target.get(i)));
        }
        if(!book_list_display.isEmpty())
            return 1;
        else
            return 0;
    }


    public int delete_book(String number)
    {
        if(((User)current_user).book_list.size()>Integer.parseInt(number))
        {
            ((User)current_user).book_list.remove(Integer.parseInt(number));
            for(int i=0;i<meta_book_list.size();i++)
            {
                if(meta_book_list.get(i).owner==current_user)
                    meta_book_list.remove(i);
            }
            return 1;
        }
        else
            return 0;
    }

    public int edit_book(String number)
    {
        edit_book=new Book();
        if(((User)current_user).book_list.size()>Integer.parseInt(number))
        {
            edit_book=((User)current_user).book_list.get(Integer.parseInt(number));
            return 1;
        }
        else
            return 0;
    }
    public int buy_book(String number)
    {
        buy_book=new Book();
        if(Integer.parseInt(number)<book_list_display.size())
        {
            int target=-1;
            buy_book=book_list_display.get(Integer.parseInt(number));
            book_list_display.remove(Integer.parseInt(number));
            for(int i=0;i<meta_book_list.size();i++)
            {
                if(buy_book==meta_book_list.get(i))
                {
                    target=i;
                    break;
                }
            }
            meta_book_list.remove(target);
            return 1;
        }
        else
            return 0;
    }
    public int toggle(String id)
    {
        int target=-1;
        for(int i=0;i<User_list.size();i++)
            if(id.equals(User_list.get(i).id))
                target=i;
        if(target!=-1)
        {
            User u=(User)User_list.get(target);
            if(u.state==User.Activated)
            {
                u.state=User.Disactivated;
                return 1;
            }
            else
            {
                u.state=User.Activated;
                return 2;
            }
        }
        else
        {
            return 0;
        }
    }
    public int delete_user(String id)
    {
        int target=-1;
        for(int i=0;i<User_list.size();i++)
            if(id.equals(User_list.get(i).id))
                target=i;
        if(target!=-1)
        {
            User u=(User)User_list.get(target);
            for(int i=0;i<meta_book_list.size();i++)
            {
                if(meta_book_list.get(i).owner==u)
                    meta_book_list.remove(i);
            }
            User_list.remove(target);
            return 1;
        }
        else
        {
            return 0;
        }
    }

}
