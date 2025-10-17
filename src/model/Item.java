package model;

public abstract class Item {
    private int id;
    private String name;
    private double price;
    private String description;
    private static int nextId = 1;

    public Item(String name, double price, String description) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }
    
    // metodos adicionales
    public abstract String getTypeDescription();
}
