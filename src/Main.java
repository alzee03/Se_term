import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        FileInputStream in=null;
        FileInputStream in_book=null;
        try
        {
            in = new FileInputStream("input.txt");
            in_book= new FileInputStream("book.txt");
            Scanner list=new Scanner(in);
            Scanner list_book=new Scanner(in_book);
            while(list.hasNextLine())
            {
                String infor=list.nextLine();
                String[] token=infor.split("\\$",5);
                new User(token[0],token[1],token[2],Integer.parseInt(token[3]),token[4]);
            }
            while(list_book.hasNextLine())
            {
                int target=-1;
                String infor=list_book.nextLine();
                String[] token=infor.split("\\$",8);
                for(int i=0;i<Person.user_list.size();i++)
            {
                if(Person.user_list.get(i).getId().equals(token[7]))
                    target=i;
            }
                Book b=new Book(token[0],token[1],token[2],Integer.parseInt(token[3]),Integer.parseInt(token[4]),
                        Integer.parseInt(token[5]),token[6],(User)Person.user_list.get(target));

            }
            View v=new View();
            v.login_view_person();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file is not found\n ");
        }
        finally {
            FileOutputStream out=new FileOutputStream("input.txt");
            FileOutputStream out_book=new FileOutputStream("book.txt");
            for(int i=0;i<Person.user_list.size();i++)
            {
                if(Person.user_list.get(i).getId().equals("admin"))
                {
                    out.write(Person.user_list.get(i).getId().getBytes());
                    out.write("$".getBytes());
                    out.write(Person.user_list.get(i).getPassword().getBytes());
                    out.write("\n".getBytes());
                }
                else
                {
                    out.write(Person.user_list.get(i).getId().getBytes());
                    out.write("$".getBytes());
                    out.write(Person.user_list.get(i).getPassword().getBytes());
                    out.write("$".getBytes());
                    out.write(((User)Person.user_list.get(i)).getName().getBytes());
                    out.write("$".getBytes());
                    out.write(Integer.toString(((User)Person.user_list.get(i)).getPhone_num()).getBytes());
                    out.write("$".getBytes());
                    out.write(((User)Person.user_list.get(i)).getEmail().getBytes());
                    out.write("\n".getBytes());
                }
            }

           for(int i=0;i<Model.meta_book_list.size();i++)
           {

               out_book.write(Model.meta_book_list.get(i).getName().getBytes());
               out_book.write("$".getBytes());
               out_book.write(Model.meta_book_list.get(i).getPublisher().getBytes());
               out_book.write("$".getBytes());
               out_book.write(Model.meta_book_list.get(i).getAuthor().getBytes());
               out_book.write("$".getBytes());
               out_book.write(Integer.toString(Model.meta_book_list.get(i).getISBN()).getBytes());
               out_book.write("$".getBytes());
               out_book.write(Integer.toString(Model.meta_book_list.get(i).getYear()).getBytes());
               out_book.write("$".getBytes());
               out_book.write(Integer.toString(Model.meta_book_list.get(i).getPrice()).getBytes());
               out_book.write("$".getBytes());
               out_book.write(Model.meta_book_list.get(i).getState().getBytes());
               out_book.write("$".getBytes());
               out_book.write(Model.meta_book_list.get(i).getUserId().getBytes());
               out_book.write("\n".getBytes());
           }
        }
    }
}