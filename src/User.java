public class User extends Person{
    private static final int Unknown=-524288;
    public static final int Activated=-8388608;
    public static final int Disactivated=8388608;
    private String name;
    private int phone_num;  //010-8533-8992 is saved as 01085338992
    private String email;
    public Book_list book_list;
    public int state;
    User()
    {
        this.name="Unknown";
        this.phone_num=Unknown;
        this.email="Unknown";
        this.state=Activated;
        user_list.add(this);

    }
    User(String id,String password,String name,int phone_num,
         String email)
    {
        super(id,password);
        this.name=name;
        this.phone_num=phone_num;
        this.email=email;
        this.state=Activated;
        book_list = new Book_list(this);
        user_list.add(this);

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
