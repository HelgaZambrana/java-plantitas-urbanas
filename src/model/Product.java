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

    // Método para verificar si hay stock disponible
    public boolean isInStock() {
        return stock > 0;
    }

    // Método para verificar si el precio es válido
    public boolean isPriceValid() {
        return getPrice() > 0;  // usa getPrice() heredado de Item
    }

    // Método toString para mostrar información del producto
    @Override
    public String toString() {
        return String.format("[#%d] %s - $%.2f | %s | Stock: %d unidades",
            getId(), getName(), getPrice(), category.getDisplayName(), stock);
    }

    @Override
    public String getTypeDescription() {
        return "Producto de la categoria: " + category.getDisplayName();
    }   
}