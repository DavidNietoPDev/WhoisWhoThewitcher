package QuienEsQuien;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author David
 */
public class ReproductorMusica {
    private Clip music;
    
    public ReproductorMusica() {
    
    }
/** Método para iniciar la música en forma de loop y pasándole una ruta de dónde se encuentra el archiv
     * @param ruta**/
    public void playAudio(String ruta) {
        try {
            File audioFile = new File(ruta);
            music = AudioSystem.getClip();
            music.open(AudioSystem.getAudioInputStream(audioFile));
            music.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        }
    }
/**Método para para la música pasándole una rut
     * @param ruta*/
    public void stopAudio(String ruta) {
        if (music != null) {
            music.stop();
            music.close();
        }
    }

/**Método para bajar el volumen con la clase FloatContro
     * @param ruta*/
    public void bajarVolumen(String ruta) {
        if (music != null) {
            FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
            float currentGain = gainControl.getValue();
            float newGain = Math.max(currentGain - 5.0f, gainControl.getMinimum());
            gainControl.setValue(newGain);
        }
    }
    /**Lo mismo pero para subir el volumen
     * @param ruta */
    public void subirVolumen(String ruta) {
        if (music != null) {
            FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
            float currentGain = gainControl.getValue();
            float newGain = Math.min(currentGain + 5.0f, gainControl.getMaximum());
            gainControl.setValue(newGain);
        }
    }
    /**Método para cambiar el volumen
     * @param nuevoVolumen*/
    public void setVolumen(int nuevoVolumen) {
    if (music != null) {
        FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * nuevoVolumen / 100.0f) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }
}

}


