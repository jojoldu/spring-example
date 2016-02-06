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
            int a = sc.nextInt();
            int b = sc.nextInt();

            Calculator cal = context.getBean(Calculator.class);
            int result = cal.calc(a, b);
            System.out.println(result);
        }
    }
}
