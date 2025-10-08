package model;

public class User {
    private static int nextId = 1; // para asignar IDs unicos automaticamente
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public User(String name, String email, String address, String phone) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }


    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email no puede estar vacío");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email debe contener @ y un dominio");
        }
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Teléfono no puede estar vacío");
        }
        if (!phone.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Teléfono debe contener dígitos");
        }
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("[Cliente #%d] %s | %s | Tel: %s",
               id, name, email, phone);
    }
    
}   