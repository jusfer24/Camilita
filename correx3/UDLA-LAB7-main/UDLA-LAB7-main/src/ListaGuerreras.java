import javax.swing.*;
import java.util.LinkedList;

public class ListaGuerreras {
    private LinkedList<GuerreraBrightMoon> lista = new LinkedList<>();

    public boolean agregar(GuerreraBrightMoon g) {
        for (GuerreraBrightMoon guerrera : lista) {
            if (guerrera.getId() == g.getId()) {
                return false; // Ya existe una con ese ID
            }
        }

        // Insertar ordenado por ID
        int i = 0;
        while (i < lista.size() && lista.get(i).getId() < g.getId()) {
            i++;
        }
        lista.add(i, g);
        return true;
    }

    public void eliminar(int id, JTextArea salida) {
        boolean encontrada = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                salida.append("Guerrera eliminada.\n");
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            salida.append("Guerrera no encontrada.\n");
        }
    }

    public GuerreraBrightMoon buscarPorID(int id) {
        for (GuerreraBrightMoon g : lista) {
            if (g.getId() == id) return g;
        }
        return null;
    }

    public int buscar(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) return i;
        }
        return -1;
    }

    public void ordenarPorNivelEstrategia(JTextArea salida) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j).getNivelEstrategia() > lista.get(maxIdx).getNivelEstrategia()) {
                    maxIdx = j;
                }
            }
            GuerreraBrightMoon temp = lista.get(i);
            lista.set(i, lista.get(maxIdx));
            lista.set(maxIdx, temp);
        }
        salida.append("Lista ordenada por Nivel de Estrategia.\n");
    }

    public void mostrarLista(JTextArea salida) {
        salida.setText("");
        for (GuerreraBrightMoon g : lista) {
            salida.append("ID: " + g.getId() + ", Alias: " + g.getAlias() +
                    ", Poder: " + g.getPoderBatalla() + ", Estrategia: " +
                    g.getNivelEstrategia() + ", Ubicación: " + g.getUbicacion() + "\n");
        }
    }

    public String formatoLista() {
        StringBuilder sb = new StringBuilder();
        for (GuerreraBrightMoon g : lista) {
            sb.append("ID: ").append(g.getId()).append("\n")
                    .append("Alias: ").append(g.getAlias()).append("\n")
                    .append("Poder: ").append(g.getPoderBatalla()).append("\n")
                    .append("Estrategia: ").append(g.getNivelEstrategia()).append("\n")
                    .append("Ubicación: ").append(g.getUbicacion()).append("\n\n");
        }
        return sb.toString();
    }

    public LinkedList<GuerreraBrightMoon> filtrarPorPoder(String poder) {
        LinkedList<GuerreraBrightMoon> filtradas = new LinkedList<>();
        for (GuerreraBrightMoon g : lista) {
        }
        return filtradas;
    }

    public int contarPorUbicacion(String ubicacion) {
        return contarPorUbicacion(ubicacion, 0);
    }

    private int contarPorUbicacion(String ubicacion, int index) {
        if (index >= lista.size()) return 0;
        GuerreraBrightMoon g = lista.get(index);
        int suma = g.getUbicacion().equals(ubicacion) ? 1 : 0;
        return suma + contarPorUbicacion(ubicacion, index + 1);
    }

    public LinkedList<GuerreraBrightMoon> getLista() {
        return lista;
    }


}
