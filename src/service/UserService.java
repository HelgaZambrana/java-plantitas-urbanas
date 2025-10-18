package service;

import model.User;
import java.util.ArrayList;

public class UserService implements IService<User> {
    private ArrayList<User> users;

    // Constructor
    public UserService() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addItem(User item) {
        users.add(item);
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // si no se encuentra
    }

    @Override
    public void updateItem(int id, User item) {
        User existing = getById(id);
        if (existing != null) {
            existing.setName(item.getName());
            existing.setEmail(item.getEmail());
            existing.setAddress(item.getAddress());
            existing.setPhone(item.getPhone());
        }
    }

    @Override
    public void removeItem(int id) {
        User user = getById(id);
        if (user != null) {
            users.remove(user);
        }
    }
}