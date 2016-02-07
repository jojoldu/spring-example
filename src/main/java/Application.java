import di.Argument;
import di.ArgumentResolver;
import di.Calculator;
import di.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@EnableAutoConfiguration
@Import(AppConfig.class)
public class Application {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = SpringApplication.run(Application.class, args)){
            Frontend frontend = context.getBean(Frontend.class);
            frontend.run();
        }
    }
}
