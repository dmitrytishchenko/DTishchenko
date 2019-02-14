package ru.job4j.generics;

public class RoleStore extends AbstractStore<Role> {
    public RoleStore(int size) {
        super(size);
    }
//    private SimpleArray<Role> massiv;
//
//    public RoleStore(int size) {
//        this.massiv = new SimpleArray<>(size);
//    }
//
//    @Override
//    public void add(Role model) {
//        this.massiv.add(model);
//    }
//
//    @Override
//    public boolean replace(String id, Role model) {
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
//    public Role findById(String id) {
//        Role result = null;
//        for (Role role : this.massiv) {
//            if (role.getId().equals(id)) {
//                result = role;
//            }
//        }
//        return result;
//    }
}
