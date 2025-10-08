package model;

public enum Category {
    PLANTS_SEEDS("Plantas y Semillas"),
    TOOLS("Herramientas"),
    SOIL_SUPPLIES("Suministros de Suelo"),
    PEST_CONTROL("Control de Plagas"),
    IRRIGATION("Irrigación"),
    DECORATION_MAINTENANCE("Decoración y Mantenimiento");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}