package di;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by jojol on 2016-02-07.
 */
public class ScannerArgumentResolver implements ArgumentResolver {
    @Override
    public Argument resolve(InputStream stream) {
        Scanner sc = new Scanner(stream);
        int a = sc.nextInt();
        int b = sc.nextInt();
        return new Argument(a, b);

    }
}
