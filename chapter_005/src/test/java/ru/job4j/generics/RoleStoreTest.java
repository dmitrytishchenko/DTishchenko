package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    Role role1 = new Role("role1");
    Role role2 = new Role("role2");
    Role role3 = new Role("role3");

    @Test
    public void whenAddUserToStore() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.findById("role1"), is(role1));
    }
    @Test
    public void whenReplaceUserInStore() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        boolean result = roleStore.replace("role1", role3);
        assertThat(result, is(true));
    }
    @Test
    public void whenDeleteUserFromStore() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        boolean result = roleStore.delete("role1");
        assertThat(result, is(true));
    }
    @Test
    public void whenFindUserById() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        Role result = roleStore.findById("role1");
        assertThat(result, is(role1));
    }

}