package model;
public class Product {
    private static int nextId = 1; // para asignar IDs unicos automaticamente
    private int id;
    private String name;
    private double price;
    private Category category;
    private String description;
    private int stock;

    public Product(String name, double price, Category category, String description, int stock) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.stock = stock;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio debe ser mayor o igual a cero.");
        }
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock debe ser mayor o igual a cero.");
        }
        this.stock = stock;
    }

    // metodos adicionales
    @Override
    public String toString() {
        return String.format("[#%d] %s - $%.2f | %s | Stock: %d unidades",
                id, name, price, category.getDisplayName(), stock);
    }
    public boolean isInStock() {
        return stock > 0;
    }

    public boolean isPriceValid() {
        return price > 0;
    }
}