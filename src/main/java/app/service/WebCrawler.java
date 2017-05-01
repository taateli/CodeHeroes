/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author villepaa
 */
@Service
public class WebCrawler {
    
    
    public String getReferences(String URL){
        
        try{
//             System.out.println(URL);
             Document document = Jsoup.connect(URL).userAgent("Mozilla").get();
//             System.out.println(document.absUrl(URL));
             Elements links = document.select("a[href]");
             Element bibtexLink = null;
             
             for(Element el:links){
                                  
                 if(el.ownText().equals("BibTeX")){
                    bibtexLink = el;
                     System.out.println("löytyi: " + bibtexLink.toString());
                 }
             }
//             Document references = Jsoup.connect(URL).userAgent("Mozilla").get();
             
             return "";
             
        } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
        }
        return "";
    }
    
}
