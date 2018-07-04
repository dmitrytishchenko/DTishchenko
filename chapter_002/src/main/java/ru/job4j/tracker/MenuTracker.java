package ru.job4j.tracker;

class EditItem implements UserAction {
        public int key(){
            return 2;
        }
        public void execute(Input input, Tracker tracker){
            String id = input.ask("Please enter the task's id");
            String name = input.ask("Please, enter the task's name");
            String desc = input.ask("Please, enter the task's desc");
            Item item = new Item(name, desc);
            item.setId(id);
            tracker.edit(item);
        }
        public String info(){
            return String.format("%s. %s", this.key(), "Edit the new Item.");
        }
    }
class FindItemById implements UserAction {
    public int key(){
        return 4;
    }
    public void execute(Input input, Tracker tracker){
        String id = input.ask("Please enter the task's id");
        tracker.findById(id);
    }
    public String info(){
        return String.format("%s. %s", this.key(), "Find item by id.");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillactions(){
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new MenuTracker.FindItemByName();
    }
    public void select(int key){
        this.actions[key].execute(this.input, this.tracker);
    }
    public void show(){
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem implements UserAction {
        public int key(){
            return 0;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please, enter the task's name");
            String desc = input.ask("Please, enter the task's desc");
            tracker.add(new Item(name, desc));

        }
        public String info(){
            return String.format("%s. %s", this.key(), "Add the new Item.");
        }

    }
    private static class ShowItems implements UserAction {
        public int key(){
            return 1;
        }
        public void execute(Input input, Tracker tracker){
            for(Item item: tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }

        }
        public String info(){
            return String.format("%s. %s", this.key(), "Show all Item's.");
        }

    }
    private class DeleteItem implements UserAction{
        public int key(){
            return 3;
        }
        public void execute(Input input, Tracker tracker){
            String id = input.ask("Please enter the task's id");
            Item item = new Item();
            item.setId(id);
            tracker.delete(id);
        }
        public String info(){
            return String.format("%s. %s", this.key(), "Delete the Item.");
        }
    }
    private static class FindItemByName implements UserAction {
        public int key(){
            return 5;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please enter the task's name");
            tracker.findByName("5");
        }
        public String info(){
            return String.format("%s. %s", this.key(), "Find Item by name.");
        }

    }
}
