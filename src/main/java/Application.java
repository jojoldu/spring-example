import di.Argument;
import di.ArgumentResolver;
import di.Calculator;
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
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 2 number");

            ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
            Argument argument = argumentResolver.resolve(System.in);
            Calculator cal = context.getBean(Calculator.class);
            int result = cal.calc(argument.getA(), argument.getB());
            System.out.println(result);
        }
    }
}
