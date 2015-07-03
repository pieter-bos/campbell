package util;

import java.util.LinkedList;
import java.util.List;

public class ListTools {
    public static <T> LinkedList<T> reversed(List<? extends T> data) {
        LinkedList<T> result = new LinkedList<>();

        for(T elem : data) {
            result.addFirst(elem);
        }

        return result;
    }
}
