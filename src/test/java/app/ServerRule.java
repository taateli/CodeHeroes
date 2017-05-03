package app;

import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

class ServerRule extends ExternalResource {

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
