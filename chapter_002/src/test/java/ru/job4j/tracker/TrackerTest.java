package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void enumEager() {
        Tracker.TrackerSingleEnum trackerSingle = Tracker.TrackerSingleEnum.INSTANCE;
        Tracker.TrackerSingleEnum trackerSingle2 = Tracker.TrackerSingleEnum.INSTANCE;
        assertThat(trackerSingle, is(trackerSingle2));
    }
    @Test
    public void staticFieldLazy() {
        Tracker.TrackerSingle trackerSingle = Tracker.TrackerSingle.getInstance();
        Tracker.TrackerSingle trackerSingle2 = Tracker.TrackerSingle.getInstance();
        assertThat(trackerSingle, is(trackerSingle2));
    }
    @Test
    public void staticFieldEager() {
        Tracker.TrackerSingle trackerSingle = Tracker.TrackerSingle.getInstance2();
        Tracker.TrackerSingle trackerSingle2 = Tracker.TrackerSingle.getInstance2();
        assertThat(trackerSingle, is(trackerSingle2));
    }
    @Test
    public void staticFinalclassLazy() {
        Tracker.TrackerSingle trackerSingle = Tracker.TrackerSingle.getInstance3();
        Tracker.TrackerSingle trackerSingle2 = Tracker.TrackerSingle.getInstance3();
        assertThat(trackerSingle, is(trackerSingle2));
    }
}