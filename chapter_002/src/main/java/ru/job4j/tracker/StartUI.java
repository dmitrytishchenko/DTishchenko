package ru.job4j.tracker;
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    public static final String REPLACE = "2";
    public static final String DELETE = "3";
    public static final String FINDBYNAME = "4";
    public static final String FINDBYID ="5";
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
    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основной цикл программы.
     */
    public void init(){
        boolean exit = false;
        while(!exit){
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if(ADD.equals(answer)){
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.findAll();
            } else if(REPLACE.equals(answer)){
                this.replace();
            }else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (FINDBYID.equals(answer)){
                this.findById();
            }else if (EXIT.equals(answer)){
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem(){
        System.out.println("-----------Добавление новой заявки-----------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите имя заявки :");
        Item item = new Item("test name", "desc");
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "--------------");
    }

    private void findAll(){
        System.out.println("-----------Показать все заявки-------------");
        String name = this.input.ask("Показать все заявки");
        Item[] allItems = tracker.findAll();
        for (int i = 0; i != allItems.length; i++){
            if(allItems[i] != null) {
                System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Kомментарий: %s",
                        allItems[i].getId()+ allItems[i].getName() + allItems[i].getDesc() + allItems[i].getComments()));
            }
        }
    }
    private void replace(){
        System.out.println("------------Заменить заявку------------");
        Item item = new Item();
        String name = this.input.ask("Заменить заявку " + item.getId());
        this.tracker.replace(item.getId(), item);
    }
    private void delete(){
        System.out.println("---------------Удалить заявку--------------");
        Item item = new Item();
        String name = this.input.ask("Удалить заявку " + item.getId());
        this.tracker.delete(item.getId());
    }
    private void findByName(){
        System.out.println("-------------Найти заявку по имени---------------");
        Item item = new Item();
        String name = this.input.ask("Найти заявку по имени " + item.getName());
        this.tracker.findByName(item.getName());
    }
    private void findById(){
        System.out.println("-------------Найти заявку по id-------------");
        Item item = new Item();
        String name = this.input.ask("Найти заявку по id " + item.getId());
        this.tracker.findById(item.getId());
    }

    private void showMenu(){
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
