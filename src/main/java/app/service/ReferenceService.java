
package app.service;

import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceService {
    
    @Autowired
    private BookRepository bookRepository;
    
//    public boolean addBookReference(Book b){
//
//        return bookRepository.save(b);
//    }
//
}
