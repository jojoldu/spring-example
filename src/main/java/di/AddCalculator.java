package di;

import org.springframework.stereotype.Component;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */
@Component
public class AddCalculator implements Calculator{

    @Override
    public int calc(int a, int b) {
        return a+b;
    }
}
