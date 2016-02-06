import di.AddCalculator;
import di.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@Configuration
public class AppConfig {
    @Bean
    Calculator calculator(){
        return new AddCalculator();
    }
}
