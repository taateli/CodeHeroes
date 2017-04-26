/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Iisa
 */
public class ReferenceTest {

    Reference instance;

    public ReferenceTest() {
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
        instance.setAuthors(authors);

        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        instance.setTags(tags);
        instance.setKey("avain1");
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test of authorsToString method, of class Reference. One author.
     */
    @Test
    public void testAuthorsToStringOneAuthor() {
        System.out.println("authorsToString");
        String expResult = "author1";
        assertEquals(expResult, instance.authorsToString());
    }
    
    /**
     * Test of authorsToString method, of class Reference. Two authors.
     */
    @Test
    public void testAuthorsToStringTwoAuthors() {
        List<String> authors = new ArrayList<>();
        authors.add("author1");
        authors.add("author2");
        instance.setAuthors(authors);
        System.out.println("authorsToString");
        String expResult = "author1 and author2";
        assertEquals(expResult, instance.authorsToString());
    }
    
    /**
     * Test of authorsToString method, of class Reference. Three authors.
     */
    @Test
    public void testAuthorsToStringThreeAuthors() {
        List<String> authors = new ArrayList<>();
        authors.add("author1");
        authors.add("author2");
        authors.add("author3");
        instance.setAuthors(authors);
        System.out.println("authorsToString");
        String expResult = "author1, author2, and author3";
        assertEquals(expResult, instance.authorsToString());
    }
    
    /**
     * Test of tagsToString method, of class Reference. One tag.
     */
    @Test
    public void testTagsToStringOneTag() {
        System.out.println("tagsToString");
        String expResult = "tag1";
        assertEquals(expResult, instance.tagsToString());
    }
    
    /**
     * Test of tagsToString method, of class Reference. Two tags.
     */
    @Test
    public void testTagsToStringTwoTags() {
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        instance.setTags(tags);
        System.out.println("tagsToString");
        String expResult = "tag1,tag2";
        assertEquals(expResult, instance.tagsToString());
    }
    
    /**
     * Test of tagsToString method, of class Reference. Three tags.
     */
    @Test
    public void testTagsToStringThreeTags() {
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        tags.add("tag3");
        instance.setTags(tags);
        System.out.println("tagsToString");
        String expResult = "tag1,tag2,tag3";
        assertEquals(expResult, instance.tagsToString());
    }
    
    /**
     * Test of setKey method, of class Reference.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        Reference instance = new Article();
        instance.setKey("avain");
        assertEquals("avain", instance.getKey());
    }
    
    /**
     * Test of getKey method, of class Reference.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        assertEquals("avain1", instance.getKey());
    }
    
}
