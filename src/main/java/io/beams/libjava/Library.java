// Generated by delombok at Wed Mar 11 12:14:21 UTC 2015
package io.beams.libjava;

public class Library {
    private final String name;

    public boolean someLibraryMethod() {
        return true;
    }

    @java.beans.ConstructorProperties({"name"})
    @java.lang.SuppressWarnings("all")
    public Library(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Library)) return false;
        final Library other = (Library)o;
        if (!other.canEqual((java.lang.Object)this)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    public boolean canEqual(final java.lang.Object other) {
        return other instanceof Library;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "Library(name=" + this.getName() + ")";
    }
}