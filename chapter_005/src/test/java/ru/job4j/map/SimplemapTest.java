package ru.job4j.map;

import org.junit.Test;


public class SimplemapTest {
    @Test
    public void whenDoNotOverrideEqualsHashCode() {
        Simplemap simplemap = new Simplemap();
        simplemap.map();
    }
}