package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString();

    void getNextString();

    List<String> getHistoryPrintedStrings();

    void printCurrentString();

}
