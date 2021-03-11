package selenium.tests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:conf.properties")
@Component
@Configuration
public class Property{

    @Value("${chromedriver}")
    private String chromedriver;

    public  String getChromedriver() {
        return chromedriver;
    }

}
