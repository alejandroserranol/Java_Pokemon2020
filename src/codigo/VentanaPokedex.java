package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1, buffer2 = null;
    Image imagen1, imagen2 = null;
    int contadorPokemon = 0;
    int contadorCaracteristicas = 0;

    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;

    //estructura para guardar todo el contenido de la base de datos de golpe
    HashMap<String, Pokemon> listaPokemons = new HashMap();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) imagen1.getGraphics();
        g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        tipoPokemon.setText("Tipo");
        pokedex_fondo.setSize(762, 512);
        pokedex_fondo.setBackground(Color.RED);

        //imágenes de los pokemons
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }

        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();

        
        try {
//            Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon));
//            dibujaElPokemonQueEstaEnLaPosicion(contadorPokemon);
//            nombrePokemon.setText(p.nombre); //no funciona
//            numPokemon.setText(p.id);
//            nomInformacion.setText("altura");
//            informacion.setText(p.altura);
        } catch (Exception e) {
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/pokedex", "root", "");
            estado = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("Select * from pokemon");
            //recorremos el array del resultado uno a uno para ir cargándolo in el Hashmap

            while (resultadoConsulta.next()) {
                Pokemon p = new Pokemon();
                p.id = resultadoConsulta.getString("id");
                p.nombre = resultadoConsulta.getString("nombre");
                p.altura = resultadoConsulta.getString("altura");
                p.peso = resultadoConsulta.getString("peso"); //getDouble si no string
                p.especie = resultadoConsulta.getString("especie");
                p.habitat = resultadoConsulta.getString("habitat");
                p.preEvolucion = resultadoConsulta.getString("preEvolucion"); //getInt si no 
                p.posEvolucion = resultadoConsulta.getString("posEvolucion");
                p.descripcion = resultadoConsulta.getString("descripcion");
                p.tipo1 = resultadoConsulta.getString("tipo1");
                p.tipo2 = resultadoConsulta.getString("tipo2");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.movimiento2 = resultadoConsulta.getString("movimiento2");
                p.movimiento3 = resultadoConsulta.getString("movimiento3");
                p.movimiento4 = resultadoConsulta.getString("movimiento4");

                //añado el pokemon recien creado al Hashmap
                listaPokemons.put(resultadoConsulta.getString("id"), p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hay un error");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel
                0, // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
        );
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pokedex_fondo = new javax.swing.JPanel();
        fondo_negro = new javax.swing.JLabel();
        imagenPokemon = new javax.swing.JLabel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();
        numPokemon = new javax.swing.JLabel();
        izqInfo = new javax.swing.JButton();
        derInfo = new javax.swing.JButton();
        shiny = new javax.swing.JCheckBox();
        nomInformacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacion = new javax.swing.JTextArea();
        movimiento1 = new javax.swing.JLabel();
        movimiento2 = new javax.swing.JLabel();
        movimiento3 = new javax.swing.JLabel();
        movimiento4 = new javax.swing.JLabel();
        tipoPokemon = new javax.swing.JLabel();
        tipo1 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        num0 = new javax.swing.JButton();
        num1 = new javax.swing.JButton();
        num2 = new javax.swing.JButton();
        num3 = new javax.swing.JButton();
        num4 = new javax.swing.JButton();
        num5 = new javax.swing.JButton();
        num6 = new javax.swing.JButton();
        num7 = new javax.swing.JButton();
        num8 = new javax.swing.JButton();
        num9 = new javax.swing.JButton();
        pokedex_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pokedex_fondo.setMaximumSize(new java.awt.Dimension(425, 280));
        pokedex_fondo.setMinimumSize(new java.awt.Dimension(425, 280));
        pokedex_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo_negro.setBackground(new java.awt.Color(0, 0, 0));
        fondo_negro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo_negro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176), 15));
        fondo_negro.setOpaque(true);
        pokedex_fondo.add(fondo_negro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 270, 170));

        imagenPokemon.setBackground(new java.awt.Color(0, 0, 0));
        imagenPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pokedex_fondo.add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 150, 130));

        izq.setBorderPainted(false);
        izq.setContentAreaFilled(false);
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        pokedex_fondo.add(izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 30, 40));

        der.setBorderPainted(false);
        der.setContentAreaFilled(false);
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        pokedex_fondo.add(der, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 40, 40));

        nombrePokemon.setBackground(new java.awt.Color(176, 176, 176));
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setOpaque(true);
        pokedex_fondo.add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 90, 30));

        numPokemon.setBackground(new java.awt.Color(255, 255, 255));
        numPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPokemon.setOpaque(true);
        pokedex_fondo.add(numPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 60, 30));

        izqInfo.setBorderPainted(false);
        izqInfo.setContentAreaFilled(false);
        izqInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqInfoActionPerformed(evt);
            }
        });
        pokedex_fondo.add(izqInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 40, 30));

        derInfo.setBorderPainted(false);
        derInfo.setContentAreaFilled(false);
        derInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derInfoActionPerformed(evt);
            }
        });
        pokedex_fondo.add(derInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 50, 30));

        shiny.setOpaque(false);
        pokedex_fondo.add(shiny, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 50, 30));

        nomInformacion.setBackground(new java.awt.Color(0, 0, 0));
        nomInformacion.setForeground(new java.awt.Color(176, 176, 176));
        nomInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomInformacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176)));
        nomInformacion.setOpaque(true);
        pokedex_fondo.add(nomInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 90, 30));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176)));

        informacion.setBackground(new java.awt.Color(0, 0, 0));
        informacion.setColumns(20);
        informacion.setForeground(new java.awt.Color(176, 176, 176));
        informacion.setRows(5);
        informacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(176, 176, 176), 3, true));
        jScrollPane1.setViewportView(informacion);

        pokedex_fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 320, 50));

        movimiento1.setBackground(new java.awt.Color(0, 0, 0));
        movimiento1.setForeground(new java.awt.Color(176, 176, 176));
        movimiento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176), 3));
        movimiento1.setOpaque(true);
        pokedex_fondo.add(movimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 160, 50));

        movimiento2.setBackground(new java.awt.Color(0, 0, 0));
        movimiento2.setForeground(new java.awt.Color(176, 176, 176));
        movimiento2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176), 3));
        movimiento2.setOpaque(true);
        pokedex_fondo.add(movimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 160, 50));

        movimiento3.setBackground(new java.awt.Color(0, 0, 0));
        movimiento3.setForeground(new java.awt.Color(176, 176, 176));
        movimiento3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176), 3));
        movimiento3.setOpaque(true);
        pokedex_fondo.add(movimiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 160, 50));

        movimiento4.setBackground(new java.awt.Color(0, 0, 0));
        movimiento4.setForeground(new java.awt.Color(176, 176, 176));
        movimiento4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 176, 176), 3));
        movimiento4.setOpaque(true);
        pokedex_fondo.add(movimiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 160, 50));

        tipoPokemon.setBackground(new java.awt.Color(176, 176, 176));
        tipoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoPokemon.setOpaque(true);
        pokedex_fondo.add(tipoPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 100, 30));

        tipo1.setBackground(new java.awt.Color(255, 195, 2));
        tipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pokedex_fondo.add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 80, 30));

        tipo2.setBackground(new java.awt.Color(255, 190, 2));
        tipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pokedex_fondo.add(tipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 80, 30));

        num0.setText("0");
        num0.setBorderPainted(false);
        num0.setContentAreaFilled(false);
        pokedex_fondo.add(num0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 50, 30));

        num1.setText("1");
        num1.setBorderPainted(false);
        num1.setContentAreaFilled(false);
        pokedex_fondo.add(num1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 50, 30));

        num2.setText("2");
        num2.setBorderPainted(false);
        num2.setContentAreaFilled(false);
        pokedex_fondo.add(num2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, 30));

        num3.setText("3");
        num3.setBorderPainted(false);
        num3.setContentAreaFilled(false);
        pokedex_fondo.add(num3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 50, 30));

        num4.setText("4");
        num4.setBorderPainted(false);
        num4.setContentAreaFilled(false);
        num4.setOpaque(false);
        pokedex_fondo.add(num4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 50, 30));

        num5.setText("5");
        num5.setBorderPainted(false);
        num5.setContentAreaFilled(false);
        pokedex_fondo.add(num5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 50, 30));

        num6.setText("6");
        num6.setBorderPainted(false);
        num6.setContentAreaFilled(false);
        pokedex_fondo.add(num6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 50, 30));

        num7.setText("7");
        num7.setBorderPainted(false);
        num7.setContentAreaFilled(false);
        pokedex_fondo.add(num7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 50, 30));

        num8.setText("8");
        num8.setBorderPainted(false);
        num8.setContentAreaFilled(false);
        pokedex_fondo.add(num8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 50, 30));

        num9.setText("9");
        num9.setBorderPainted(false);
        num9.setContentAreaFilled(false);
        pokedex_fondo.add(num9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 50, 30));

        pokedex_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex.png"))); // NOI18N
        pokedex_icon.setOpaque(true);
        pokedex_fondo.add(pokedex_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pokedex_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pokedex_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contadorPokemon--;
        
        dibujaElPokemonQueEstaEnLaPosicion(contadorPokemon-1);
        
        
        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon));
        if (p != null) {
            nombrePokemon.setText(p.nombre);
            numPokemon.setText(p.id);
            tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);
            movimiento1.setText(p.movimiento1);
            movimiento2.setText(p.movimiento2);
            movimiento3.setText(p.movimiento3);
            movimiento4.setText(p.movimiento4);
            nomInformacion.setText("altura");
            informacion.setText(p.altura);
            contadorCaracteristicas = 1;
        } else {
            nombrePokemon.setText("NO capturado");
        }

        if (contadorPokemon <= 0) {
            contadorPokemon = 0;
        }
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        contadorPokemon++;
        
        dibujaElPokemonQueEstaEnLaPosicion(contadorPokemon-1); //porque en el PNG los pokemon empiezan en el 0 y el 

        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon));
        if (p != null) {
            nombrePokemon.setText(p.nombre);
            numPokemon.setText(p.id);
            tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);
            movimiento1.setText(p.movimiento1);
            movimiento2.setText(p.movimiento2);
            movimiento3.setText(p.movimiento3);
            movimiento4.setText(p.movimiento4);
            nomInformacion.setText("altura");
            informacion.setText(p.altura);
            contadorCaracteristicas = 1;
        } else {
            nombrePokemon.setText("NO capturado");
        }

        if (contadorPokemon >= 648) {
            contadorPokemon = 648;
        }


    }//GEN-LAST:event_derActionPerformed

    private void izqInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqInfoActionPerformed
        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon));

        if (contadorCaracteristicas > 1) {
            contadorCaracteristicas--;
        }

        switch (contadorCaracteristicas) {
            case 1:
                nomInformacion.setText("altura");
                informacion.setText(p.altura);
                break;
            case 2:
                nomInformacion.setText("peso");
                informacion.setText(p.peso);
                break;
            case 3:
                nomInformacion.setText("especie");
                informacion.setText(p.especie);
                break;
            case 4:
                nomInformacion.setText("habitat");
                informacion.setText(p.habitat);
                break;
            case 5:
                nomInformacion.setText("preEvolucion");
                informacion.setText(p.preEvolucion);
                break;
            case 6:
                nomInformacion.setText("posEvolucion");
                informacion.setText(p.posEvolucion);
                break;
            case 7:
                nomInformacion.setText("descripcion");
                informacion.setText(p.descripcion);
                break;
            default:
                break;
        }

    }//GEN-LAST:event_izqInfoActionPerformed

    private void derInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derInfoActionPerformed
        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon));

        if (contadorCaracteristicas < 7) {
            contadorCaracteristicas++;
        }

        switch (contadorCaracteristicas) {
            case 1:
                nomInformacion.setText("altura");
                informacion.setText(p.altura);
                break;
            case 2:
                nomInformacion.setText("peso");
                informacion.setText(p.peso);
                break;
            case 3:
                nomInformacion.setText("especie");
                informacion.setText(p.especie);
                break;
            case 4:
                nomInformacion.setText("habitat");
                informacion.setText(p.habitat);
                break;
            case 5:
                nomInformacion.setText("preEvolucion");
                informacion.setText(p.preEvolucion);
                break;
            case 6:
                nomInformacion.setText("posEvolucion");
                informacion.setText(p.posEvolucion);
                break;
            case 7:
                nomInformacion.setText("descripcion");
                informacion.setText(p.descripcion);
                break;
            default:
                break;
        }

    }//GEN-LAST:event_derInfoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton der;
    private javax.swing.JButton derInfo;
    private javax.swing.JLabel fondo_negro;
    private javax.swing.JLabel imagenPokemon;
    private javax.swing.JTextArea informacion;
    private javax.swing.JButton izq;
    private javax.swing.JButton izqInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel movimiento1;
    private javax.swing.JLabel movimiento2;
    private javax.swing.JLabel movimiento3;
    private javax.swing.JLabel movimiento4;
    private javax.swing.JLabel nomInformacion;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JButton num0;
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
    private javax.swing.JLabel numPokemon;
    private javax.swing.JPanel pokedex_fondo;
    private javax.swing.JLabel pokedex_icon;
    private javax.swing.JCheckBox shiny;
    private javax.swing.JLabel tipo1;
    private javax.swing.JLabel tipo2;
    private javax.swing.JLabel tipoPokemon;
    // End of variables declaration//GEN-END:variables
}
