package ru.job4j.array;
public class TestTask {
    private char[] data;
    private char[] value;
    public boolean conteins(String origin, String sub) {
        boolean result = false;
        int temp = 0;
        char[] data = origin.toCharArray();
        char[] value = sub.toCharArray();
        for (int j = 0; j < origin.length(); j++) {
            if (data[j] == value[temp]) {
                temp++;
                if  (temp == sub.length()) {
                    result = true;
                    break;
                }
            } else {
                temp = 0;
            }
        } return result;
    }
}








