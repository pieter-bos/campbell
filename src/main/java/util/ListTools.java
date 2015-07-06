package util;

import java.util.LinkedList;
import java.util.List;

/**
 * Class used for extra operation needed on lists
 */
public class ListTools {

    /**
     * Method that reverses a given list
     * @param data - list to be reversed
     * @return reversed list
     */
    public static <T> LinkedList<T> reversed(List<? extends T> data) {
        LinkedList<T> result = new LinkedList<>();

        for(T elem : data) {
            result.addFirst(elem);
        }

        return result;
    }
}
