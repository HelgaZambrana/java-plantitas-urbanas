package service;

import model.Product;
import java.util.ArrayList;

public class ProductService implements IService<Product> {
    private ArrayList<Product> products;

    // Constructor
    public ProductService() {
        this.products = new ArrayList<>();
    }

    @Override
    public void addItem(Product item) {
        products.add(item);
    }

    @Override
    public ArrayList<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // si no se encuentra
    }

    @Override
    public void updateItem(int id, Product item) {
        Product existing = getById(id);
        if (existing != null) {
            existing.setName(item.getName());
            existing.setPrice(item.getPrice());
            existing.setCategory(item.getCategory());
            existing.setDescription(item.getDescription());
            existing.setStock(item.getStock());
        }
    }

    @Override
    public void removeItem(int id) {
        Product product = getById(id);
        if (product != null) {
            products.remove(product);
        }
    }
}