import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bienvenido a Plantitas Urbanas ===\n");

        // ========================================
        // PASO 1: Crear productos
        // ========================================
        System.out.println("--- PRODUCTOS DISPONIBLES ---");

        Product producto1 = new Product(
            "Suculenta",                    // nombre
            15.99,                          // precio
            Category.PLANTS_SEEDS,          // categoría
            "Planta de bajo mantenimiento", // descripción
            50                              // stock
        );

        Product producto2 = new Product(
            "Maceta de cerámica",
            25.50,
            Category.DECORATION_MAINTENANCE,
            "Maceta decorativa 15cm",
            30
        );

        Product producto3 = new Product(
            "Fertilizante orgánico",
            8.99,
            Category.SOIL_SUPPLIES,
            "Fertilizante 500g",
            100
        );

        // Imprimir productos (toString se llama automáticamente)
        System.out.println(producto1);
        System.out.println(producto2);
        System.out.println(producto3);
        System.out.println();

        // ========================================
        // PASO 2: Crear usuarios
        // ========================================
        System.out.println("--- USUARIOS REGISTRADOS ---");

        User usuario1 = new User(
            "María González",           // nombre
            "maria@email.com",          // email
            "Av. Libertador 123",       // dirección
            "+54 11 1234-5678"          // teléfono
        );

        User usuario2 = new User(
            "Carlos Pérez",
            "carlos@email.com",
            "Calle Florida 456",
            "+54 11 8765-4321"
        );

        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println();

        // ========================================
        // PASO 3: Crear una orden
        // ========================================
        System.out.println("--- CREANDO ORDEN ---");

        // Crear orden para usuario1
        Order orden1 = new Order(usuario1);

        // Agregar productos a la orden
        orden1.addProduct(producto1);  // Suculenta
        orden1.addProduct(producto2);  // Maceta
        orden1.addProduct(producto3);  // Fertilizante

        System.out.println("Orden creada:");
        System.out.println(orden1);
        System.out.println();

        // ========================================
        // PASO 4: Probar métodos
        // ========================================
        System.out.println("--- PROBANDO MÉTODOS ---");

        // Ver productos de la orden
        System.out.println("Productos en la orden:");
        for (Product p : orden1.getProducts()) {
            System.out.println("  - " + p.getName() + " ($" + p.getPrice() + ")");
        }
        System.out.println();

        // Remover un producto
        System.out.println("Removiendo fertilizante...");
        orden1.removeProduct(producto3);
        System.out.println("Total actualizado: $" + orden1.getTotalAmount());
        System.out.println();

        // Verificar stock
        System.out.println("¿Suculenta en stock? " + producto1.isInStock());
    }
}
