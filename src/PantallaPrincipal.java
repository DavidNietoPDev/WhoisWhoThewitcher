
import QuienEsQuien.ReproductorMusica;
import QuienEsQuien.Personajes;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author David
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    ReproductorMusica music = new ReproductorMusica();
    File archivo = new File("jugadores.dat");
    File fichero = new File("personajes.dat");
    private boolean musicOn = false;
    private int volumenActual = 100;
    /**
     * Creates new form PantallaPrincipal
     */

  
    public PantallaPrincipal() {
        initComponents();
      
        music.playAudio("src/songs/principal.wav");
        musicOn = true;
        if (!fichero.exists()) {

            /*Instaciamos los objetos en una matriz*/
            Personajes personajes[][] = new Personajes[4][4];
            personajes[0][0] = new Personajes("Blanco", "Geralt", "Hombre", true, true, false, true);
            personajes[0][1] = new Personajes("Blanco", "Vesemir", "Hombre", true, true, true, false);
            personajes[0][2] = new Personajes("Blanco", "Keira", "Mujer", false, true, false, false);
            personajes[0][3] = new Personajes("Blanco", "Avallac", "Hombre", false, false, false, false);
            personajes[1][0] = new Personajes("Blanco", "Cirilla", "Mujer", true, true, false, false);
            personajes[1][1] = new Personajes("Pelirrojo", "Shani", "Mujer", false, false, false, false);
            personajes[1][2] = new Personajes("Pelirrojo", "Triss", "Mujer", false, true, false, false);
            personajes[1][3] = new Personajes("Pelirrojo", "Cerys", "Mujer", true, true, false, false);
            personajes[2][0] = new Personajes("Pelirrojo", "Hjalmar", "Hombre", true, true, false, true);
            personajes[2][1] = new Personajes("Moreno", "Yennefer", "Mujer", false, true, false, false);
            personajes[2][2] = new Personajes("Moreno", "Lambert", "Hombre", true, false, false, true);
            personajes[2][3] = new Personajes("Moreno", "Jaskier", "Hombre", false, false, true, false);
            personajes[3][0] = new Personajes("Moreno", "Fringilla", "Mujer", false, false, false, false);
            personajes[3][1] = new Personajes("Moreno", "Eskel", "Hombre", true, false, false, false);
            personajes[3][2] = new Personajes("Moreno", "Emhyr", "Hombre", false, true, false, false);
            personajes[3][3] = new Personajes("Pelirrojo", "Olgierd", "Hombre", true, false, false, true);

            /*Escribimos la matriz en el fichero con el método serializarPersonajes*/
            Personajes.serializarPersonajes("personajes.dat", personajes);
            System.out.println("Fichero cargado con éxito, iniciando el juego.");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        bNewGame = new javax.swing.JButton();
        bScores = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        bPlay = new javax.swing.JButton();
        bPause = new javax.swing.JButton();
        sVolum = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LTitulo.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        LTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LTitulo.setText("THE WITCHER: WHO IS WHO");
        LTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LTitulo);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/portada.jpg"))); // NOI18N
        jPanel3.add(jLabel1);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new java.awt.GridLayout(3, 0, 0, 20));

        bNewGame.setBackground(new java.awt.Color(77, 77, 77));
        bNewGame.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        bNewGame.setText("New Game");
        bNewGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNewGame.setPreferredSize(new java.awt.Dimension(115, 36));
        bNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNewGameMouseClicked(evt);
            }
        });
        bNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewGameActionPerformed(evt);
            }
        });
        jPanel8.add(bNewGame);

        bScores.setBackground(new java.awt.Color(77, 77, 77));
        bScores.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        bScores.setText("Scores");
        bScores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bScores.setPreferredSize(new java.awt.Dimension(115, 36));
        bScores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bScoresMouseClicked(evt);
            }
        });
        bScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bScoresActionPerformed(evt);
            }
        });
        jPanel8.add(bScores);

        bExit.setBackground(new java.awt.Color(77, 77, 77));
        bExit.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        bExit.setText("Exit");
        bExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bExit.setPreferredSize(new java.awt.Dimension(115, 36));
        bExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitMouseClicked(evt);
            }
        });
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });
        jPanel8.add(bExit);

        jPanel4.add(jPanel8);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        java.awt.GridBagLayout jPanel7Layout = new java.awt.GridBagLayout();
        jPanel7Layout.columnWidths = new int[] {10, 10, 10};
        jPanel7Layout.columnWeights = new double[] {10.0, 10.0, 10.0};
        jPanel7.setLayout(jPanel7Layout);

        bPlay.setBackground(new java.awt.Color(51, 51, 51));
        bPlay.setForeground(new java.awt.Color(51, 51, 51));
        bPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/play.png"))); // NOI18N
        bPlay.setAlignmentY(0.0F);
        bPlay.setBorder(null);
        bPlay.setIconTextGap(0);
        bPlay.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bPlay.setMinimumSize(new java.awt.Dimension(10, 10));
        bPlay.setName(""); // NOI18N
        bPlay.setPreferredSize(new java.awt.Dimension(28, 25));
        bPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPlayMouseClicked(evt);
            }
        });
        jPanel7.add(bPlay, new java.awt.GridBagConstraints());

        bPause.setBackground(new java.awt.Color(51, 51, 51));
        bPause.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bPause.setForeground(new java.awt.Color(51, 51, 51));
        bPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/pause.png"))); // NOI18N
        bPause.setAlignmentY(0.0F);
        bPause.setBorder(null);
        bPause.setBorderPainted(false);
        bPause.setName(""); // NOI18N
        bPause.setPreferredSize(new java.awt.Dimension(28, 25));
        bPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPauseMouseClicked(evt);
            }
        });
        jPanel7.add(bPause, new java.awt.GridBagConstraints());

        sVolum.setBackground(new java.awt.Color(51, 51, 51));
        sVolum.setMajorTickSpacing(10);
        sVolum.setMinimum(1);
        sVolum.setMinorTickSpacing(1);
        sVolum.setToolTipText("");
        sVolum.setValue(100);
        sVolum.setPreferredSize(new java.awt.Dimension(100, 16));
        sVolum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sVolumStateChanged(evt);
            }
        });
        jPanel7.add(sVolum, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewGameActionPerformed


        music.stopAudio("src/songs/principal.wav");
        PantallaJuego pantallaJuego = new PantallaJuego();
        pantallaJuego.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_bNewGameActionPerformed

    private void bScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bScoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bScoresActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bExitActionPerformed

    private void bNewGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNewGameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bNewGameMouseClicked

    private void bScoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bScoresMouseClicked
        Puntuaciones puntuaciones = new Puntuaciones();
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(this, "\"There are no saved scores yet, play a game..\"");
        } else {
            puntuaciones.setVisible(true);
            puntuaciones.toFront();
        }
    }//GEN-LAST:event_bScoresMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "\"Thanks for playing, see you soon!\"");
        System.exit(0);

    }//GEN-LAST:event_bExitMouseClicked

    private void bPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPauseMouseClicked

        music.stopAudio("src/songs/principal.wav");
        musicOn = false;
    }//GEN-LAST:event_bPauseMouseClicked

    private void bPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPlayMouseClicked
        if(!musicOn) {
            music.playAudio("src/songs/principal.wav");
            music.setVolumen(volumenActual);
            musicOn = true;
        }
    }//GEN-LAST:event_bPlayMouseClicked

    private void sVolumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sVolumStateChanged
        if (musicOn) {
        JSlider source = (JSlider) evt.getSource();
            volumenActual =  source.getValue();
            music.setVolumen( volumenActual);
        }
        
    }//GEN-LAST:event_sVolumStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTitulo;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bNewGame;
    private javax.swing.JButton bPause;
    private javax.swing.JButton bPlay;
    private javax.swing.JButton bScores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSlider sVolum;
    // End of variables declaration//GEN-END:variables
}
