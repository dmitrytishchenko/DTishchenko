package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() throws Exception {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
}