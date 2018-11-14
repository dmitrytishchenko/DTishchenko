package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter the task's id");
        String name = input.ask("Please, enter the task's name");
        String desc = input.ask("Please, enter the task's desc");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Item is replaced");
        } else {
            System.out.println("Item not found");
        }
    }
}
class FindItemById extends BaseAction {
    public FindItemById(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter the task's id");
        tracker.findById(id);
    }
}
class Exit extends BaseAction {
    private final StartUI ui;
    Exit(StartUI ui) {
        super(6, "Exit");
        this.ui = ui;
    }
    public void execute(Input input, Tracker tracker) {
        MenuTracker menu = new MenuTracker(input, tracker);
        System.out.println("Выход из программы.");
        this.ui.stop();
    }
}
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillactions(StartUI ui) {
        this.actions.add(new AddItem(0, "AddItem"));
        this. actions.add(new MenuTracker.ShowItems(1, "ShowItems"));
        this.actions.add(new EditItem(2, "EditItem"));
        this.actions.add(this.new DeleteItem(3, "DeleteItem"));
        this.actions.add(new FindItemById(4, "FindItemById"));
        this. actions.add(new MenuTracker.FindItemByName(5, "FindItemByName"));
        this.actions.add(new Exit(ui));
    }
    public int[] ranges() {
        int[] ranges = new int[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            ranges[i] = actions.get(i).key();
        }
        return ranges;
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name");
            String desc = input.ask("Please, enter the task's desc");
            tracker.add(new Item(name, desc));
        }
    }
    private static class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task's id");
            if (tracker.delete(id)) {
                System.out.println("Item deleted");
            } else {
                System.out.println("Item not found");
            }
        }
    }
    private static class FindItemByName extends BaseAction {
        public FindItemByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name");
            tracker.findByName(name);
            System.out.println("Find the item " + name);
        }
    }
}
