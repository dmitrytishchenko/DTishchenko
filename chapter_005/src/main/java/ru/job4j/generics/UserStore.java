package ru.job4j.generics;

public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
//    private SimpleArray<User> massiv;
//
//    public UserStore(int size) {
//        this.massiv = new SimpleArray<>(size);
//    }
//
//    @Override
//    public void add(User model) {
//        this.massiv.add(model);
//    }
//
//    @Override
//    public boolean replace(String id, User model) {
//        boolean result = false;
//        for (int i = 0; i < this.massiv.getLenght(); i++) {
//            if (this.massiv.get(i).getId().equals(id)) {
//                this.massiv.set(i, model);
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        boolean result = false;
//        for (int i = 0; i < this.massiv.getLenght(); i++) {
//            if (this.massiv.get(i).getId().equals(id)) {
//                this.massiv.remove(i);
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public User findById(String id) {
//        User result = null;
//        for (User user : this.massiv) {
//            if (user.getId().equals(id)) {
//                result = user;
//            }
//        }
//        return result;
//    }
}
