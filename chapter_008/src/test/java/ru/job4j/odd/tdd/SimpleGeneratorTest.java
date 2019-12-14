package ru.job4j.odd.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleGeneratorTest {
    @Test
    public void test() {
        SimpleGenerator sg = new SimpleGenerator("I am a ${name}, Who are ${subject}?");
        Map<String, String> map = new HashMap<>();
        map.put("${subject}", "you");
        map.put("${name}", "Petr");
        String result = sg.generate(map);
        String expected = "I am a Petr, Who are you?";
        assertThat(expected, is(result));
    }

    @Test
    public void test2() {
        SimpleGenerator sg = new SimpleGenerator("Help, ${sos}, ${sos}, ${sos}");
        Map<String, String> map = new HashMap<>();
        map.put("${sos}", "Aaa");
        String result = sg.generate(map);
        String expected = "Help, Aaa, Aaa, Aaa";
        assertThat(expected, is(result));
    }
}