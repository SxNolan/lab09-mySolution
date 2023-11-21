package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString(String nextString);

    String getNextString(String CurrentString);

    List<String> getHistoryPrintedStrings();

    void printCurrentString();

}
