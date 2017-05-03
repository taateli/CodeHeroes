package app.service;

import app.domain.Book;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilityServiceTest {

    @Autowired
    UtilityService validator;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

//    @Before
//    public void setUp() {
//        validator = new UtilityService();
//
//    }

    @Test
    public void splitTagsSplitsTwoTagsAndFirstTagIsRight() {
        String tagString = "some, someOther";
        assertEquals("some", validator.splitTags(tagString).get(0));

    }
    @Test
    public void splitTagsSplitsTwoTagsAndSecondTagIsRight() {
        String tagString = "some, someOther";
        assertEquals("someOther", validator.splitTags(tagString).get(1));
    }


    @Test
    public void splitTagsWorksWithOneTag() {
        String tagString = "some";
        assertEquals(1, validator.splitTags(tagString).size());
    }
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
  
