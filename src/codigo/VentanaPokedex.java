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

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contadorPokemon = 0;
    int contadorCaracteristicas = 3;

    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    //estructura para guardar todo el contenido de la base de datos de golpe
    HashMap<String, Pokemon> listaPokemons = new HashMap();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        pokedex_fondo.setBackground(Color.RED);
        caracteristicas.setBackground(Color.RED);
        descripcion.setVisible(false);
        descripcion.setForeground(Color.GRAY);
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        

        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();

        dibujaElPokemonQueEstaEnLaPosicion(0);
        nombrePokemon.setText("Bulbasaur");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/pokedex", "root", "");
            estado = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("Select * from pokemon");
            //recorremos el array del resultado uno a uno para ir cargándolo in el Hashmap
            
            while(resultadoConsulta.next()){
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString("nombre");
                p.especie = resultadoConsulta.getString("especie");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.peso = resultadoConsulta.getString("peso"); //getDouble si no string
                p.preEvolucion = resultadoConsulta.getString("preEvolucion"); //getInt si no 
                p.posEvolucion = resultadoConsulta.getString("posEvolucion");
                
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
        g2.setColor(Color.black);
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
        imagenPokemon = new javax.swing.JLabel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();
        izqInfo = new javax.swing.JButton();
        derInfo = new javax.swing.JButton();
        caracteristicas = new javax.swing.JLabel();
        descripcion = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pokedex_fondo.setMaximumSize(new java.awt.Dimension(425, 280));
        pokedex_fondo.setMinimumSize(new java.awt.Dimension(425, 280));

        imagenPokemon.setBackground(new java.awt.Color(0, 0, 0));

        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        nombrePokemon.setBackground(new java.awt.Color(255, 255, 255));
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        izqInfo.setText("<");
        izqInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqInfoActionPerformed(evt);
            }
        });

        derInfo.setText(">");
        derInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derInfoActionPerformed(evt);
            }
        });

        caracteristicas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caracteristicas.setEnabled(false);
        caracteristicas.setOpaque(true);

        javax.swing.GroupLayout pokedex_fondoLayout = new javax.swing.GroupLayout(pokedex_fondo);
        pokedex_fondo.setLayout(pokedex_fondoLayout);
        pokedex_fondoLayout.setHorizontalGroup(
            pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pokedex_fondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pokedex_fondoLayout.createSequentialGroup()
                        .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombrePokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(imagenPokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pokedex_fondoLayout.createSequentialGroup()
                                .addComponent(izqInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(derInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(caracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pokedex_fondoLayout.createSequentialGroup()
                        .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pokedex_fondoLayout.setVerticalGroup(
            pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pokedex_fondoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(caracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(nombrePokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pokedex_fondoLayout.createSequentialGroup()
                        .addComponent(descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(izqInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(derInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pokedex_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
        if (contadorPokemon <= 0) {
            contadorPokemon = 0;
        }
        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon+1));     
        if(p != null){
            nombrePokemon.setText(p.nombre);
        } else {
            nombrePokemon.setText("Pokemon NO capturado");
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contadorPokemon);
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        contadorPokemon++;
        dibujaElPokemonQueEstaEnLaPosicion(contadorPokemon); //porque en el PNG los pokemon empiezan en el 0 y el 
        
        Pokemon p = listaPokemons.get(String.valueOf(contadorPokemon+1));     
        if(p != null){
            nombrePokemon.setText(p.nombre);
        } else {
            nombrePokemon.setText("Pokemon NO capturado");
        }
        
        if (contadorPokemon >= 648) {
            contadorPokemon = 648;
        }
        
        
    }//GEN-LAST:event_derActionPerformed

    private void izqInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_izqInfoActionPerformed

    private void derInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derInfoActionPerformed
//        if (contadorCaracteristicas < 16) {
//            try {
//                resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contadorPokemon));
//                if (resultadoConsulta.next()) {
//                    nombrePokemon.setText(resultadoConsulta.getString(2));
//                    caracteristicas.setVisible(true);
//                    caracteristicas.setBackground(Color.BLACK);
//                    caracteristicas.setText(resultadoConsulta.getString(contadorCaracteristicas));
//                } else {
//                    nombrePokemon.setText("Este Pokemon no figura en la Pokedex");
//                }
//            } catch (SQLException ex) {
//            }
//            contadorCaracteristicas++;
//        } else {
//            try {
//                resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contadorPokemon));
//                if (resultadoConsulta.next()) {
//                    nombrePokemon.setText(resultadoConsulta.getString(2));
//                    caracteristicas.setVisible(false);
//                    descripcion.setVisible(true);
//                    descripcion.setBackground(Color.BLACK);
//                    descripcion.setText(resultadoConsulta.getString(contadorCaracteristicas));
//                } else {
//                    nombrePokemon.setText("Este Pokemon no figura en la Pokedex");
//                }
//            } catch (SQLException ex) {
//            }
//        }
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
    private javax.swing.JLabel caracteristicas;
    private javax.swing.JButton der;
    private javax.swing.JButton derInfo;
    private java.awt.TextArea descripcion;
    private javax.swing.JLabel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JButton izqInfo;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JPanel pokedex_fondo;
    // End of variables declaration//GEN-END:variables
}
