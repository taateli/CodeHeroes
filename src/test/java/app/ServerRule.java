package app;


import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


// Lainattu
class ServerRule extends ExternalResource{
    
    ConfigurableApplicationContext app;
    private final int port;
    

    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        this.app = SpringApplication.run(App.class);
    }

    @Override
    protected void after() {
        app.close();
    }
}
// Lainattu loppuu


//public class ServerRule extends ExternalResource {
//    
//
////    App app;
//    private final int port;
//    private String[] args;
//
//    public ServerRule(int port) {
//        this.port = port;
//        System.out.println("portti on ok: " + port);
//    }
//
//    @Override
//    protected void before() throws Throwable {
//        System.setProperty("webdriver.chrome.driver", "/home/bensatu/Downloads/chromedriver");
//        System.out.println("chrome driven polku ok");
//
////        Spark.port(port);
////        App.main(null); 
////        Miten saadaan meidän sovellus käynnistymään täältä?
////        SpringApplication.run(App.class, args);
////       
//        System.out.println("sovellus käynnistyi  ok ");
//    }
//
//    @Override
//    protected void after() {
////        Spark.stop();
////        Oman sovelluksen pysäytys testien jälkeen.
////        SpringApplication.run(App.class, args).close();
//    }
//
//}
