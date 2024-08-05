package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private List<String> stringHistory = new ArrayList<>();

    @Override
    public void setNextString(String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("you can't set the next string to null");
        } else {
            this.nextString = s;
        }
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getStringHistory() {
        return List.copyOf(this.stringHistory);
    }

    @Override
    public void printString() {
        if (this.nextString == null) {
            throw new IllegalStateException("you didn't set the string to be printed");
        } else {
            stringHistory.add(nextString);
            System.out.println(nextString);
        }
    }
}
