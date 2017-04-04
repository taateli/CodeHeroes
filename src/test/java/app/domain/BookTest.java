/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author tatuhelander
 */
public class BookTest {
    
    Book book;
    
    @Before
    public void setUp(){
        book = new Book();
    }
    
    @Test
    public void testaaLisays(){
        book.setAuthor("Tatu");
        
        assertEquals("Tatu", book.getAuthor());
       
    } 
    
}
