import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View{

   Model model=new Model();

    public void login_view_person()
    {
        System.out.println("hello\n if you want login type login \n or you want subscribe our system type subscribe\n or type exit");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        if(type.equals("login"))
        {
            String ID,password;
            System.out.print("ID:");
            ID=In.nextLine();
            System.out.print("\npassword");
            password=In.nextLine();
            int ret=model.Login(ID,password);
            if(ret==1)
                menu_view_User();
            else if(ret==2)
                menu_view_Admin();
            else
            {
                System.out.println("login is not available");
                login_view_person();
            }
        }
        else if(type.equals("subscribe"))
        {
            subscription_view_User();
        }
        else if(type.equals("exit"))
        {
            System.out.println("exit program");
        }
        else
        {
            login_view_person();
        }
    }
    public void menu_view_Admin()
    {
        System.out.println("1. Search Book");
        System.out.println("2. Listing User");
        System.out.println("3. Logout");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        if(type.equals("1"))
        {
            search_book_view_User();
        }
        else if(type.equals("2"))
        {
            listing_view_Admin();
        }
        else if(type.equals("3"))
        {
            logout_view_Person();
        }
        else
        {
            System.out.println("\n\n\n Please Give Proper Answer\n\n\n");
            menu_view_Admin();
        }

    }
    public void listing_view_Admin()
    {
        System.out.println("Please type toggle\n" +
                "or if you want delete type \"delete\"" +
                "or press Enter to return menu");
        for(int i=0;i<model.User_list.size();i++)
        {
            System.out.println(i+") ID:"+ model.User_list.get(i).getId());
        }
        int ret=-1;
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        if(type.equals("delete"))
        {
            delete_user_view_admin();
        }
        else if(type.isEmpty())
            menu_view_Admin();
        else if(type.equals("toggle"))
            toggle_view_admin();
    }
    public void menu_view_User()
    {
        System.out.println("1. Search Book");
        System.out.println("2. Post Book for Selling");
        System.out.println("3. Listing My Book");
        System.out.println("4. Logout");
        System.out.println("Please type the number you want");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        if(type.equals("1"))
        {
            search_book_view_User();
        }
        else if(type.equals("2"))
        {
            sell_view_User();
        }
        else if(type.equals("3"))
        {
            delete_edit_book_view_User();
        }
        else if(type.equals("4"))
        {
            logout_view_Person();
        }
        else
        {
            System.out.println("\n\n\n Please Give Proper Answer\n\n\n");
            menu_view_User();
        }
    }
    public void logout_view_Person()
    {
        model.logout();
        System.out.println("logout success");
        login_view_person();
    }
    public void search_book_view_User()
    {
        System.out.println("1.search by name");
        System.out.println("2.search by ISBN num");
        System.out.println("3.search by author");
        System.out.println("4.search by publisher");
        System.out.println("5.search by year");
        System.out.println("6.search by ID");
        System.out.println("7. Return to menu");
        System.out.println("Please type the number you want");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        if(type.equals("1"))
        {
            search_book_view_name_User();
        }
        else if(type.equals("2"))
        {
            search_book_view_ISBN_User();
        }
        else if(type.equals("3"))
        {
            search_book_view_author_User();
        }
        else if(type.equals("4"))
        {
            search_book_view_publisher_User();
        }
        else if(type.equals("5"))
        {
            search_book_view_year_User();
        }
        else if(type.equals("6"))
        {
            search_book_view_ID_User();
        }
        else if(type.equals("7") && model.current_user.getId().equals("admin"))
        {
            menu_view_Admin();
        }else if(type.equals("7"))
        {
            menu_view_User();
        }
        else
        {
            System.out.println("\n\n\n Please Give Proper Answer\n\n\n");
            search_book_view_User();
        }
    }
    public void search_book_view_name_User()
    {
        System.out.println("Type the book name");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_name(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();
            else buy_view_User();
        }
        else
        {
            System.out.println("No books has same name\n Please retry");
            search_book_view_name_User();
        }
        //Book list에서 검색
    }
    public void search_book_view_ISBN_User()
    {
        System.out.println("Type the ISBN number");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_ISBN(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();

            else menu_view_User();
        }
        else
        {
            System.out.println("No books has same ISBN\n Please retry");
            search_book_view_ISBN_User();
        }
        //Book list에서 검색
    }
    public void search_book_view_author_User()
    {
        System.out.println("Type the author name");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_author(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();
            else buy_view_User();
        }
        else
        {
            System.out.println("No books has same author\n Please retry");
            search_book_view_author_User();
        }
        //Book list에서 검색
    }
    public void search_book_view_publisher_User()
    {
        System.out.println("Type the publisher");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_publisher(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();
            else buy_view_User();
        }
        else
        {
            System.out.println("No books has same publisher\n Please retry");
            search_book_view_publisher_User();
        }
        //Book list에서 검색
    }
    public void search_book_view_year_User()
    {
        System.out.println("Type the Published year");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_year(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();
            else buy_view_User();
        }
        else
        {
            System.out.println("No books has same year\n Please retry");
            search_book_view_year_User();;
        }
        //Book list에서 검색
    }
    public void search_book_view_ID_User()
    {
        System.out.println("Type the ID");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.search_book_ID(type);
        if(ret==1)
        {
            for(int i=0;i<model.book_list_display.size();i++)
            {
                System.out.print(i+":");
                model.book_list_display.get(i).print();
                System.out.println();
            }
            if(model.current_user.getId().equals("admin"))
                delete_book_view_admin();
            else buy_view_User();
        }
        else
        {
            System.out.println("No books has same ID\n Please retry");
            search_book_view_ID_User();
        }
        //Book list에서 검색
    }

    public void subscription_view_User()
    {
        System.out.println("Type the ID, password, name, Phone number, email");
        System.out.print("ID:");
        String id,password,name,phone,email;
        Scanner In=new Scanner(System.in);
        id=In.nextLine();
        System.out.print("\nPassword:");
        password=In.nextLine();
        System.out.print("\nName:");
        name=In.nextLine();
        System.out.print("\nPhone number:");
        phone=In.nextLine();
        System.out.print("\nEmail:");
        email=In.nextLine();
        model.subscribe(id,password,name,phone,email);
        System.out.println("Welcome");
        login_view_person();
    }
    public void buy_view_User()
    {
        int ret=-1;
        System.out.println("Do you want to buy books?\nPlease type the number");
        Scanner In=new Scanner(System.in);
        String num=In.nextLine();
        ret=model.buy_book(num);
        if(ret==1)
        {
            System.out.println("buyer's email:"+((User)model.current_user).getEmail());
            System.out.println("seller's email:"+model.buy_book.owner.getEmail());
            System.out.println("send the email");
            menu_view_User();
        }
        else
        {
            System.out.println("incorrect answer");
            menu_view_User();
        }
    }
    public void sell_view_User()
    {
        System.out.println("If you want sell the book?");
        System.out.println("Please type the Book Information");
        System.out.println("If you don't know additional information\njust press Enter");
        System.out.print("\n\nBook Name:");
        String name,ISBN,author,publisher,year,ID,price,state;
        Scanner In=new Scanner(System.in);
        name=In.nextLine();
        System.out.print("\nAdditional Information\nISBN:");
        ISBN=In.nextLine();
        System.out.print("\nAuthor:");
        author=In.nextLine();
        System.out.print("\nPublisher:");
        publisher=In.nextLine();
        System.out.print("\nPublished Year:");
        year=In.nextLine();
        System.out.print("\nprice:");
        price=In.nextLine();
        System.out.print("\nstate:");
        state=In.nextLine();
        int ret=model.regist_book(name,publisher,author,ISBN,year,price,state);
        if(ret==1)
        {
            System.out.println("success to regist the book\n");
            this.menu_view_User();
        }
        else if(ret==-1)
        {
            System.out.println("fail\n please retry");
            this.sell_view_User();
        }

    }
    public void delete_edit_book_view_User()
    {
        System.out.println("want delete or edit book?");
        System.out.println("Please type \"delete <number>\" or \"edit <number>\"");
        for(int i=0;i<((User)model.current_user).book_list.size();i++)
        {
            System.out.print("\n"+i+".");
            ((User)model.current_user).book_list.get(i).print();
        }
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        String token[]=type.split(" ");
        int ret=-1;
        System.out.println(token[0]);
        if(token[0].equals("delete"))
        {
            ret=model.delete_book(token[1]);
        }
        else if(token[0].equals("edit"))
        {
            ret=model.edit_book(token[1]);
        }
        else
        {
            System.out.println("not correct answer");
            menu_view_User();
            return;
        }
        if(ret==1 && token[0].equals("edit"))
        {
            System.out.println("Start edit book"+ model.edit_book.getName());
            System.out.println("1: "+model.edit_book.getName());
            System.out.println("2: "+model.edit_book.getPublisher());
            System.out.println("3: "+model.edit_book.getAuthor());
            System.out.println("4: "+model.edit_book.getISBN());
            System.out.println("5: "+model.edit_book.getYear());
            System.out.println("6: "+model.edit_book.getPrice());
            System.out.println("7: "+model.edit_book.getState());
            String line=In.nextLine();
            if(line.equals("1"))
            {
                String edit=In.nextLine();
                model.edit_book.setName(edit);
            }
            else if(line.equals("2"))
            {
                String edit=In.nextLine();
                model.edit_book.setPublisher(edit);
            }
            else if(line.equals("3"))
            {
                String edit=In.nextLine();
                model.edit_book.setAuthor(edit);
            }
            else if(line.equals("4"))
            {
                String edit=In.nextLine();
                model.edit_book.setISBN(Integer.parseInt(edit));
            }
            else if(line.equals("5"))
            {
                String edit=In.nextLine();
                model.edit_book.setYear(Integer.parseInt(edit));
            }
            else if(line.equals("6"))
            {
                String edit=In.nextLine();
                model.edit_book.setPrice(Integer.parseInt(edit));
            }
            else if(line.equals("7"))
            {
                String edit=In.nextLine();
                model.edit_book.setState(edit);
            }
            System.out.println("Success return to menu");
            menu_view_User();
        }
        else if(ret==1)
        {
            System.out.println("Success return to menu");
            menu_view_User();
        }
        else
        {
            System.out.println("fail return to start");
            delete_edit_book_view_User();
        }
    }

    public void toggle_view_admin()
    {
        System.out.println("type user id to change state");
        for(int i=0;i<model.User_list.size();i++)
        {
            System.out.print("\n"+i+")ID:"+model.User_list.get(i).getId());
        }
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.toggle(type);
        if(ret==1)
        {
            System.out.println("Change user state to disactivated");
            menu_view_Admin();
        }
        else if(ret==2)
        {
            System.out.println("Change user state to activated");
            menu_view_Admin();
        }
        else
        {
            System.out.println("fail, Please retry");
            menu_view_Admin();
        }
    }
    public void delete_user_view_admin()
    {
        System.out.println("type user id to delete");
        String type;
        Scanner In=new Scanner(System.in);
        type=In.nextLine();
        int ret=model.delete_user(type);
        if(ret==1)
        {
            System.out.println("Success delete user:"+type);
            menu_view_Admin();
        }
        else
        {
            System.out.println("fail to delete");
            menu_view_Admin();
        }
    }
    public void delete_book_view_admin()
    {
        int ret=-1;
        System.out.println("Do you want to delete books?\nPlease type the number");
        Scanner In=new Scanner(System.in);
        String num=In.nextLine();
        if(num.isBlank() || !num.matches(".*[0-9].*"))
        {
            menu_view_Admin();
        }
        else {
            ret = model.buy_book(num);

            if (ret == 1) {
                System.out.println("Success");
                menu_view_Admin();
            } else {
                System.out.println("incorrect answer");
                menu_view_Admin();
            }
        }
    }

}
