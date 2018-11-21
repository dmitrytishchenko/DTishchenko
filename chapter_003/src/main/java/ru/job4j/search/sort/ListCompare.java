package ru.job4j.search.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int index = 0;
        int result = 0;
        while (index < length && result == 0) {
            char c1 = left.charAt(index);
            char c2 = right.charAt(index);
            result = Character.compare(c1, c2);
            index++;
        } if (result == 0){
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
