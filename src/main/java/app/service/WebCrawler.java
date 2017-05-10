package app.service;

import app.domain.Article;
import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class that handles fetching references from ACM Digital Library
 *
 */
@Service
public class WebCrawler {

    Map<String, Integer> monthToInt = new HashMap<>();

    public WebCrawler() {
        // Initialize mont table 
        monthToInt.put(" jan", 1);
        monthToInt.put(" feb", 2);
        monthToInt.put(" mar", 3);
        monthToInt.put(" apr", 4);
        monthToInt.put(" may", 5);
        monthToInt.put(" jun", 6);
        monthToInt.put(" jul", 7);
        monthToInt.put(" aug", 8);
        monthToInt.put(" sep", 9);
        monthToInt.put(" oct", 10);
        monthToInt.put(" nov", 11);
        monthToInt.put(" dec", 12);
        monthToInt.put("", 0);
    }

    
    @Autowired
    private UtilityService validator;

    /**
     * This method creates a Reference object from an ACM reference
     *
     * @param URL String url of an ACM reference
     * @return Reference from ACM
     */
    public Reference getReference(String URL) {
        String acmId = extractId(URL);
        if (acmId == null) {
            return null;
        }
        String referenceUrl = "http://dl.acm.org/exportformats.cfm?id=" + acmId + "&expformat=bibtex";

        try {

            Document document = Jsoup.connect(referenceUrl).userAgent("Mozilla").get();
            Element references = document.select("PRE").first();
            String reference = references.ownText();
            String[] test1 = reference.split("@");
            String[] test2 = test1[1].split("[{]");
            Reference acmRef = null;
            if (test2[0].matches("book")) {
                acmRef = bibtextToBook(reference);
            } else if (test2[0].matches("inproceedings")) {
                acmRef = bibtextToInproceedings(reference);
            } else if (test2[0].matches("article")) {
                acmRef = bibtextToArticle(reference);
            }

            return acmRef;

        } catch (IOException e) {
            System.err.println("For '" + referenceUrl + "': " + e.getMessage());
            return null;
        }

    }

    /**
     * This method extracts the id of a reference in AMC library
     *
     * @param url String url with an id
     * @return part of the url with an id
     */
    private String extractId(String url) {
        String[] urlParts = url.split("&");
        String[] idPart = urlParts[0].split("=");
        if (idPart.length > 1) {
            if (idPart[1].contains(".")) {
                String[] id = idPart[1].split("[.]");
                return id[1];

            } else {
                return idPart[1];
            }
        }
        return null;
    }

    /**
     * This method handles turning BibTex format into a Book reference
     *
     * @param bibtext a book's information from ACM
     * @return new Book object
     */
    public Book bibtextToBook(String bibtext) {
        Book book = new Book();

        book.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        book.setTitle(searchField(bibtext, "title", '{', '}'));
        book.setYear(searchField(bibtext, "year", '{', '}'));
        book.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        book.setAddress(searchField(bibtext, "address", '{', '}'));
        book.setEdition(searchField(bibtext, "edition", '{', '}'));
          book.setMonth("");
        int month = monthToInt.get(searchField(bibtext, "month", '=', ','));
        if (month > 0) {
            book.setMonth("" + month);
        }
        book.setSeries(searchField(bibtext, "series", '{', '}'));
        book.setKey(searchField(bibtext, "book", '{', ','));
        book.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));

        return book;
    }

    /**
     * This method handles turning BibTex format into an Inproceedings reference
     *
     * @param bibtext an inproceedings' information from ACM
     * @return new Inproceedings object
     */
    public Inproceedings bibtextToInproceedings(String bibtext) {
        Inproceedings inp = new Inproceedings();

        inp.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        inp.setTitle(searchField(bibtext, "title", '{', '}'));
        inp.setYear(searchField(bibtext, "year", '{', '}'));
        inp.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        inp.setAddress(searchField(bibtext, "address", '{', '}'));
        inp.setEditor(searchField(bibtext, "editor", '{', '}'));
        inp.setSeries(searchField(bibtext, "series", '{', '}'));
                 inp.setMonth("");
        int month = monthToInt.get(searchField(bibtext, "month", '=', ','));
        if (month > 0) {
            inp.setMonth("" + month);
        }
        inp.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));
        inp.setEndingPage("");
        inp.setStartingPage("");
        inp.setEndingPage(searchField(bibtext, "pages", '-', '}'));
        inp.setStartingPage(searchField(bibtext, "pages", '{', '-'));
        inp.setOrganization(searchField(bibtext, "organization", '{', '}'));
        inp.setBookTitle(searchField(bibtext, "booktitle", '{', '}'));
        inp.setVolume(searchField(bibtext, "volume", '{', '}'));
        inp.setKey(searchField(bibtext, "proceedings", '{', ','));

        return inp;
    }

    /**
     * This method handles turning BibTex format into an Article reference
     *
     * @param bibtext an article's information from ACM
     * @return new Article object
     */
    public Article bibtextToArticle(String bibtext) {
        Article art = new Article();

        art.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        art.setTitle(searchField(bibtext, "title", '{', '}'));
        art.setYear(searchField(bibtext, "year", '{', '}'));
        art.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        art.setAddress(searchField(bibtext, "address", '{', '}'));
         art.setMonth("");
        int month = monthToInt.get(searchField(bibtext, "month", '=', ','));
        if (month > 0) {
            art.setMonth("" + month);
        }
        art.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));
        art.setStartingPage("");
        art.setEndingPage("");
        art.setEndingPage(searchField(bibtext, "pages", '-', '}'));
        art.setStartingPage(searchField(bibtext, "pages", '{', '-'));
        art.setJournal(searchField(bibtext, "journal", '{', '}'));
        art.setVolume(searchField(bibtext, "volume", '{', '}'));
        art.setNumber(searchField(bibtext, "number", '{', '}'));

        art.setKey(searchField(bibtext, "article", '{', ','));

        return art;
    }

    /**
     * This method helps finding the right field and data from BibTex
     *
     * @param bibtex - formalized data called bibtex
     * @param field - the field header we are looking for like "title", so title
     * = {title of the publication}
     * @param start - data begins after this starting character
     * @param end - data ends before this ending character
     * @return String - the data value
     */
    public static String searchField(String bibtex, String field, Character start, Character end) {
        String data = "";
        bibtex = ' ' + bibtex; // just in case the field from index 0
        int dataIndex = 0;
        if (bibtex.contains(field)) { // includes the header field ("author"..) 
            int fieldBeginIndex = bibtex.indexOf(field);
            for (int i = fieldBeginIndex; i < bibtex.length(); i++) {
                if (bibtex.charAt(i) == end) { // data ends
                    break;
                }
                if (dataIndex == i) { // this char is included the data
                    data = data + bibtex.charAt(i);
                    dataIndex++;
                }
                if (bibtex.charAt(i) == start) { // begin to collect data              
                    dataIndex = i;
                    dataIndex++;
                     if (start == '-') { // ending page data '--345}' -> 345
                        dataIndex++;
                        i ++;
                    }
                }

            }
        }
        return data;

    }

}
