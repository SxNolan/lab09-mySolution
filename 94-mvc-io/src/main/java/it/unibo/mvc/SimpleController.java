package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString;
    List<String> history;

    public SimpleController() {
        this.currentString = null;
        this.history = new ArrayList<>();
    }


    @Override
    public void setNextString(String nextString) {
        Objects.requireNonNull(nextString);
        this.currentString = nextString;
    }

    @Override
    public String getNextString(String CurrentString) {
        return this.currentString;
    }

    @Override
    public List<String> getHistoryPrintedStrings() {
        return this.history;
    }

    @Override
    public void printCurrentString() {
        if (this.currentString == null) {
            throw new IllegalStateException();
        }
        System.out.println(this.currentString);
        history.add(this.currentString);
    }

}
