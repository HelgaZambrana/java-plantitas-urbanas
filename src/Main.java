import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Listas para almacenar datos
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();
        showMainMenu();
    }

    private static void initializeData() {
        // Crear productos iniciales
        products.add(new Product("Suculenta", 15.99, Category.PLANTS_SEEDS,
            "Planta de bajo mantenimiento", 50));
        products.add(new Product("Maceta de cerámica", 25.50, Category.DECORATION_MAINTENANCE,
            "Maceta decorativa 15cm", 30));
        products.add(new Product("Fertilizante orgánico", 8.99, Category.SOIL_SUPPLIES,
            "Fertilizante 500g", 100));
        products.add(new Product("Regadera 5L", 12.50, Category.IRRIGATION,
            "Regadera de plástico", 20));

        // Crear usuarios iniciales
        users.add(new User("María González", "maria@email.com",
            "Av. Libertador 123", "+54 11 1234-5678"));
        users.add(new User("Carlos Pérez", "carlos@email.com",
            "Calle Florida 456", "+54 11 8765-4321"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   🌱 PLANTITAS URBANAS - MENU PRINCIPAL   ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Ver usuarios registrados");
            System.out.println("3. Crear nueva orden");
            System.out.println("4. Ver todas las órdenes");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    createOrder();
                    break;
                case 4:
                    showOrders();
                    break;
                case 5:
                    System.out.println("\n¡Gracias por usar Plantitas Urbanas! 🌿");
                    return;
                default:
                    System.out.println("\n❌ Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void showProducts() {
        System.out.println("\n═══════════════ PRODUCTOS DISPONIBLES ═══════════════");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void showUsers() {
        System.out.println("\n═══════════════ USUARIOS REGISTRADOS ═══════════════");
        for (User u : users) {
            System.out.println(u);
        }
    }

    private static void createOrder() {
        System.out.println("\n═══════════════ CREAR NUEVA ORDEN ═══════════════");

        showUsers();
        System.out.print("\nIngrese el ID del cliente: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }

        Order order = new Order(user);
        System.out.println("\n✓ Orden creada para: " + user.getName());

        while (true) {
            showProducts();
            System.out.print("\nIngrese ID del producto (0 para finalizar): ");
            int prodId = scanner.nextInt();
            scanner.nextLine();

            if (prodId == 0) break;

            Product product = findProductById(prodId);
            if (product == null) {
                System.out.println("❌ Producto no encontrado.");
                continue;
            }

            try {
                order.addProduct(product);
                System.out.println("✓ Producto agregado: " + product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        if (order.getProducts().size() > 0) {
            orders.add(order);
            System.out.println("\n✓ Orden creada exitosamente:");
            System.out.println(order);
            System.out.println("\nDetalle de productos:");
            for (Product p : order.getProducts()) {
                System.out.println("  • " + p.getName() + " - $" + String.format("%.2f", p.getPrice()));
            }
        } else {
            System.out.println("\n❌ No se agregaron productos. Orden cancelada.");
        }
    }

    private static void showOrders() {
        System.out.println("\n═══════════════ TODAS LAS ÓRDENES ═══════════════");
        if (orders.isEmpty()) {
            System.out.println("No hay órdenes registradas.");
        } else {
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }

    private static User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    private static Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
