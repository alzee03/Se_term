



public class Book {
    private static final int UNKNOWN = -1;
    private String name;
    private String publisher;
    private String author;
    private int ISBN;
    private int year;
    private int price;
    private String state;
    private String userId;
    public Book()
    {

    }
    public Book(String name) {
        this.name=name;
        this.publisher="Unknown";
        this.author="Unknown";
        this.ISBN=UNKNOWN;
        this.year=UNKNOWN;
        this.price=UNKNOWN;
        this.state="Unknown";
        this.userId="Unknown";
    }
    public Book(String name, String publisher)
    {
        this.name=name;
        this.publisher=publisher;
        this.author="Unknown";
        this.ISBN=UNKNOWN;
        this.year=UNKNOWN;
        this.price=UNKNOWN;
        this.state="Unknown";
        this.userId="Unknown";
    }
    public Book(String name, String publisher,String author)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=UNKNOWN;
        this.year=UNKNOWN;
        this.price=UNKNOWN;
        this.state="Unknown";
        this.userId="Unknown";
    }

    public Book(String name, String publisher,String author,
                int ISBN)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=ISBN;
        this.year=UNKNOWN;
        this.price=UNKNOWN;
        this.state="Unknown";
        this.userId="Unknown";
    }
    public Book(String name, String publisher,String author,
                int ISBN,int year)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=ISBN;
        this.year=year;
        this.price=UNKNOWN;
        this.state="Unknown";
        this.userId="Unknown";
    }
    public Book(String name, String publisher,String author,
                int ISBN,int year,int price)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=ISBN;
        this.year=year;
        this.price=price;
        this.state="Unknown";
        this.userId="Unknown";
    }
    public Book(String name, String publisher,String author,
                int ISBN,int year,int price,String state)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=ISBN;
        this.year=year;
        this.price=price;
        this.state=state;
        this.userId="Unknown";
    }
    public Book(String name, String publisher,String author,
                int ISBN,int year,int price,String state,
                String userId)
    {
        this.name=name;
        this.publisher=publisher;
        this.author=author;
        this.ISBN=ISBN;
        this.year=year;
        this.price=price;
        this.state=state;
        this.userId=userId;
    }
    public String getName()
    {
        return this.name;
    }

    public String getPublisher()
    {
        return this.publisher;
    }
    public String getAuthor()
    {
        return this.author;
    }
    public  int getISBN()
    {
        return this.ISBN;
    }
    public int getYear()
    {
        return this.year;
    }
    public int getPrice()
    {
        return this.price;
    }
    public String getState()
    {
        return this.state;
    }
    public String getUserId()
    {
        return this.userId;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPublisher(String publisher)
    {
        this.publisher=publisher;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void  setISBN(int isbn)
    {
        this.ISBN=isbn;
    }
    public void setYear(int year)
    {
        this.year=year;
    }
    public void setPrice(int price)
    {
        this.price=price;
    }
    public void setState(String state)
    {
        this.state=state;
    }
    public void setUserId(String userId)
    {
        this.userId=userId;
    }


}
