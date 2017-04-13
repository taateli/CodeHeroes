/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author tatuhelander
 */
// Tässä on jotain yritystä saada Spring tuotua... 
// @RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//        loader = SpringApplicationContextLoader.class,
//        classes = App.class
//)
//@WebIntegrationTest(randomPort = true)
//public class StepDefs {
//
//    @Value("${local.server.port}")
//    int port;
//
//}
// -- 
public class Stepdefs {

    //    driver = new ChromeDriver();
    WebDriver driver = new ChromeDriver();

    String baseUrl = "http://localhost:8080";

    @Given("^form book is selected$")
    public void form_book_is_selected() throws Throwable {

        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^key \"([^\"]*)\" author \"([^\"]*)\" title \"([^\"]*)\" year \"([^\"]*)\" publisher \"([^\"]*)\" month \"([^\"]*)\" volume \"([^\"]*)\"are inserted$")
    public void key_author_title_year_publisher_month_volume_are_inserted(String key, String author, String title, String year, String publisher, String month, String volume) throws Throwable {

        WebElement element = driver.findElement(By.name("key"));
        element.sendKeys(key);
        element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("month"));
        element.sendKeys(month);
        element = driver.findElement(By.name("volume"));
        element.sendKeys(volume);
        element.submit();
        System.out.println("ok data");
    }

    @When("^submit is pressed$")
    public void submit_is_pressed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

}
