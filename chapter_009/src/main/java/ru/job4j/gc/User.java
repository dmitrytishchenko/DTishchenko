package ru.job4j.gc;

/**
 * Basic class User
 */
public class User {
    private String name;
    private int age;

    /**
     * @param name the User
     * @param age  the User
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    /**
     * @throws Throwable Переопределенный метод finalize(), но он устарел для java > 8.
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("Destroy user object %s" + this));
    }

    public static void main(String[] args) {
        /**
         * Type of garbage collector:
         * Serial GC -XX:+UseSerialGC.
         * Parallel GC -XX:+UseParallelGC.
         * Concurrent Mark Sweep (CMS) GC -XX:+UseConcMarkSweepGC.
         * G1 GC -XX:+UseG1GC
         */
        System.out.println("Start");
        User user1 = new User();
        user1 = null;
        for (int i = 0; i < 10; i++) {
            User user = new User("Den", 88);
            System.out.println(user.name);
            user = null;
        }
        user1 = null;
        System.out.println("Объем памяти для объекта без параметров " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
        System.out.println("Total memory " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("Free memory " + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("Finish");
        /**
         * Serial GC - периодически срабатывает gc, подходит для небольших консольных приложений, т.к. задержка 1-2 секунды ни на что не влияет
         * Parallel GC - удалось сработать gc только создав цикл на 10 объектов User, работает также как serial gc, только в несколько потоков, поэтому имеет большую скорость
         * CMS GC - удалось вызвать gc сразу и плюс получил сообщение от OpenJDK - OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
         * данный сборщик устарел и будет удален в следующем релизе. Работает быстрее Serial gc и Parallel gc, но old generation не оптимизирует после удаления объектов
         * G1 GC сработал сразу после превого вызова, является лучшим GC, данный коллектор собрал в себе все лучшее с предыдуших коллекторов и с java 8 применяется по умолчанию.
         */
    }
}
