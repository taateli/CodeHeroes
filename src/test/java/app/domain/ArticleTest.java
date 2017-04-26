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

import app.domain.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iisa
 */
public class ArticleTest {

    Article instance;

    public ArticleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Article();

        List<String> authors = new ArrayList<>();
        authors.add("author1");
        authors.add("author2");
        instance.setAuthors(authors);
        instance.setKey("avain");
        instance.setTitle("title");
        instance.setJournal("journal");
        instance.setPublisher("publisher");
        instance.setVolume("4");
        instance.setNumber("2");
        instance.setYear("2017");
        instance.setStartingPage("1");
        instance.setEndingPage("100");
        instance.setAddress("address");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        instance.setTags(tags);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Article.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String result = instance.getTitle();
        assertEquals("title", result);
    }

    /**
     * Test of getJournal method, of class Article.
     */
    @Test
    public void testGetJournal() {
        System.out.println("getJourna");
        String result = instance.getJournal();
        assertEquals("journal", result);
    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        assertEquals("2017", instance.getYear());
    }

    /**
     * Test of getPublisher method, of class Article.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        assertEquals("publisher", instance.getPublisher());
    }

    /**
     * Test of getVol method, of class Article.
     */
    @Test
    public void testGetVol() {
        System.out.println("getVol");
        assertEquals("4", instance.getVolume());
    }

    /**
     * Test of getNumber method, of class Article.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        assertEquals("2", instance.getNumber());
    }

    /**
     * Test of getStartingPage method, of class Article.
     */
    @Test
    public void testGetStartingPage() {
        System.out.println("getStartingPage");
        assertEquals("1", instance.getStartingPage());
    }

    /**
     * Test of getEndingPage method, of class Article.
     */
    @Test
    public void testGetEndingPage() {
        System.out.println("getEndingPage");
        assertEquals("100", instance.getEndingPage());
    }

    /**
     * Test of getAddress method, of class Article.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        assertEquals("address", instance.getAddress());
    }

    /**
     * Test of setTitle method, of class Article.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title1";
        Article instance1 = new Article();
        instance1.setTitle(title);
        assertEquals("title1", instance1.getTitle());
    }

    /**
     * Test of setJournal method, of class Article.
     */
    @Test
    public void testSetJournal() {
        System.out.println("setJournal");
        String journal = "journal1";
        Article instance1 = new Article();
        instance1.setJournal(journal);
        assertEquals("journal1", instance1.getJournal());
    }

    /**
     * Test of setVol method, of class Article.
     */
    @Test
    public void testSetVol() {
        System.out.println("setVol");
        String vol = "5";
        Article instance1 = new Article();
        instance1.setVolume(vol);
        assertEquals("5", instance1.getVolume());
    }

    /**
     * Test of setNumber method, of class Article.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        String number = "3";
        Article instance1 = new Article();
        instance1.setNumber(number);
        assertEquals("3", instance1.getNumber());
    }

    /**
     * Test of setYear method, of class Article.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        String year = "2016";
        Article instance1 = new Article();
        instance1.setYear(year);
        assertEquals("2016", instance1.getYear());
    }

    /**
     * Test of setPublisher method, of class Article.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "publisher1";
        Article instance1 = new Article();
        instance1.setPublisher(publisher);
        assertEquals("publisher1", instance1.getPublisher());
    }

    /**
     * Test of setAddress method, of class Article.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "address1";
        Article instance1 = new Article();
        instance1.setAddress(address);
        assertEquals("address1", instance1.getAddress());
    }

    /**
     * Test of setStartingPage method, of class Article.
     */
    @Test
    public void testSetStartingPage() {
        System.out.println("setStartingPage");
        String page = "15";
        Article instance1 = new Article();
        instance1.setStartingPage(page);
        assertEquals("15", instance1.getStartingPage());
    }

    /**
     * Test of setEndingPage method, of class Article.
     */
    @Test
    public void testSetEndingPage() {
        System.out.println("setEndingPage");
        String page = "70";
        Article instance1 = new Article();
        instance1.setEndingPage(page);
        assertEquals("70", instance1.getEndingPage());
    }

    /**
     * Test of toString method, of class Article. One author.
     */
    @Test
    public void testToStringOneAuthor() {
        List<String> authors = new ArrayList<>();
        authors.add("author1");
        instance.setAuthors(authors);
        System.out.println("toString");
        String expResult = "author1";
        expResult = expResult + ". title. journal, 4(2):1-100, publisher, 2017. address. Key{avain} tag1,tag2.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toString method, of class Article.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "author1 and author2";
        expResult = expResult + ". title. journal, 4(2):1-100, publisher, 2017. address. Key{avain} tag1,tag2.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toString method, of class Article. One tag.
     */
    @Test
    public void testToStringOneTag() {
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        instance.setTags(tags);
        System.out.println("toString");
        String expResult = "author1 and author2";
        expResult = expResult + ". title. journal, 4(2):1-100, publisher, 2017. address. Key{avain} tag1.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toString method, of class Article. Three tags.
     */
    @Test
    public void testToStringThreeTags() {
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        tags.add("tag3");
        instance.setTags(tags);
        System.out.println("toString");
        String expResult = "author1 and author2";
        expResult = expResult + ". title. journal, 4(2):1-100, publisher, 2017. address. Key{avain} tag1,tag2,tag3.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toString method, of class Article. Three authors.
     */
    @Test
    public void testToStringThreeAuthors() {
        List<String> authors = new ArrayList<>();
        authors.add("author1");
        authors.add("author2");
        authors.add("author3");
        instance.setAuthors(authors);
        System.out.println("toString");
        String expResult = "author1, author2, and author3";
        expResult = expResult + ". title. journal, 4(2):1-100, publisher, 2017. address. Key{avain} tag1,tag2.";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of toBibTex method, of class Article.
     */
    @Test
    public void testToBibTex() {
        System.out.println("toBibTex()");
        String expResult = "@article{avain,\n"
                + "author = {author1 and author2},\n"
                + "title = {title},\n"
                + "journal = {journal},\n"
                + "vol = {4},\n"
                + "number = {2},\n"
                + "year = {2017},\n"
                + "pages = {1--100},\n"
                + "publisher = {publisher},\n"
                + "address = {address},\n"
                + "}";
        assertEquals(expResult, instance.toBibTex());
    }
}
