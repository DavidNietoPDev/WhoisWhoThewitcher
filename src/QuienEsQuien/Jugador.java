
package QuienEsQuien;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Jugador implements Serializable{
    /**Atributos del jugador serán las iniciales y la puntuación*/
    private String iniciales;
    private int puntuacion;
    private static final long serialVersionUID = 1L;
/**Constructor con parámetro para las iniciales y puntuacion
     * @param iniciales
     * @param puntuacion*/
    public Jugador(String iniciales, int puntuacion) {
        this.iniciales = iniciales;
        /**La puntuación comenzará en 0 e irá aumentando por cada pregunta realizada
        y por cada intento fallido de adivinar el personaje, siendo el que tenga la puntuación más baja el ganador
        */
        this.puntuacion = puntuacion;
    }
/**Métodos get para obtener información de los atributo
     * @return s*/
    public String getIniciales() {
        return iniciales;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
/**Métodos set por si hay que modificar algún atribut
     * @param iniciales*/
    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    @Override
    public String toString() {
        return   iniciales + "  ==>  " + puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    /*Método para mostrar las puntuaciones en labels directamente según el número de puntuaciones
    que haya guardados en el fichero.
    **/
    public static void mostrarPuntuaciones(String ruta, List<JLabel> labels) {

        FileInputStream archivo = null;
        ObjectInputStream salida = null;
        List<Jugador> jugadores = new ArrayList<>();

        try {
            archivo = new FileInputStream(ruta);
            salida = new ObjectInputStream(archivo);
            // Leer los jugadores del archivo y agregarlos a la lista
            while (true) {
                Jugador jugador = (Jugador) salida.readObject();
                jugadores.add(jugador);
            }
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.toString());
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
                if (archivo != null) {
                    archivo.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura: " + e.toString());
            }
        }
        /*Por cada jugador en la lista de puntuaciones se mete en un label**/
        for (int i = 0; i < labels.size(); i++) {
            if (i < jugadores.size()) {
                labels.get(i).setText(jugadores.get(i).toString());
            } else {
                labels.get(i).setText("No hay puntuación");
            }
        }
    }
    
    /* Método para guardar jugadores y sus puntuaciones*/
    public static void guardarPuntuaciones(String ruta, int puntuacion) {

        File docu = new File("jugadores.dat");
        FileInputStream archivoLectura = null;
        ObjectInputStream entrada = null;
        FileOutputStream archivoEscritura = null;
        ObjectOutputStream salida = null;
        List<Jugador> jugadores = new ArrayList<>();
        if (docu.exists()) {
            try {
                archivoLectura = new FileInputStream(ruta);
                entrada = new ObjectInputStream(archivoLectura);
                // Leer los jugadores del archivo y agregarlos a la lista
                while (true) {
                    Jugador jugador = (Jugador) entrada.readObject();
                    jugadores.add(jugador);
                }
            } catch (EOFException e) {

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.toString());
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (archivoLectura != null) {
                        archivoLectura.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo de lectura: " + e.toString());
                }
            }
        }
        // Agregar el nuevo jugador a la lista si no coinciden las iniciales con ningún jugador ya creado y si tiene mínimo 3 caracteres

        boolean disponible = false;
        do {
            String iniciales = JOptionPane.showInputDialog("Introduce tu alias a continuación, mínimo 3 letras: \n");
            if (iniciales.length() < 3) {
                JOptionPane.showMessageDialog(null, "Las iniciales deben tener al menos 3 letras.");
                continue;
            }
            //Comparamos las iniciales indicadas por las ya guardadas en el fichero
            if (jugadores.stream().anyMatch(jugador -> jugador.getIniciales().equalsIgnoreCase(iniciales))) {
                JOptionPane.showMessageDialog(null, "El nombre que quieres poner no está disponible.");
            } else {
                Jugador j = new Jugador(iniciales, puntuacion);
                jugadores.add(j);
                disponible = true;
                System.out.println("Datos guardados en puntuaciones correctamente.");
            }
        } while (!disponible);

        // Ordenar la lista por la puntuación de los jugadores de menor a mayor
        Collections.sort(jugadores, Comparator.comparingInt(Jugador::getPuntuacion));

        //Si hay más de 10 puntuaciones una vez ordenadas, se borra la 11
        if (jugadores.size() > 10) {
            jugadores.remove(jugadores.size() - 1);
        }

        try {
            archivoEscritura = new FileOutputStream(ruta);
            salida = new ObjectOutputStream(archivoEscritura);
            // Escribir los jugadores ordenados en el archivo
            for (Jugador jugador : jugadores) {
                salida.writeObject(jugador);
            }
        } catch (IOException e) {
            System.out.println("Error de guardado: " + e.toString());
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
                if (archivoEscritura != null) {
                    archivoEscritura.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de escritura: " + e.toString());
            }
        }
    }
}
