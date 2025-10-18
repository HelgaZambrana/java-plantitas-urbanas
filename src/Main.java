import model.*;
import java.util.Scanner;
import service.ProductService;
import service.UserService;
import service.OrderService;

public class Main {
    // Servicios
    private static ProductService productService = new ProductService();
    private static UserService userService = new UserService();
    private static OrderService orderService = new OrderService();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initializeData();
        showMainMenu();
    }

    private static void initializeData() {
        // Crear productos iniciales
        productService.addItem(new Product("Suculenta", 15.99, Category.PLANTS_SEEDS,
            "Planta de bajo mantenimiento", 50));
        productService.addItem(new Product("Maceta de cerámica", 25.50, Category.DECORATION_MAINTENANCE,
            "Maceta decorativa 15cm", 30));
        productService.addItem(new Product("Fertilizante orgánico", 8.99, Category.SOIL_SUPPLIES,
            "Fertilizante 500g", 100));
        productService.addItem(new Product("Regadera 5L", 12.50, Category.IRRIGATION,
            "Regadera de plástico", 20));

        // Crear usuarios iniciales
        userService.addItem(new User("María González", "maria@email.com",
            "Av. Libertador 123", "+54 11 1234-5678"));
        userService.addItem(new User("Carlos Pérez", "carlos@email.com",
            "Calle Florida 456", "+54 11 8765-4321"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   PLANTITAS URBANAS - MENU PRINCIPAL   ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Listar productos disponibles");
            System.out.println("2. Listar usuarios registrados");
            System.out.println("3. Crear nueva orden");
            System.out.println("4. Listar todas las órdenes");
            System.out.println("5. Modificar un producto");
            System.out.println("6. Eliminar un producto");
            System.out.println("7. Salir");
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
                    modifyProduct();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    System.out.println("\n¡Gracias por usar Plantitas Urbanas!");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
    }

    private static void showProducts() {
        System.out.println("\n═══════════════ PRODUCTOS DISPONIBLES ═══════════════");
        for (Product p : productService.getAll()) {
            System.out.println(p);
        }
    }

    private static void showUsers() {
        System.out.println("\n═══════════════ USUARIOS REGISTRADOS ═══════════════");
        for (User u : userService.getAll()) {
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
            System.out.println("Usuario no encontrado.");
            return;
        }

        Order order = new Order(user);
        System.out.println("\nOrden creada para: " + user.getName());

        while (true) {
            showProducts();
            System.out.print("\nIngrese ID del producto (0 para finalizar): ");
            int prodId = scanner.nextInt();
            scanner.nextLine();

            if (prodId == 0) break;

            Product product = findProductById(prodId);
            if (product == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            try {
                order.addProduct(product);
                System.out.println("Producto agregado: " + product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (order.getProducts().size() > 0) {
            orderService.addItem(order);
            System.out.println("\nOrden creada exitosamente:");
            System.out.println(order);
            System.out.println("\nDetalle de productos:");
            for (Product p : order.getProducts()) {
                System.out.println("  • " + p.getName() + " - $" + String.format("%.2f", p.getPrice()));
            }
        } else {
            System.out.println("\nNo se agregaron productos. Orden cancelada.");
        }
    }

    private static void showOrders() {
        System.out.println("\n═══════════════ TODAS LAS ÓRDENES ═══════════════");
        if (orderService.getAll().isEmpty()) {
            System.out.println("No hay órdenes registradas.");
        } else {
            for (Order o : orderService.getAll()) {
                System.out.println(o);
            }
        }
    }

    private static User findUserById(int id) {
        return userService.getById(id);
    }

    private static Product findProductById(int id) {
        return productService.getById(id);
    }

    private static void modifyProduct() {
        System.out.println("\n═══════════════ MODIFICAR PRODUCTO ═══════════════");
        showProducts();
        System.out.print("\nIngrese el ID del producto a modificar: ");
        int prodId = scanner.nextInt();
        scanner.nextLine();

        Product product = findProductById(prodId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("\nProducto actual: " + product);
        System.out.println("\nIngrese los nuevos datos (presione Enter para mantener el valor actual):");
        
        // Modificar nombre
        System.out.print("Nuevo nombre [" + product.getName() + "]: ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            product.setName(newName);
        }

        // Modificar precio
        System.out.print("Nuevo precio [" + product.getPrice() + "]: ");
        String priceInput = scanner.nextLine();
        if (!priceInput.trim().isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceInput);
                product.setPrice(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido, se mantiene el anterior.");
            }
        }
        
        // Modificar descripción
        System.out.print("Nueva descripción [" + product.getDescription() + "]: ");
        String newDesc = scanner.nextLine();
        if (!newDesc.trim().isEmpty()) {
            product.setDescription(newDesc);
        }
        
        // Modificar stock
        System.out.print("Nuevo stock [" + product.getStock() + "]: ");
        String stockInput = scanner.nextLine();
        if (!stockInput.trim().isEmpty()) {
            try {
                int newStock = Integer.parseInt(stockInput);
                product.setStock(newStock);
            } catch (NumberFormatException e) {
                System.out.println("Stock inválido, se mantiene el anterior.");
            }
        }
        
        System.out.println("\nProducto modificado exitosamente:");
        System.out.println(product);
    }

        private static void deleteProduct() {
        System.out.println("\n═══════════════ ELIMINAR PRODUCTO ═══════════════");
        
        showProducts();
        System.out.print("\nIngrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Product product = productService.getById(id);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        
        System.out.println("\nProducto a eliminar: " + product);
        System.out.print("¿Está seguro que desea eliminarlo? (S/N): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("S") || confirm.equalsIgnoreCase("SI")) {
            productService.removeItem(id);
            System.out.println("\nProducto eliminado exitosamente.");
        } else {
            System.out.println("\nOperación cancelada.");
        }
    }
}