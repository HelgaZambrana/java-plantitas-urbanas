package model;
public class Product extends Item {
    private Category category;
    private int stock;

    public Product(String name, double price, Category category, String description, int stock) {
        super(name, price, description);
        this.category = category;
        this.stock = stock;
    }

    // getters
    public Category getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    // setters
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock debe ser mayor o igual a cero.");
        }
        this.stock = stock;
    }

    // metodos adicionales
    @Override
    public String getTypeDescription() {
        return "Producto de la categoria: " + category.getDisplayName();
    }   
}