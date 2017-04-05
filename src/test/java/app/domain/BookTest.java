/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bensatu
 */
public class BookTest {

    Book instance;

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Book();
        instance.setAddress("address");
        instance.setAuthor("author");
        instance.setId(null);
        instance.setPublisher("publisher");
        instance.setTitle("title");
        instance.setYear(2017);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        assertEquals("title", instance.getTitle());

    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        assertEquals("author", instance.getAuthor());
    }

    /**
     * Test of getYear method, of class Book.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        assertEquals(2017, instance.getYear());
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        assertEquals("publisher", instance.getPublisher());
    }

    /**
     * Test of getAddress method, of class Book.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        assertEquals("address", instance.getAddress());
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        Book instance1 = new Book();
        instance1.setTitle("title");
        assertEquals("title", instance1.getTitle());
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        Book instance1 = new Book();
        instance1.setAuthor("author");
        assertEquals("author", instance1.getAuthor());
    }

    /**
     * Test of setYear method, of class Book.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        Book instance1 = new Book();
        instance1.setYear(2017);
        assertEquals(2017, instance1.getYear());
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        Book instance1 = new Book();
        instance1.setPublisher("publisher");
        assertEquals("publisher", instance1.getPublisher());
    }

    /**
     * Test of setAddress method, of class Book.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        Book instance1 = new Book();
        instance1.setAddress("address");
        assertEquals("address", instance1.getAddress());
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "author. title. publisher, 2017. address.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toBibTex method, of class Book.
     */
//    @Test
//    public void testToBibTex() {
//        System.out.println("toBibTex");
//        Book instance = new Book();
//        String expResult = "";
//        String result = instance.toBibTex();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getId method, of class Book.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(null, instance.getId());

    }

    /**
     * Test of setId method, of class Book.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Book instance1 = new Book();
        instance1.setId(null);
        assertEquals(null, instance1.getId());
    }

}
