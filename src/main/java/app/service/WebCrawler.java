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
        String acmId = extractId(URL);
        if(acmId == null){
            return null;
        }
        String referenceUrl = "http://dl.acm.org/exportformats.cfm?id=" + acmId +"&expformat=bibtex";
       
        try{
            
            Document document = Jsoup.connect(referenceUrl).userAgent("Mozilla").get();
            Element references = document.select("PRE").first();
            System.out.println(references.ownText());  
            return references.ownText();
             
        } catch (IOException e) {
             System.err.println("For '" + referenceUrl + "': " + e.getMessage());
             return null;
        }
        
    }
    
    private String extractId(String url){
        String [] urlParts = url.split("=");
        if(urlParts.length > 1){
            String[]idPart = urlParts[1].split("&");
            String [] id = idPart[0].split("[.]");
            if(id.length > 1){
                return id[1];
            }    
        }
        return null;
    }
    
}

