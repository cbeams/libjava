import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testSomeLibraryMethod() {
        assertThat(new Library().someLibraryMethod(), is(true));
    }
}
