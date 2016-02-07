package di;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by jojol on 2016-02-07.
 */
@RequiredArgsConstructor
public class Argument {
    private int a;
    private int b;

    public Argument() {
    }

    public Argument(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
