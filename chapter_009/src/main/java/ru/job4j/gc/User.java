package ru.job4j.gc;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("Destroy user object %s" + this));
    }

    public static void main(String[] args) {
        System.out.println("Start");
        User user1 = new User();
        System.out.println("Объем памяти для объекта без параметров " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
        //Объем памяти для объекта без параметров 3
        user1 = null;
        User user = new User("Den", 88);
        System.out.println(user.name);
        user1 = null;
        user = null;
        System.out.println("Finish");
    }
}
