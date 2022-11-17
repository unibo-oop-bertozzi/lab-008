package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private final List<String> lStrings = new ArrayList<>();
    private String s;
    @Override
    public String getNextString() {
        return s;
    }
    @Override
    public void printCurrentString() {
        if (this.s == null) {
            throw new IllegalStateException("There is no string set");
        }
        lStrings.add(this.s);
        System.out.println(this.s); // NOPMD: allowed in exercises
    }
    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(lStrings);    }
    @Override
    public void setString(final String stringa) {
        this.s = Objects.requireNonNull(stringa, "This method does not accept null values.");
    }
}
