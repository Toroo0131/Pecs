
package org.example;

import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Pez en Red");

        PezAnimacion panel = new PezAnimacion();

        ventana.add(panel);
        ventana.setSize(600,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        panel.aparecerPez(); // ← agrega esto para probar

        ServidorPez servidor = new ServidorPez(panel);
        servidor.start();
    }
}