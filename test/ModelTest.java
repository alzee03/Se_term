import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest extends Model {
    public static Model m=new Model();
    @Test
    void testSubscribe() {
        m.subscribe("alzee","1234","song","010","gmail");
        assertSame("alzee",User_list.get(User_list.size()-1).id);

    }

    @Test
    void testLogin()
    {
        testSubscribe();
        assertSame(1,m.Login("alzee","1234"));
        assertSame(-2,m.Login("alzee","123"));
        assertSame(-1,m.Login("alze","1234"));
    }
    @Test
    void testRegist_book()
    {
        testLogin();
        int ret=m.regist_book("se","song","chi","1234","1998","30000","good");
        assertSame(1,ret);
        ret=m.regist_book(new String(),new String(),new String(),new String(),new String(),new String(),new String());
        assertSame(-1,ret);
        assertSame(1,m.meta_book_list.size());

    }

    @Test
    void testSearch_book_name()
    {
        testRegist_book();
        int ret=m.search_book_name("se");
        assertSame(1,ret);
        ret=m.search_book_name("s");
        assertSame(0,ret);
    }

    @Test
    void testSearch_book_ISBN()
    {
        testRegist_book();
        int ret=m.search_book_ISBN("1234");
        assertSame(1,ret);
        ret=m.search_book_ISBN("1");
        assertSame(0,ret);

    }

    @Test
    void testSearch_book_publisher()
    {
        testRegist_book();
        int ret=m.search_book_publisher("song");
        assertSame(1,ret);
        ret=m.search_book_publisher("e");
        assertSame(0,ret);

    }

    @Test
    void testSearch_book_author()
    {
        testRegist_book();
        int ret=m.search_book_author("chi");
        assertSame(1,ret);
        ret=m.search_book_author("e");
        assertSame(0,ret);
    }

    @Test
    void testSearch_book_year()
    {
        testRegist_book();
        int ret=m.search_book_year("1998");
        assertSame(1,ret);
        ret=m.search_book_year("1");
        assertSame(0,ret);
    }

    @Test
    void testSearch_book_ID()
    {
        testRegist_book();
        int ret=m.search_book_ID("alzee");
        assertSame(1,ret);
        ret=m.search_book_ID("a");
        assertSame(0,ret);
    }


    @Test
    void testDelete_book()
    {
        testRegist_book();
        int ret=m.delete_book("0");
        assertSame(1,ret);
        assertSame(0,((User)m.current_user).book_list.size());
        assertSame(0,m.meta_book_list.size());
    }


    @Test
    void testToggle()
    {
        testLogin();
        int ret=m.toggle("alzee");
        assertSame(1,ret);
        ret=m.toggle("alzee");
        assertSame(2,ret);
        ret=m.toggle("12");
        assertSame(0,ret);
    }

    @Test
    void testDelete_user()
    {
        testSubscribe();
        int ret=m.delete_user("alzee");
        assertSame(1,ret);
        ret=m.delete_user("alzee");
        assertSame(0,ret);
    }
}