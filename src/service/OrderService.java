package service;

import model.Order;
import java.util.ArrayList;

public class OrderService implements IService<Order> {
    private ArrayList<Order> orders;

    // Constructor
    public OrderService() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addItem(Order item) {
        orders.add(item);
    }

    @Override
    public ArrayList<Order> getAll() {
        return orders;
    }

    @Override
    public Order getById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null; // si no se encuentra
    }

    @Override
    public void updateItem(int id, Order item) {
        Order existing = getById(id); // Implementacion basica porque las ordenes no se actualizan
        if (existing != null) {
        }
    }

    @Override
    public void removeItem(int id) {
        Order order = getById(id);
        if (order != null) {
            orders.remove(order);
        }
    }
}