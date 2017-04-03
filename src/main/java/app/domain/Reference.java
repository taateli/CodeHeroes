
package app.domain;

import java.util.List;

public interface Reference {
    
    String getTitle(); 
    List<String> getAuthors();
    String getAuthor();
    int getYear();
    String getPublisher();
    
    void setTitle(String title);
    void setAuthor(String author);
    void setYear(int year);
    void setPublisher(String publisher);
    
    String toString();
    
    String toBibTex();
}
