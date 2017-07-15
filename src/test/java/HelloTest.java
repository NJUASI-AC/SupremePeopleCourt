import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/13.
 */
public class HelloTest {

    private Hello hello;

    @Before
    public void setUp() throws Exception {
        hello = new Hello();
    }

    @Test
    public void hello() throws Exception {
        assertEquals("Hello World!", hello.hello());
    }

}