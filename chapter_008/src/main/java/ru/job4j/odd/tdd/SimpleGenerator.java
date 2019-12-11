package ru.job4j.odd.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator {

    private final Pattern KEYS = Pattern.compile("([\\$][\\{]([a-z]){1,}[\\}])");
    private String template;

    public SimpleGenerator(String template) {
        this.template = template;
    }

    public String generate(Map<String, String> map) {
        int count = 0;
        try {
            Matcher m = KEYS.matcher(template);
            while (m.find()) {
                template = template.replaceFirst(KEYS.pattern(), map.get(m.group()));
                count++;
            }
            if (count < map.keySet().size()) {
                throw new Exception("В карте есть лишние ключи.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return template;
    }
}
