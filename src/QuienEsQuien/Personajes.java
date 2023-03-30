
package QuienEsQuien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author David
 */
public class Personajes implements Serializable {
    /**Atributos final porque no se podrán cambiar*/
    private final String colorPelo, nombre, genero;
    private final boolean  cicatrices, peloLargo, bigote, barba;
    private static final long serialVersionUID = 1L;
    
/**Constructor por parámetro
     * @param colorPelo
     * @param nombre
     * @param genero
     * @param cicatrices
     * @param peloLargo
     * @param bigote
     * @param barba*/
    public Personajes(String colorPelo, String nombre, String genero, boolean cicatrices, boolean peloLargo, boolean bigote, boolean barba) {
        this.colorPelo = colorPelo;
        this.genero = genero;
        this.cicatrices = cicatrices;
        this.peloLargo = peloLargo;
        this.bigote = bigote;
        this.barba = barba;
        this.nombre = nombre;
    }
/*Métodos get para obtener atributos de cada objeto*/
    public String getNombre() {
        return nombre;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isCicatrices() {
        return cicatrices;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public boolean isBigote() {
        return bigote;
    }

    public boolean isBarba() {
        return barba;
    }
    //Método usado para mostrarNombres por consola
    /*public void mostrarNombres(String ruta) {
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;
        try {
            fichero = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fichero);
            Personajes[][] matrizPersonajes = (Personajes[][]) entrada.readObject();
            for (int i = 0; i < matrizPersonajes.length; i++) {
                for (int j = 0; j < matrizPersonajes[i].length; j++) {
                    System.out.print(matrizPersonajes[i][j].getNombre() + "\t\t\t\t");
                }
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.toString());
            }
        }

    }*/
    
   

     /**Método para serializar Personajes y guardarlos en fichero binario como objeto
     * @param ruta
     * @param p*/
    public static void serializarPersonajes(String ruta, Personajes[][] p) {
        FileOutputStream fichero = null;
        ObjectOutputStream entrada = null;
        try {
            fichero = new FileOutputStream(ruta);
            entrada = new ObjectOutputStream(fichero);
            entrada.writeObject(p);
        } catch (IOException e) {
            System.out.println("Error de serializar 1: " + e.toString());
        } finally {
            try {

                if (entrada != null) {
                    entrada.close();
                }
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println("Error de seiralizar cierre: " + e.toString());
            }
        }
    }
     /** Método para seleccionar aleatoriamente un personaje que será la solución y que se pueda trabajar con e
     * @return l*/
    public static Personajes mostrarSolucion() {
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;
        Personajes[][] matrizPersonajes = null;
        //Mete los personajes del fichero en una matriz
        try {
            fichero = new FileInputStream("Personajes.dat");
            entrada = new ObjectInputStream(fichero);
            matrizPersonajes = (Personajes[][]) entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.toString());
            }
        }
        //Selecciona dos números random de 0 a 4 que corresponden con las filas y las columnas de la matriz
        int randomF = (int) (Math.random() * matrizPersonajes.length);
        int randomC = (int) (Math.random() * matrizPersonajes.length);
        //Regresa el personaje aleatorio para poder trabajar con el
        return matrizPersonajes[randomF][randomC];
    }

    
}
