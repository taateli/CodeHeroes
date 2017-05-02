/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author villepaa
 */

public class WebCrawler {
    
    WebDriver driver;
    
    public WebCrawler(){
       
        File file;

        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else if (System.getProperty("os.name").matches("Linux")) {
            file = new File("lib/geckodriver");
        } else {
            file = new File("lib/wingeckodriver.exe");
        }

        String path = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path);
        this.driver = new FirefoxDriver();

    
    }
    
    public String getReferences(String URL) throws InterruptedException{
       

             this.driver.get(URL);
             WebElement bibtexLink = this.driver.findElement(By.linkText("BibTeX"));
             bibtexLink.click();
             Thread.sleep(5000);
             WebElement bibtex = this.driver.findElement(By.tagName("pre"));
             
             System.out.println(bibtex.getText());
             this.driver.quit();
             return "";
             
        
    }
    
}
