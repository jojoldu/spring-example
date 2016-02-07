package di;

import java.io.InputStream;

/**
 * Created by jojol on 2016-02-07.
 */
public interface ArgumentResolver {
    Argument resolve(InputStream stream);
}
