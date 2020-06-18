import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest extends Book {

    @Test
    void testGetName() {
        Book b = new Book("software");
        assertEquals("softwa",b.getName(),"fail");
    }

    @Test
    void testGetPublisher() {
    }

    @Test
    void testGetAuthor() {
    }

    @Test
    void testGetISBN() {
    }

    @Test
    void testGetYear() {
    }

    @Test
    void testGetPrice() {
    }

    @Test
    void testGetState() {
    }

    @Test
    void testGetUserId() {
    }

    @Test
    void testSetName() {
    }

    @Test
    void testSetPublisher() {
    }

    @Test
    void testSetAuthor() {
    }

    @Test
    void testSetISBN() {
    }

    @Test
    void testSetYear() {
    }

    @Test
    void testSetPrice() {
    }

    @Test
    void testSetState() {
    }

    @Test
    void testSetUserId() {
    }
}