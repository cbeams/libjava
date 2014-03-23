package io.beams.libjava;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testSomeLibraryMethod() {
        assertThat(new Library("libjava").someLibraryMethod(), is(true));
    }

    @Test
    public void testGetName() {
        assertThat(new Library("libjava").getName(), is("libjava"));
    }
}
