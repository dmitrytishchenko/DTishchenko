package ru.job4j.tracker;
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FINDBYNAME = "4";
    private static final String FINDBYID = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок
     */
    private final Tracker tracker;
    /**
     * Конструктор инициализирующий поля
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.findAll();
            } else if (REPLACE.equals(answer)) {
                this.replace();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("-----------Добавление новой заявки-----------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "--------------");
    }
    private void findAll() {
        System.out.println("-----------Показать все заявки-------------");
        Item[] allItems = tracker.findAll();
        for (int i = 0; i != allItems.length; i++) {
            if (allItems[i] != null) {
                System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Kомментарий: %s",
                        allItems[i].getId(), allItems[i].getName(), allItems[i].getDesc(), allItems[i].getComments()));
            }
        }
    }
    private void replace() {
        System.out.println("------------Заменить заявку------------");
        String id = this.input.ask("Заменить заявку ");
        String name = this.input.ask("Введите имя новой заявки");
        String desc = this.input.ask("Введите описание новой заявки");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Kомментарий: %s",
                item.getId(), item.getName(), item.getDesc(), item.getComments()));
    }
    private void delete() {
        System.out.println("---------------Удалить заявку--------------");
        String id = this.input.ask("Удалить заявку");
        this.tracker.delete(id);
    }
    private void findByName() {
        System.out.println("-------------Найти заявку по имени---------------");
        String key = this.input.ask("Найти заявку по имени ");
        Item[] byNameItems = tracker.findByName2(key);
        for (int i = 0; i != byNameItems.length; i++) {
            if (byNameItems[i] != null) {
                System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Kомментарий: %s",
                        byNameItems[i].getId(), byNameItems[i].getName(), byNameItems[i].getDesc(), byNameItems[i].getComments()));
            }
        }
    }
    private void findById() {
        System.out.println("-------------Найти заявку по id-------------");
        String id = this.input.ask("Найти заявку по id ");
        Item result = tracker.findById(id);
        System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Kомментарий: %s",
                result.getId(), result.getName(), result.getDesc(), result.getComments()));
    }
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 " + "Добавление новой заявки");
        System.out.println("1 " + "Показать все заявки");
        System.out.println("2 " + "Заменить заявку");
        System.out.println("3 " + "Удалить заявку");
        System.out.println("4 " + "Найти заявку по имени");
        System.out.println("5 " + "Найти заявку по id ");
        System.out.println("6 " + "Выход");

//            добавить остальные пункты меню
    }
    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
