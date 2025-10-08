package model;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private static int nextId = 1; // para asignar IDs unicos automaticamente
    private int id;
    private User user;  // relacion 1 a 1
    private ArrayList<Product> products; // relacion 1 a muchos
    private Date orderDate;
    private double totalAmount;

    public Order(User user) {
        this.id = nextId++;
        this.user = user;
        this.products = new ArrayList<>();
        this.orderDate = new Date(); // inicializa con la fecha actual
        this.totalAmount = 0.0;
    }

    // getters
    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // metodo: agregar producto al pedido
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Producto no puede ser nulo");
        }
        if (!product.isInStock()) {
            throw new IllegalArgumentException("Producto fuera de stock");
        }
        products.add(product);
        calculateTotal();
    }

    // metodo: eliminar producto del pedido
    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Producto no puede ser nulo");
        }
        products.remove(product);
        calculateTotal();
    }

    // metodo: calcular total del pedido
    public void calculateTotal() {
        totalAmount = 0.0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", user=" + user +
               ", numProducts=" + products.size() +
               ", orderDate=" + orderDate +
               ", totalAmount=$" + totalAmount +
               '}';
    }
}