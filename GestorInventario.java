package Dispositivos;

import java.util.LinkedList;
import java.util.Queue;

public class GestorInventario {
    public static Queue<Dispositivo> colaDisponibles = new LinkedList<>();
    public static Queue<Dispositivo> colaPrestados = new LinkedList<>();

    public static void agregar(Dispositivo d) {
        colaDisponibles.add(d);
    }

    public static Dispositivo prestar() {
        Dispositivo d = colaDisponibles.poll();
        if (d != null) {
            colaPrestados.add(d);
        }
        return d;
    }

    public static Dispositivo devolver() {
        Dispositivo d = colaPrestados.poll();
        if (d != null) {
            colaDisponibles.add(d);
        }
        return d;
    }
}
