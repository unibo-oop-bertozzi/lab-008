package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * @return nextstring
     */
    String getNextString();
    /**
     * 
     */
    void printCurrentString();
    /**
     * @return gethistory
     */
    List<String> getHistory();
    /**
     * @param stringa
     */
    void setString(String stringa);
}
