package ru.job4j.tracker2;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

public class StartUI2 {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDITEMBYID = "4";
    private static final String FINDITEMBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker2 tracker2;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input    ввод данных.
     * @param tracker2 хранилище заявок.
     */
    public StartUI2(Input input, Tracker2 tracker2) {
        this.input = input;
        this.tracker2 = tracker2;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDITEMBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDITEMBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker2.add2(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод показывает все заявки
     */
    private void showItems() {
        System.out.println("-----------Вывод всех заявок--------------");
        this.tracker2.findAll2();
        for (Item item : this.tracker2.findAll2()) {
            System.out.println(item);
        }
    }

    private void editItem() {
        System.out.println("-----------Редактирование заявки-------------");
        String id = this.input.ask("Введите id заявки");
        String name = this.input.ask("Введите имя новой заявки");
        String desc = this.input.ask("Введите описание новой заявки");
        Item item = new Item(name, desc);
        this.tracker2.replace2(id, item);
        System.out.println(tracker2.findAll2()[0].getName());
    }

    private void delete() {
        System.out.println("----------Удаление заявки------------");
        String id = this.input.ask("Введите id заявки");
        this.tracker2.delete2(id);
    }

    private Item findItemById() {
        System.out.println("------------Поиск заявки по id-------------");
        String id = this.input.ask("Введите id заявки");
        Item result = this.tracker2.findById2(id);
        System.out.println(result);
        return result;
    }

    private void findItemByName() {
        System.out.println("------------Поиск заявки по имени-------------");
        String name = this.input.ask("Введите имя заявки");
        Item result = this.tracker2.findByName2(name);
        System.out.println(result);
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Create item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit program");
        System.out.println("Select:");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI2(new ConsoleInput(), new Tracker2()).init();
    }
}
