package io.beams.libjava;

import lombok.Data;

@Data
public class Library {

    private final String name;

    public boolean someLibraryMethod() {
        return true;
    }
}
