import di.Argument;
import di.ArgumentResolver;
import di.Calculator;
import di.Frontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@EnableAutoConfiguration
@ComponentScan("di")
public class Application implements CommandLineRunner{

    @Autowired
    ArgumentResolver argumentResolver;

    @Autowired
    Calculator calculator;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter 2 number");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
