package ru.job4j.multithreading.synch;

public class Storage<T> {
    private Save<T> save;

    public Save<T> getSave() {
        return save;
    }

    public void setSave(Save<T> save) {
        this.save = save;
    }
}
