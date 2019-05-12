package ru.job4j.xmlxslt;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entry {
    private int field;

    public Entry(int field) {
        this.field = field;
    }

    public Entry() {
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
