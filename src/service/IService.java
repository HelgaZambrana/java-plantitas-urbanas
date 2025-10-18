package service;

import java.util.ArrayList;

public interface IService<T> {
    // Crear: agregar un nuevo item
    void addItem(T item);
    // Listar: obtener todos los items
    ArrayList<T> getAll();
    // Buscar por ID: obtener un item por su ID
    T getById(int id);
    // Actualizar: modificar un item existente
    void updateItem(int id, T item);
    // Eliminar: eliminar un item por su ID
    void removeItem(int id);
}