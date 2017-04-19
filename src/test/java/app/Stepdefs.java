/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;

import static org.junit.Assert.assertTrue;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {

    WebDriver driver;
    String baseUrl;

    public Stepdefs() {

//        driver = new FirefoxDriver();
//        baseUrl = "http://localhost:8080";
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }

//        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", "/home/bensatu/Downloads/geckodriver");
        this.driver = new FirefoxDriver();
    }

    @Given("^form book is selected$")
    public void form_book_is_selected() throws Throwable {
        driver.get(baseUrl + "/books");
    }

    @Given("^form inproceedings is selected$")
    public void form_inproceedings_is_selected() throws Throwable {
        driver.get(baseUrl + "/inproceedings");
    }

    @Given("^form article is selected$")
    public void form_article_is_selected() throws Throwable {
        driver.get(baseUrl + "/article");
    }

    @When("^key \"([^\"]*)\" author \"([^\"]*)\" title \"([^\"]*)\" year \"([^\"]*)\" publisher \"([^\"]*)\" are inserted$")
    public void key_author_title_year_publisher_are_inserted(String key, String author, String title, String year, String publisher) throws Throwable {
        createBookWithMandatoryFields(key, author, title, year, publisher);

    }

    @When("^key \"([^\"]*)\" author \"([^\"]*)\" title \"([^\"]*)\" year \"([^\"]*)\" journal \"([^\"]*)\" publisher \"([^\"]*)\" volume \"([^\"]*)\" number \"([^\"]*)\" startingPage \"([^\"]*)\" endingPage \"([^\"]*)\" month \"([^\"]*)\" address \"([^\"]*)\" are inserted$")
    public void key_author_title_year_journal_publisher_volume_number_startingPage_endingPage_month_address_are_inserted(String key, String authors, String title, String year, String journal, String publisher, String volume, String number, String startingPage, String endingPage, String month, String address) throws Throwable {
        createArticle(key, authors, title, year, journal, publisher, volume, number, startingPage, endingPage, month, address);

    }

    @When("^key \"([^\"]*)\" author \"([^\"]*)\" title \"([^\"]*)\" year \"([^\"]*)\" pubisher \"([^\"]*)\" editor \"([^\"]*)\" booktitle \"([^\"]*)\" address \"([^\"]*)\" series \"([^\"]*)\" startingPage \"([^\"]*)\" endingPage \"([^\"]*)\" month \"([^\"]*)\" organization \"([^\"]*)\" are inserted$")
    public void key_author_title_year_pubisher_editor_booktitle_address_series_startingPage_endingPage_month_organization_are_inserted(
            String key, String author, String title, String year, String publisher, String editor, String booktitle, String address, String series, String startingPage, String endingPage, String month, String organization) throws Throwable {
        createInproceedings(key, author, title, year, publisher, editor, booktitle, address, series, startingPage, endingPage, month, organization);
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String arg1) throws Throwable {
        pageHasContent(arg1);
    }

// This method checks if page has text that is given as parameter    
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    // this method fills the book form with mandatory fields and submits.
    private void createBookWithMandatoryFields(String key, String author, String title, String year, String publisher) throws InterruptedException {
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
    private void createBookWithInputFields(String key, String author, String title, String year, String publisher, String month, String volume, String series, String edition) {
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
    // all fields included - if missing, different message given

    public void createArticle(String key, String author, String title, String year,
            String journal, String publisher, String volume, String number, String startingPage, String endingPage, String month, String address) {
        assertTrue(driver.getPageSource().contains("Add article reference"));
        WebElement element = driver.findElement(By.name("key"));
        element.sendKeys(key);
        element = driver.findElement(By.name("authors"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("journal"));
        element.sendKeys(journal);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("volume"));
        element.sendKeys(volume);
        element = driver.findElement(By.name("number"));
        element.sendKeys(number);
        element = driver.findElement(By.name("startingPage"));
        element.sendKeys(startingPage);
        element = driver.findElement(By.name("endingPage"));
        element.sendKeys(endingPage);
        element = driver.findElement(By.name("month"));
        element.sendKeys(month);
        element = driver.findElement(By.name("address"));
        element.sendKeys(title);

        element.submit();
    }

    public void createInproceedings(String key, String author, String title, String year, String publisher,
            String editor, String booktitle, String address, String series,
            String startingPage, String endingPage, String month, String organization
    ) {
        assertTrue(driver.getPageSource().contains("Add inproceedings reference"));
        WebElement element = driver.findElement(By.name("key"));
        element.sendKeys(key);
        element = driver.findElement(By.name("authors"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("editor"));
        element.sendKeys(editor);
        element = driver.findElement(By.name("bookTitle"));
        element.sendKeys(booktitle);
        element = driver.findElement(By.name("address"));
        element.sendKeys(address);
        element = driver.findElement(By.name("series"));
        element.sendKeys(series);
        element = driver.findElement(By.name("startingPage"));
        element.sendKeys(startingPage);
        element = driver.findElement(By.name("endingPage"));
        element.sendKeys(endingPage);
        element = driver.findElement(By.name("month"));
        element.sendKeys(month);
        element = driver.findElement(By.name("organization"));
        element.sendKeys(organization);

        element.submit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
