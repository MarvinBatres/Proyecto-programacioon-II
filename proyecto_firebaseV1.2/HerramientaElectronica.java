
package com.mycompany.proyecto_firebase;


import com.mycompany.proyecto_firebase.Producto;


/**
 * CLASE HIJA: HerramientaElectronica
 * Hereda de Producto y representa herramientas para reparación y mantenimiento electrónico
 */
public class HerramientaElectronica extends Producto {
    // ==================== ATRIBUTOS PROPIOS ====================
    private String tipoHerramienta;        // Ej: "Desarmador", "Soldador", "Multímetro"
    private String tipoFuenteEnergia;      // Ej: "Eléctrica", "Batería", "Manual"
    private double voltaje;                // Voltaje de operación (si aplica)
    private boolean fuenteDeBateria;       // Si funciona con baterías
    private boolean incluyeEstuche;        // Si incluye estuche o maletín
    private String material;               // Ej: "Acero", "Plástico", "Metal"
    private String aplicacion;             // Ej: "Computadoras", "Celulares", "Hogar"
    private int cantidadPiezas;            // Número de piezas en el kit

    // ==================== CONSTRUCTOR ====================
    /**
     * CONSTRUCTOR COMPLETO - Inicializa atributos padre e hijos
     * @param Id - ID del producto (padre)
     * @param nombre - Nombre del producto (padre)
     * @param precio - Precio base (padre)
     * @param stock - Cantidad disponible (padre)
     * @param marca - Marca del producto (padre)
     * @param modelo - Modelo específico (padre)
     * @param garantia - Años de garantía (padre)
     * @param tipoHerramienta - Tipo de herramienta (hijo)
     * @param tipoFuenteEnergia - Fuente de energía (hijo)
     * @param voltaje - Voltaje de operación (hijo)
     * @param fuenteDeBateria - Si usa baterías (hijo)
     * @param incluyeEstuche - Si incluye estuche (hijo)
     * @param material - Material de construcción (hijo)
     * @param aplicacion - Aplicación principal (hijo)
     * @param cantidadPiezas - Número de piezas (hijo)
     */
    public HerramientaElectronica(int Id, String nombre, Double precio, int stock, 
                                 String marca, String modelo, double garantia,
                                 String tipoHerramienta, String tipoFuenteEnergia, 
                                 double voltaje, boolean fuenteDeBateria, 
                                 boolean incluyeEstuche, String material,
                                 String aplicacion, int cantidadPiezas) {
        
        // ✅ super() - Llama al constructor de la clase Padre (Producto)
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        
        // ✅ Inicializa atributos propios de la clase hija
        this.tipoHerramienta = tipoHerramienta;
        this.tipoFuenteEnergia = tipoFuenteEnergia;
        this.voltaje = voltaje;
        this.fuenteDeBateria = fuenteDeBateria;
        this.incluyeEstuche = incluyeEstuche;
        this.material = material;
        this.aplicacion = aplicacion;
        this.cantidadPiezas = cantidadPiezas;
    }

    // ==================== MÉTODOS ABSTRACTOS OBLIGATORIOS ====================
    /**
     * MÉTODO ABSTRACTO HEREDADO - Calcula el precio con IVA
     * @return double - Precio con IVA incluido (19% para herramientas)
     */
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para herramientas
        return this.getPrecio() * (1 + iva);
    }
    
    /**
     * MÉTODO ABSTRACTO HEREDADO - Define la categoría del producto
     * @return String - Categoría específica para herramientas
     */
    @Override
    public String getTipoCategoria() {
        return "Herramienta Electrónica";
    }

    // ==================== MÉTODOS ESPECÍFICOS DE LA CLASE ====================
    /**
     * Determina el nivel de profesional según el tipo de herramienta
     * @return String - Nivel de profesionalidad
     */
    public String getNivelProfesional() {
        switch(tipoHerramienta.toLowerCase()) {
            case "desarmador de precisión":
            case "pinza de corte":
            case "sopladora":
                return "Profesional - Técnico Especializado";
            case "multímetro":
            case "osciloscopio":
            case "fuente de poder":
                return "Avanzado - Ingeniería/Reparación";
            case "kit de desarmadores":
            case "soldador básico":
                return "Intermedio - Aficionado/Estudiante";
            default:
                return "Básico - Hogar/Principiante";
        }
    }
    
    /**
     * Verifica si es herramienta de precisión (para electrónica delicada)
     * @return boolean - True si es de precisión
     */
    public boolean esDePrecision() {
        String[] herramientasPrecision = {
            "desarmador de precisión", "pinza", "tweezers", 
            "sonda", "microscopio", "lupa"
        };
        
        for (String herramienta : herramientasPrecision) {
            if (tipoHerramienta.toLowerCase().contains(herramienta)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Genera recomendación de seguridad según la herramienta
     * @return String - Recomendaciones de seguridad
     */
    public String getRecomendacionesSeguridad() {
        StringBuilder seguridad = new StringBuilder();
        
        if (voltaje > 50) {
            seguridad.append("• Usar guantes aislantes • ");
        }
        if (tipoHerramienta.toLowerCase().contains("soldador")) {
            seguridad.append("• Usar careta y guantes • ");
        }
        if (esDePrecision()) {
            seguridad.append("• Manipular con cuidado • ");
        }
        if (tipoFuenteEnergia.equals("Eléctrica")) {
            seguridad.append("• Verificar conexión a tierra • ");
        }
        
        return seguridad.length() > 0 ? seguridad.toString() : "Uso general seguro";
    }
    
    /**
     * Determina el tipo de mantenimiento requerido
     * @return String - Frecuencia de mantenimiento
     */
    public String getMantenimientoRequerido() {
        if (tipoHerramienta.toLowerCase().contains("soldador")) {
            return "Mensual - Limpieza de puntas";
        } else if (tipoFuenteEnergia.equals("Batería")) {
            return "Trimestral - Recarga/Cambio de baterías";
        } else if (esDePrecision()) {
            return "Semestral - Calibración y limpieza";
        } else {
            return "Anual - Revisión general";
        }
    }
    
    /**
     * Calcula el precio por pieza (para kits)
     * @return double - Precio por pieza individual
     */
    public double calcularPrecioPorPieza() {
        if (cantidadPiezas > 0) {
            return this.getPrecio() / cantidadPiezas;
        }
        return this.getPrecio();
    }
    
    /**
     * Verifica si es adecuada para principiantes
     * @return boolean - True si es fácil de usar
     */
    public boolean esParaPrincipiantes() {
        return !esDePrecision() && 
               !tipoHerramienta.toLowerCase().contains("soldador") &&
               voltaje <= 24;
    }

    // ==================== MÉTODOS QUE COMBINAN ATRIBUTOS PADRE + HIJA ====================
    /**
     * Información completa de la herramienta
     * @return String - Info combinada padre-hija
     */
    public String getInfoCompletaHerramienta() {
        return String.format(
            "%s %s - %s | Aplicación: %s | %d piezas | Nivel: %s",
            this.getMarca(),
            this.getModelo(),
            this.tipoHerramienta,
            this.aplicacion,
            this.cantidadPiezas,
            this.getNivelProfesional()
        );
    }
    
    /**
     * Verifica disponibilidad y condiciones de venta
     * @return boolean - True si está disponible para venta
     */
    public boolean estaDisponibleParaVenta() {
        return this.getStock() > 0 && 
               this.getPrecio() > 0 && 
               this.getGarantia() >= 0.5; // Mínimo 6 meses de garantía
    }

    // ==================== GETTERS Y SETTERS ====================
    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    public String getTipoFuenteEnergia() {
        return tipoFuenteEnergia;
    }

    public void setTipoFuenteEnergia(String tipoFuenteEnergia) {
        this.tipoFuenteEnergia = tipoFuenteEnergia;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public boolean isFuenteDeBateria() {
        return fuenteDeBateria;
    }

    public void setFuenteDeBateria(boolean fuenteDeBateria) {
        this.fuenteDeBateria = fuenteDeBateria;
    }

    public boolean isIncluyeEstuche() {
        return incluyeEstuche;
    }

    public void setIncluyeEstuche(boolean incluyeEstuche) {
        this.incluyeEstuche = incluyeEstuche;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    // ==================== MÉTODO toString ====================
    /**
     * Representación en string del objeto
     * @return String - Información formateada de la herramienta
     */
    @Override
    public String toString() {
        return String.format(
            "HERRAMIENTA ELECTRÓNICA [ID: %d] %s - %s\n" +
            "Tipo: %s | Aplicación: %s | Material: %s\n" +
            "Fuente: %s | Voltaje: %.1fV | Batería: %s | Estuche: %s\n" +
            "Piezas: %d | Nivel: %s | Precisión: %s\n" +
            "Precio: $%.2f | IVA: $%.2f | Stock: %d | Garantía: %.1f años\n" +
            "Mantenimiento: %s | Para principiantes: %s\n" +
            "Seguridad: %s",
            getId(), getNombre(), getMarca() + " " + getModelo(),
            tipoHerramienta, aplicacion, material,
            tipoFuenteEnergia, voltaje, fuenteDeBateria ? "Sí" : "No", 
            incluyeEstuche ? "Sí" : "No",
            cantidadPiezas, getNivelProfesional(), esDePrecision() ? "Alta" : "Estándar",
            getPrecio(), calcularPercioIVa(), getStock(), getGarantia(),
            getMantenimientoRequerido(), esParaPrincipiantes() ? "Sí" : "No",
            getRecomendacionesSeguridad()
        );
    }
}