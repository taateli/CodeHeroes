/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.domain.Book;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author kaisa
 */
public class ValidatorServiceTest {

    ValidatorService validator;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        validator = new ValidatorService();

    }

//    @Test
//    public void splitTagsSplitsTwoTagsAndFirstTagIsRight() {
//        String tagString = "some and someOther";
//        assertEquals("some", validator.splitTags(tagString).get(0));
//
//    }

//    @Test
//    public void splitTagsSplitsTwoTagsAndSecondTagIsRight() {
//        String tagString = "some and someOther";
//        assertEquals("someOther", validator.splitTags(tagString).get(1));
//    }
//
//    @Test
//    public void splitTagsWorksWithOneTag() {
//        String tagString = "some";
//        assertEquals(1, validator.splitTags(tagString).size());
//    }

    @Test
    public void getKeyWorksWhenNameHasWhiteSpace() {
        Book mockBook = mock(Book.class);
        List mockList = mock(List.class);
        when(mockBook.getYear()).thenReturn("2000");
        when(mockBook.getAuthors()).thenReturn(mockList);
        when(mockBook.getAuthors().get(0)).thenReturn("Teppo Testaaja");

        validator.getKey(mockBook);

        verify(mockBook).setKey("TT2000");
    }

    @Test
    public void getKeyWorksWhenNameHasNoWhiteSpaces() {
        Book mockBook = mock(Book.class);
        List mockList = mock(List.class);
        when(mockBook.getYear()).thenReturn("1997");
        when(mockBook.getAuthors()).thenReturn(mockList);
        when(mockBook.getAuthors().get(0)).thenReturn("SuperCool");

        validator.getKey(mockBook);

        verify(mockBook).setKey("S1997");
    }
}
