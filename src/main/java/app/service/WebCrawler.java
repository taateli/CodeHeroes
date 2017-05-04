package app.service;

import app.domain.Article;
import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import java.io.IOException;
import java.util.List;
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

    @Autowired
    private UtilityService validator;

    /**
     * This method creates a Reference object from an ACM reference
     *
     * @param URL
     * @return
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
     * @param url
     * @return
     */
    private String extractId(String url) {
        String[] urlParts = url.split("&");
        if (urlParts.length > 1) {
            String[] idPart = urlParts[0].split("=");
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
     * @param String
     * @return
     */
    public Book bibtextToBook(String bibtext) {
        Book book = new Book();

        book.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        book.setTitle(searchField(bibtext, "title", '{', '}'));
        book.setYear(searchField(bibtext, "year", '{', '}'));
        book.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        book.setAddress(searchField(bibtext, "address", '{', '}'));
        book.setEdition(searchField(bibtext, "edition", '{', '}'));
        book.setMonth(searchField(bibtext, "month", '{', '}'));
        book.setSeries(searchField(bibtext, "series", '{', '}'));
        book.setKey(searchField(bibtext, "book", '{', ','));
        book.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));

        

        return book;
    }

    /**
     * This method handles turning BibTex format into an Inproceedings reference
     *
     * @param bibtext
     * @return
     */
    public Inproceedings bibtextToInproceedings(String bibtext) {
        Inproceedings inp = new Inproceedings();

        inp.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        inp.setTitle(searchField(bibtext, "title", '{', '}'));
        inp.setYear(searchField(bibtext, "year", '{', '}'));
        inp.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        inp.setAddress(searchField(bibtext, "address", '{', '}'));
        inp.setEditor(searchField(bibtext, "editor", '{', '}'));
//        inp.setMonth(searchField(bibtext, "month", '{', '}'));  data is: month = nov, no {}
        inp.setSeries(searchField(bibtext, "series", '{', '}'));
        inp.setMonth("");
        inp.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));
        inp.setEndingPage("");
        inp.setStartingPage("");
//      inp.setEndingPage(searchField(bibtext, "pages", '-', '}'));
//      inp.setStartingPage(searchField(bibtext, "pages", '{', '-'));
        inp.setOrganization(searchField(bibtext, "organization", '{', '}'));
        inp.setBookTitle(searchField(bibtext, "booktitle", '{', '}'));
        inp.setVolume(searchField(bibtext, "volume", '{', '}'));
        inp.setKey(searchField(bibtext, "proceedings", '{', ','));

        return inp;
    }

    /**
     * This method handles turning BibTex format into an Article reference
     *
     * @param bibtext
     * @param String
     * @return
     */
    public Article bibtextToArticle(String bibtext) {
        Article art = new Article();

        art.setAuthors(validator.splitAuthors(searchField(bibtext, "author", '{', '}')));
        art.setTitle(searchField(bibtext, "title", '{', '}'));
        art.setYear(searchField(bibtext, "year", '{', '}'));
        art.setPublisher(searchField(bibtext, "publisher", '{', '}'));
        art.setAddress(searchField(bibtext, "address", '{', '}'));
        art.setMonth(searchField(bibtext, "month", '{', '}'));
        art.setTags(validator.splitTags(searchField(bibtext, "keywords", '{', '}')));
        art.setStartingPage("");
        art.setEndingPage("");
//        art.setEndingPage(searchField(bibtext, "pages", '{', '-'));
//        art.setStartingPage(searchField(bibtext, "pages", '-', '}'));
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
     * @param field - the field header we are looking for like "title" -> title = {title of the publication}
     * @param start  - data begins after this starting character 
     * @param end - data ends before this ending character
     * @return String - the data value 
     */
    
     public static String searchField(String bibtex, String field, Character start, Character end){
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
                    dataIndex ++;
                }
                if (bibtex.charAt(i) == start) { // begin to collect data              
                    dataIndex = i;
                    dataIndex ++;
                }

            }
        }
        return data;
    
    }
//    
//    public static String searchField(String bibtex, String field) {
//        String data = "";
//        int index = 0;
//        if (bibtex.contains(field)) { // includes the field ("author"..) 
//
//            int start = bibtex.indexOf(field);
//            for (int i = start; i < bibtex.length(); i++) {
//                if (bibtex.charAt(index) == '}') { // when there is no more data...
//                    break; // ...this field is ready
//                }
//                if (index == i) {
//                    data = data + bibtex.charAt(i);
//                    index++;
//                }
//                if (bibtex.charAt(i) == '{') { // next time start extracting data from this point
//                    index = i;
//                    index++;
//                }
//
//            }
//        }
//        return data;
//    }
//
//    /**
//     * This method handles finding starting page from BibTex data
//     *
//     * @param String
//     * @return
//     */
//    public static String findEndingPage(String bibtex, String field) {
//        String data = "";
//        int index = 0;
//        if (bibtex.contains(field)) { // includes the field ("author"..) 
//            int start = bibtex.indexOf(field);
//            for (int i = start; i < bibtex.length(); i++) {
//                if (bibtex.charAt(index) == '}') { // when there is no more data...
//                    break; // ...this field is ready
//                }
//                if (index == i) {
//                    data = data + bibtex.charAt(i);
//                    index++;
//                }
//                if ((bibtex.charAt(i) == '-') && (bibtex.charAt(i + 1) == '-')) { // next time start extracting data from this point
//                    index = i;
//                    index = index + 2;
//                }
//            }
//        }
//        return data;
//    }
//
//    /**
//     * This method handles finding ending page from BibTex data
//     *
//     * @param String
//     * @return
//     */
//    public static String findStartingPage(String bibtex, String kentta) {
//        String data = "";
//        int dataIndeksi = 0;
//        if (bibtex.contains(kentta)) { // includes the field ("author"..) 
//
//            int alku = bibtex.indexOf(kentta);
//            for (int i = alku; i < bibtex.length(); i++) {
//                if (bibtex.charAt(dataIndeksi) == '-') { // when there is no more data...
//                    break; // ...this field is ready
//                }
//                if (dataIndeksi == i) {
//                    data = data + bibtex.charAt(i);
//                    dataIndeksi++;
//                }
//                if (bibtex.charAt(i) == '{') { // next time start extracting data from this point
//                    dataIndeksi = i;
//                    dataIndeksi++;
//                }
//
//            }
//        }
//        return data;
//    }

}
