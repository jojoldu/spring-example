package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jojoldu@gmail.com on 2016-02-07.
 */
@Component
public class Frontend {
    @Autowired
    ArgumentResolver argumentResolver;

    @Autowired
    Calculator calculator;

    public void run(){
        System.out.println("Enter 2 number");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println(result);
    }
}
