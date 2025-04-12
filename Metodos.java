package Dispositivos;

import javax.swing.*;

public class Metodos {

    public static void mostrarMenu() {
        while (true) {
            String[] opciones = {"Agregar", "Prestar", "Devolver", "Ver Inventario", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "¿Qué deseas hacer?",
                    "Menú de Inventario",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0 -> agregarDispositivo();
                case 1 -> prestarDispositivo();
                case 2 -> devolverDispositivo();
                case 3 -> verInventario();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "👋 ¡Hasta luego!");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void agregarDispositivo() {
        String tipo = JOptionPane.showInputDialog("Tipo (PC o Tablet):");
        if (tipo == null) return;
    
        tipo = tipo.trim().toLowerCase();
        if (!tipo.equals("pc") && !tipo.equals("tablet")) {
            JOptionPane.showMessageDialog(null, "❌ Tipo no válido. Solo se acepta 'PC' o 'Tablet'.");
            return;
        }
    
    
        String serial = JOptionPane.showInputDialog("Serial:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String estudiante = JOptionPane.showInputDialog("Nombre del estudiante:");
    
        if (serial != null && marca != null && estudiante != null) {
            Dispositivo d = new Dispositivo(tipo, serial, marca, estudiante);
            GestorInventario.agregar(d);
            JOptionPane.showMessageDialog(null, "✅ Dispositivo agregado:\n" + d);
        }
    }
    

    private static void prestarDispositivo() {
        Dispositivo d = GestorInventario.prestar();
        if (d != null) {
            JOptionPane.showMessageDialog(null, "📤 Prestado:\n" + d);
        } else {
            JOptionPane.showMessageDialog(null, "❌ No hay dispositivos disponibles.");
        }
    }

    private static void devolverDispositivo() {
        Dispositivo d = GestorInventario.devolver();
        if (d != null) {
            JOptionPane.showMessageDialog(null, "📥 Devuelto:\n" + d);
        } else {
            JOptionPane.showMessageDialog(null, "❌ No hay dispositivos prestados.");
        }
    }

    private static void verInventario() {
        StringBuilder info = new StringBuilder();
        info.append("📦 Disponibles:\n");
        for (Dispositivo d : GestorInventario.colaDisponibles) {
            info.append("• ").append(d).append("\n");
        }

        info.append("\n📤 Prestados:\n");
        for (Dispositivo d : GestorInventario.colaPrestados) {
            info.append("• ").append(d).append("\n");
        }

        JOptionPane.showMessageDialog(null, info.toString());
    }
}
