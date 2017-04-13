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

public class InproceedingsTest {

    Inproceedings instance;

    public InproceedingsTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Inproceedings();
        instance.setAddress("address");
//        instance.setAuthor("author");
        instance.setBookTitle("bookTitle");
        instance.setEndingPage("100");
        instance.setPublisher("publisher");
        instance.setStartingPage("1");
        instance.setTitle("title");
        instance.setYear("2017");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String result = instance.getTitle();
        assertEquals("title", result);
    }

    /**
     * Test of getBookTitle method, of class Inproceedings.
     */
    @Test
    public void testGetBookTitle() {
        System.out.println("getBookTitle");
        String result = instance.getBookTitle();
        assertEquals("bookTitle", result);
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
//    @Test
//    public void testGetAuthor() {
//        System.out.println("getAuthor");
//        String result = instance.getAuthor();
//        assertEquals("author", result);
//    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        assertEquals("2017", instance.getYear());
    }

    /**
     * Test of getPublisher method, of class Inproceedings.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        assertEquals("publisher", instance.getPublisher());
    }

    /**
     * Test of getStartingPage method, of class Inproceedings.
     */
    @Test
    public void testGetStartingPage() {
        System.out.println("getStartingPage");
        assertEquals("1", instance.getStartingPage());
    }

    /**
     * Test of getEndingPage method, of class Inproceedings.
     */
    @Test
    public void testGetEndingPage() {
        System.out.println("getEndingPage");
        assertEquals("100", instance.getEndingPage());
    }

    /**
     * Test of getAddress method, of class Inproceedings.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        assertEquals("address", instance.getAddress());
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title1";
        Inproceedings instance1 = new Inproceedings();
        instance1.setTitle(title);
        assertEquals("title1", instance1.getTitle());

    }

    /**
     * Test of setBookTitle method, of class Inproceedings.
     */
    @Test
    public void testSetBookTitle() {
        System.out.println("setBookTitle");
        String booktitle = "bookTitle1";
        Inproceedings instance1 = new Inproceedings();
        instance1.setBookTitle(booktitle);
        assertEquals("bookTitle1", instance1.getBookTitle());

    }

    /**
     * Test of setAuthor method, of class Inproceedings.
     */
//    @Test
//    public void testSetAuthor() {
//        System.out.println("setAuthor");
//        String author = "author1";
//        Inproceedings instance1 = new Inproceedings();
//        instance1.setAuthor(author);
//        assertEquals("author1", instance1.getAuthor());
//    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        String year = "2017";
        Inproceedings instance1 = new Inproceedings();
        instance1.setYear(year);
        assertEquals("2017", instance1.getYear());
    }

    /**
     * Test of setPublisher method, of class Inproceedings.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "publisher1";
        Inproceedings instance1 = new Inproceedings();
        instance1.setPublisher(publisher);
        assertEquals("publisher1", instance1.getPublisher());
    }

    /**
     * Test of setAddress method, of class Inproceedings.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "address1";
        Inproceedings instance1 = new Inproceedings();
        instance1.setAddress(address);
        assertEquals("address1", instance1.getAddress());
    }

    /**
     * Test of setStartingPage method, of class Inproceedings.
     */
    @Test
    public void testSetStartingPage() {
        System.out.println("setStartingPage");
        String page = "11";
        Inproceedings instance1 = new Inproceedings();
        instance1.setStartingPage(page);
        assertEquals("11", instance1.getStartingPage());
    }

    /**
     * Test of setEndingPage method, of class Inproceedings.
     */
    @Test
    public void testSetEndingPage() {
        System.out.println("setEndingPage");
        String page = "60";
        Inproceedings instance1 = new Inproceedings();
        instance1.setEndingPage(page);
        assertEquals("60", instance1.getEndingPage());
    }

    /**
     * Test of toString method, of class Inproceedings.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        System.out.println("alla");
//        System.out.println(instance.toString());
//        String expResult = " author. title. In bookTitle, pages 1 - 100. publisher,2017. address.";
//        assertEquals(expResult, instance.toString());
//    }

    /**
     * Test of toBibTex method, of class Inproceedings.
     */
//    @Test
//    public void testToBibTex() {
//        System.out.println("toBibTex");
//        Inproceedings instance = new Inproceedings();
//        String expResult = "";
//        String result = instance.toBibTex();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
