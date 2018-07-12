package ru.job4j.tracker;
public class StartUI {
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
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillactions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.ranges()));
        } while (!"y".equals(this.input.ask("Exit? (y):")));
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
