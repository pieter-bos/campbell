package util;

import java.util.Iterator;
import java.util.LinkedList;

public class HashList<T> extends LinkedList<T> {
    @Override
    public int hashCode() {
        int result = 0x01234567;

        for(T t : this) {
            result ^= t.hashCode();
            result *= 137;
        }

        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof HashList)) {
            return false;
        }

        if(this.size() != ((HashList) other).size()) {
            return false;
        }


        try {
            Iterator<T> left = this.iterator();
            @SuppressWarnings("unchecked")
            Iterator<T> right = ((HashList) other).iterator();

            while(left.hasNext()) {
                T leftT = left.next();
                T rightT = right.next();

                if(!leftT.equals(rightT)) {
                    return false;
                }
            }
        } catch(ClassCastException e) {
            return false;
        }

        return true;
    }
}
