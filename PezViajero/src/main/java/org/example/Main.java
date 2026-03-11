package org.example;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        int miPuerto = Integer.parseInt(args[0]);
        int puertoDestino = Integer.parseInt(args[1]);
        boolean iniciar = Boolean.parseBoolean(args[2]);

        JFrame ventana = new JFrame("Pez en Red");

        PezAnimacion panel = new PezAnimacion(puertoDestino);

        ventana.add(panel);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        if(iniciar){
            panel.aparecerPez();
        }

        ServidorPez servidor = new ServidorPez(panel, miPuerto);
        servidor.start();
    }
}