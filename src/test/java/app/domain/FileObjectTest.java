package app.domain;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FileObjectTest {

    FileObject instance;

    public FileObjectTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        byte[] content = new byte[10];
        String name = "name1";
        instance = new FileObject(content, name);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of the Constructor of the class FileObject.
     */
    @Test
    public void testNameCorrect() {

        byte[] content = new byte[10];
        String name = "name3.bib";
        instance = new FileObject(content, name);
        System.out.println("getName");
        String result = instance.getName();
        assertEquals("name3.bib", result);
    }

    /**
     * Test of the Constructor of the class FileObject.
     */
    @Test
    public void testNameCorrectIfNoName() {
        byte[] content = new byte[10];
        instance = new FileObject(content, null);
        System.out.println("getName");
        String result = instance.getName();
        assertEquals("sigproc.bib", result);
    }

    /**
     * Test of getName-method, class FileObject.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String result = instance.getName();
        assertEquals("name1.bib", result);
    }

    /**
     * Test of setName-method, class FileObject.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        instance.setName("name2.bib");
        assertEquals("name2.bib", instance.getName());
    }

    /**
     * Test of getContentLength-method, class FileObject.
     */
    @Test
    public void testGetContentLength() {
        System.out.println("getContentLength");
        long result = instance.getContentLength();
        assertEquals(10, result);
    }

    /**
     * Test of setContentLength-method, class FileObject.
     */
    @Test
    public void testSetContentLength() {
        System.out.println("setContentLength");
        long length = 12;
        instance.setContentLength(length);
        String lengthToString = Long.toString(instance.getContentLength());
        assertEquals("12", lengthToString);
    }

    /**
     * Test of getContent-method, class FileObject.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        byte[] content = instance.getContent();
        long length = content.length;
        assertEquals(10, length);
    }

    /**
     * Test of setContent-method, class FileObject.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        byte[] content2 = new byte[8];
        instance.setContent(content2);
        long length = instance.getContent().length;
        assertEquals(8, length);
    }
}
