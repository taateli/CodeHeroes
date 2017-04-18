/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;

import static org.junit.Assert.assertTrue;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Stepdefs {

     WebDriver driver;
    String baseUrl;
        
     public Stepdefs(){
//        WebDriver driver = new ChromeDriver();
//        String baseUrl = "http://localhost:8080"; 
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080";
     }
    
     


    @Given("^form book is selected$")
    public void form_book_is_selected() throws Throwable {
        driver.get(baseUrl);
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.linkText("Books"));       
        element.click();
        
    }

    @When("^key \"([^\"]*)\" author \"([^\"]*)\" title \"([^\"]*)\" year \"([^\"]*)\" publisher \"([^\"]*)\" are inserted$")
    public void key_author_title_year_publisher_are_inserted(String key, String author, String title, String year, String publisher) throws Throwable {
        createBookWithMandatoryFields(key,author,title,year,publisher);
        

    }
//
//    @When("^submit is pressed$")
//    public void submit_is_pressed() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//    }

    
    
    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String arg1) throws Throwable {
        Thread.sleep(1000);
        pageHasContent(arg1);
    }
    

// This method checks if page has text that is given as parameter    
    
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
    
    // this method fills the book form with mandatory fields and submits.
    
    private void createBookWithMandatoryFields(String key, String author, String title, String year, String publisher) throws InterruptedException{
       Thread.sleep(2000);
        assertTrue(driver.getPageSource().contains("Add book reference"));
        WebElement element = driver.findElement(By.name("key"));
        element.sendKeys(key);
        element = driver.findElement(By.name("authors"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        Thread.sleep(2000);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
                
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        
        
        
        element = driver.findElement(By.name("save"));
        element.submit();
        
        
    }
    
// this is method to create book reference with all possible fields    
    
    private void createBookWithInputFields(String key, String author, String title, String year, String publisher, String month, String volume, String series, String edition){
        assertTrue(driver.getPageSource().contains("Add book reference"));
        WebElement element = driver.findElement(By.name("key"));
        element.sendKeys(key);
        element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("address"));
        element.sendKeys(title);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("month"));
        element.sendKeys(month);
        element = driver.findElement(By.name("vol"));
        element.sendKeys(volume);
        element = driver.findElement(By.name("series"));
        element.sendKeys(series);
        element = driver.findElement(By.name("edition"));
        element.sendKeys(edition);
        element = driver.findElement(By.name("save"));
        element.submit();
        
        
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
}
